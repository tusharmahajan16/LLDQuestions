package in_memory_sql.model;

import in_memory_sql.model.operators.Operator;

import java.util.*;

public class SQL {
    Database db;

    public SQL(Database db) {
        this.db = db;
    }

    public List<Row> query(String tableName,Object value, String columnName, Operator operator) {
        List<Row> result = new ArrayList<Row>();
        Set<Map.Entry<Integer,Row>> entries = db.getTable(tableName).getRows().entrySet();
        for(Map.Entry<Integer,Row> entry : entries) {
            if(operator.operation(entry.getValue().getValues().get(columnName), value))
            {
                result.add(entry.getValue());
            }
        }
        return result;
    }

    public void insert(String query) {
        String tableName = extractTableName(query);
        String[] values = extractValues(query);
        Table table = db.getTable(tableName);
        if (table == null) {
            System.out.println("Table " + tableName + " not found");
            return;
        }
        if (values.length != table.getColumns().size()) {
            System.out.println("Number of columns doesn't match");
            return;
        }
        Set<String> columns = table.getColumns().keySet();
        LinkedHashMap<String, Object> valuesMap = new LinkedHashMap<>();
        int idx = 0;
        for (String column : columns) {
            insertRecordInMap(table, valuesMap, column, values[idx++]);
        }
        table.insert(valuesMap);
    }

    private void insertRecordInMap(Table table, LinkedHashMap<String, Object> valuesMap, String colName, String val) {
        if (table.getColumns().get(colName).getColumnType() == Type.INTEGER) {
            valuesMap.put(colName, Integer.valueOf(val));
        } else {
            valuesMap.put(colName, val);
        }
    }

    private String extractTableName(String query) {
        String[] parts = query.split("values");
        return parts[0].replace("Insert into", "").trim();
    }

    private String[] extractValues(String query) {
        String op = query.split("values\\(")[1].split("\\);")[0];
        op = op.replace("\"", "");
        return op.split(",");
    }


//    public static void main(String[] args) {
//        SQL sql = new SQL(Database.getInstance("tempDb"));
//        String Query = "Insert into Employee values(101,\"Tushar Mahajan\",\"password\",1101);";
//        sql.insert(Query);
//    }
}
