package microsoft_excel_design;

import microsoft_excel_design.cell_strategy.CellStrategy;
import microsoft_excel_design.cell_strategy.CellValueStrategy;
import microsoft_excel_design.cell_strategy.FormulaCellStrategy;
import microsoft_excel_design.enums.CellType;

import java.util.Stack;

public class Cell {
    String value;
    CellType type;
    CellStrategy cellStrategy;
    Stack<CellState> undoHistory;
    Stack<CellState> redoHistory;

    public Cell(String value, CellType type) {
        this.value = value;
        this.type = type;
        this.cellStrategy = (type.equals(CellType.VALUE)) ? new CellValueStrategy() : new FormulaCellStrategy();
        undoHistory = new Stack<>();
        redoHistory = new Stack<>();
    }

    public String getValue() {
        return value;
    }

    public String evaluate() {
        return cellStrategy.evaluate(this);
    }

    public void setValue(String value, CellType type) {
        saveState();
        this.value = value;
        this.type = type;
        this.cellStrategy = (type.equals(CellType.VALUE)) ? new CellValueStrategy() : new FormulaCellStrategy();
        redoHistory.clear();
    }

    public void undo() {
        if (!undoHistory.isEmpty()) {
            redoHistory.push(new CellState(value,type));
            CellState prevState = undoHistory.pop();
            changeState(prevState);
        }
    }

    public void redo() {
        if (!redoHistory.isEmpty()) {
            undoHistory.push(new CellState(value,type));
            CellState nextState = redoHistory.pop();
            changeState(nextState);
        }
    }

    private void changeState(CellState prevState) {
        value = prevState.getValue();
        type = prevState.getCellType();
        this.cellStrategy = (type.equals(CellType.VALUE)) ? new CellValueStrategy() : new FormulaCellStrategy();
    }

    public void saveState() {
        undoHistory.push(new CellState(value,type));
    }
}
