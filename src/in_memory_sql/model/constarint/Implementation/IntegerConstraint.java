package in_memory_sql.model.constarint.Implementation;

import in_memory_sql.model.constarint.Constraint;

public class IntegerConstraint implements Constraint {

    @Override
    public boolean validate(Object value) {
        return value instanceof Integer;
    }

    @Override
    public String getConstraintType() {
        return "Integer Constraint";
    }
}
