package in_memory_sql.model;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class Database {
    // shared resource among all instances
    private static String currentDatabase;
    public static ConcurrentHashMap<String, Database> dbMap = new ConcurrentHashMap<String, Database>();

    // private resource among all instances
    private String name;
    private HashMap<String, Table> tables;

    public static void setCurrentDatabase(String currentDatabase) {
        Database.currentDatabase = currentDatabase;
        getInstance(currentDatabase);
    }

    private Database(String name) {
        this.name = name;
        tables = new HashMap<>();
    }

    public static Database getInstance(String dbName) {
        if (!dbMap.containsKey(dbName)) {
            Database db = new Database(dbName);
            dbMap.put(dbName, db);
        }
        return dbMap.get(dbName);
    }

    public Table createTable(String tableName) {
        if (tables.containsKey(tableName)) {
            System.out.println("Table " + tableName + " already exists");
            return tables.get(tableName);
        }
        Table table = new Table(tableName);
        tables.put(tableName, table);
        return table;
    }

    public String getName() {
        return name;
    }

    public Table getTable(String tableName) {
        return tables.get(tableName);
    }

    public void removeTable(String tableName) {
        tables.remove(tableName);
    }

}
