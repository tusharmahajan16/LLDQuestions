package in_memory_sql.model;

import in_memory_sql.model.constarint.Constraint;

import java.util.HashSet;
import java.util.Set;

public class Column {
    private String columnName;
    private Type columnType;
    Set<Constraint> constraints;

    public Column(String columnName, Type columnType) {
        this.columnName = columnName;
        this.columnType = columnType;
        constraints = new HashSet<>();
    }

    public void addConstraint(Constraint constraint) {
        constraints.add(constraint);
    }

    public void setConstraint(Set<Constraint> constraint) {
        this.constraints = constraint;
    }

    public Type getColumnType() {
        return columnType;
    }

    public String getColumnName() {
        return columnName;
    }

    public void validate(Object value) throws RuntimeException {
        for (Constraint constraint : constraints) {
            if (!constraint.validate(value)) {
                throw new RuntimeException(constraint.getConstraintType() + " Violation for Column : " + columnName);
            }
        }
    }

}