package microsoft_excel_design.cell_strategy;

import microsoft_excel_design.Cell;

public class CellValueStrategy implements CellStrategy {

    @Override
    public String evaluate(Cell cell) {
        return cell.getValue();
    }
}
