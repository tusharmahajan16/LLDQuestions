package microsoft_excel_design;

public class Excel {
    public static void main(String[] args) {
        WorkBook workbook = new WorkBook();
        String sheetName = "Sheet1";
        workbook.addSheet(sheetName);
        WorkSheet workSheet = workbook.getWorkSheet(sheetName);
        workSheet.setValue(1,1,"10");
        workSheet.setValue(1,2,"20");
        workSheet.setFormula(1, 3, "SUM(10, 20)");
        workSheet.setFormula(1, 4, "AVERAGE(10, 20, 30, 40)");
        workSheet.printSheet();

        workSheet.setValue(1,1,"15");
        workSheet.printSheet();
        workSheet.undoCell(1,1);
        workSheet.printSheet();
        workSheet.redoCell(1,1);
        workSheet.printSheet();
        workSheet.undoCell(1,1);
        workSheet.printSheet();
    }
}
