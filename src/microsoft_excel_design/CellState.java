package microsoft_excel_design;

import microsoft_excel_design.enums.CellType;

public class CellState {
    String value;
    CellType cellType;

    public CellState(String value, CellType cellType) {
        this.value = value;
        this.cellType = cellType;
    }

    public String getValue() {
        return value;
    }

    public CellType getCellType() {
        return cellType;
    }
}
