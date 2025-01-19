package in_memory_sql.model.operators;

public abstract class Operator {
    public String name;
    public String sign;

    public abstract boolean operation(Object filterValue, Object value);
}
