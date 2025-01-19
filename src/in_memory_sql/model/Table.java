package in_memory_sql.model;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class Table {

    private String tableName;
    private LinkedHashMap<String, Column> columns;
    private HashMap<Integer, Row> rows;
    private AtomicInteger rowId;

    Table(String tableName) {
        this.tableName = tableName;
        columns = new LinkedHashMap<>();
        rows = new HashMap<>();
        rowId = new AtomicInteger(0);
    }

    public String getTableName() {
        return tableName;
    }

    public LinkedHashMap<String, Column> getColumns() {
        return columns;
    }

    public HashMap<Integer, Row> getRows() {
        return rows;
    }

    public Integer getRowId() {
        return rowId.incrementAndGet();
    }

    public boolean insert(LinkedHashMap<String, Object> values) {
        Integer id = getRowId();
        Set<String> columnNames = columns.keySet();
        for (String columnName : columnNames) {
            columns.get(columnName).validate(values.get(columnName));
        }
        Row row = new Row(id, values);
        rows.put(id, row);
        return true;
    }

    public void deleteRow(Integer id) {
        rows.remove(id);
    }

    public Column addColumn(String columnName, Type type) {
        if (columns.containsKey(columnName)) {
            System.out.println("Column " + columnName + " already exists");
            return columns.get(columnName);
        }
        Column column = new Column(columnName, type);
        columns.put(columnName, column);
        return column;
    }

    public void printAllRecords() {
        System.out.println(rows);
    }
}
