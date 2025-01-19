package in_memory_sql.model.constarint;

public interface Constraint {
    boolean validate(Object value);
    String getConstraintType();
}
