package microsoft_excel_design;

import java.util.HashMap;
import java.util.Map;

public class WorkBook {
    Map<String, WorkSheet> workSheets;

    public WorkBook() {
        workSheets = new HashMap<>();
    }

    public void addSheet(String sheetName) {
        workSheets.put(sheetName, new WorkSheet(sheetName));
    }

    public void updateSheetName(String oldSheetName, String newSheetName) {
        if (workSheets.containsKey(oldSheetName)) {
            WorkSheet workSheet = workSheets.get(oldSheetName);
            workSheet.setSheetName(newSheetName);
            workSheets.remove(oldSheetName);
            workSheets.put(newSheetName, workSheet);
        } else {
            System.out.println("WorkSheet not found");
        }
    }

    public WorkSheet getWorkSheet(String sheetName) {
        return workSheets.get(sheetName);
    }
}
