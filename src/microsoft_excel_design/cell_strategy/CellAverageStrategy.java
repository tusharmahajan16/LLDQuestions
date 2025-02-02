package microsoft_excel_design.cell_strategy;

import microsoft_excel_design.Cell;

public class CellAverageStrategy implements CellStrategy {


    @Override
    public String evaluate(Cell cell) {
        return evaluateAverage(cell.getValue());
    }

    private String evaluateAverage(String formula)
    {
        //AVERAGE(10,20)
        String[] nums = formula.substring(8, formula.length()-1).split(",");
        int sum = 0;
        for(String num : nums)
        {
            sum += Integer.parseInt(num.trim());
        }
        sum = sum/nums.length;
        return String.valueOf(sum);
    }


}
