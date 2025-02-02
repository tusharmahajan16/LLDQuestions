package microsoft_excel_design.cell_strategy;

import microsoft_excel_design.Cell;

public class CellSumStrategy implements CellStrategy {
    @Override
    public String evaluate(Cell cell) {
        return evaluateSum(cell.getValue());
    }

    private String evaluateSum(String formula)
    {
        //Formula example - SUM(10,20)
        String[] nums = formula.substring(4,formula.length()-1).split(",");
        int sum = 0;
        for (String num : nums) {
            sum += Integer.parseInt(num.trim());
        }
        return String.valueOf(sum);
    }
}
