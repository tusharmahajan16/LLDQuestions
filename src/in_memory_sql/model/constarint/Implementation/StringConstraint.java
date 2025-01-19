package in_memory_sql.model.constarint.Implementation;

import in_memory_sql.model.constarint.Constraint;

public class StringConstraint implements Constraint {
    @Override
    public boolean validate(Object value) {
        return value instanceof String;
    }

    @Override
    public String getConstraintType() {
        return "String Constraint";
    }
}
