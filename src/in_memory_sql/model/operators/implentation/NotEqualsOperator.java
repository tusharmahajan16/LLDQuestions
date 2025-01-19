package in_memory_sql.model.operators.implentation;

import in_memory_sql.model.operators.Operator;

import java.util.Objects;

public class NotEqualsOperator extends Operator {
    public NotEqualsOperator() {
        this.name = "NotEqualsOperator";
        this.sign = "!=";
    }

    @Override
    public boolean operation(Object filterValue, Object value) {
        return !Objects.equals(filterValue, value);
    }
}
