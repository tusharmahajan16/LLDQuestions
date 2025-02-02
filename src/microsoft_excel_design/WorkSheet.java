package microsoft_excel_design;

import microsoft_excel_design.enums.CellType;

import java.util.HashMap;
import java.util.Map;

public class WorkSheet {

    String sheetName;

    Map<Integer, Map<Integer, Cell>> sheet;

    public WorkSheet(String sheetName) {
        this.sheetName = sheetName;
        sheet = new HashMap<>();
    }

    public String getSheetName() {
        return sheetName;
    }

    public void setSheetName(String sheetName) {
        this.sheetName = sheetName;
    }

    public void setValue(int row, int col, String value) {
        if (sheet.containsKey(row) && sheet.get(row).containsKey(col)) {
            sheet.get(row).get(col).setValue(value, CellType.VALUE);
        } else {
            Cell cell = new Cell(value, CellType.VALUE);
            sheet.putIfAbsent(row, new HashMap<>());
            sheet.get(row).put(col, cell);
        }
    }

    public void setFormula(int row, int col, String value) {
        if (sheet.containsKey(row) && sheet.get(row).containsKey(col)) {
            sheet.get(row).get(col).setValue(value, CellType.FORMULA);
        } else {
            Cell cell = new Cell(value, CellType.FORMULA);
            sheet.putIfAbsent(row, new HashMap<>());
            sheet.get(row).put(col, cell);
        }
    }

    public String getCellValue(int row, int col) {
        if (sheet.containsKey(row) && sheet.get(row).containsKey(col)) {
            return sheet.get(row).get(col).evaluate();
        }
        return ""; // EmptyCell
    }

    public void undoCell(int row, int col) {
        if (sheet.containsKey(row) && sheet.get(row).containsKey(col)) {
            sheet.get(row).get(col).undo();
        }
    }

    public void redoCell(int row, int col) {
        if (sheet.containsKey(row) && sheet.get(row).containsKey(col)) {
            sheet.get(row).get(col).redo();
        }
    }

    public void printSheet() {
        for (Map.Entry<Integer, Map<Integer, Cell>> rowEntry : sheet.entrySet()) {
            for (Map.Entry<Integer, Cell> colEntry : rowEntry.getValue().entrySet()) {
                int row = rowEntry.getKey();
                int col = colEntry.getKey();
                Cell cell = colEntry.getValue();
                System.out.print("(" + row + ", " + col + ", " + cell.evaluate() + ")\t");
            }
            System.out.println();
        }
    }

}
