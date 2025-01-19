package in_memory_sql.model.constarint.Implementation;

import in_memory_sql.model.constarint.Constraint;

public class IsRequiredConstraint implements Constraint {

    @Override
    public boolean validate(Object value) {
        if (value == null) {
            return false;
        }
        if (value instanceof String) {
            return !((String) value).isEmpty();
        }
        return true;
    }

    @Override
    public String getConstraintType() {
        return "Is Required Constraint";
    }
}
