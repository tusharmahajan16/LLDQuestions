package microsoft_excel_design.cell_strategy;

import microsoft_excel_design.Cell;

import java.util.logging.Logger;

public class FormulaCellStrategy implements CellStrategy {


    @Override
    public String evaluate(Cell cell) {
        return evaluateFormula(cell);
    }

    public String evaluateFormula(Cell cell) {
        String formula = cell.getValue();
        String ans = "";
        try {
            if (formula.startsWith("SUM")) {
                ans = new CellSumStrategy().evaluate(cell);
            } else if (formula.startsWith("AVERAGE")) {
                ans = new CellAverageStrategy().evaluate(cell);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ans;
    }
}
