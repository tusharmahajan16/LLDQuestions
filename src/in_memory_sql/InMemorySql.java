package in_memory_sql;

import in_memory_sql.model.*;
import in_memory_sql.model.constarint.Implementation.IntegerConstraint;
import in_memory_sql.model.constarint.Implementation.IsRequiredConstraint;
import in_memory_sql.model.constarint.Implementation.StringConstraint;
import in_memory_sql.model.operators.implentation.EqualsOperator;
import in_memory_sql.model.operators.implentation.NotEqualsOperator;

import java.util.List;

public class InMemorySql {
    public static void main(String[] args) {
        Database companyDb = Database.getInstance("Company");
        SQL sql = new SQL(companyDb);
        Table employeeData = companyDb.createTable("EmployeeData");
        Column id = employeeData.addColumn("id", Type.INTEGER);
        id.addConstraint(new IntegerConstraint());
        id.addConstraint(new IsRequiredConstraint());
        Column user = employeeData.addColumn("user", Type.STRING);
        user.addConstraint(new StringConstraint());
        user.addConstraint(new IsRequiredConstraint());

        Column password = employeeData.addColumn("password", Type.STRING);
        password.addConstraint(new StringConstraint());

        Column salary = employeeData.addColumn("salary", Type.INTEGER);
        salary.addConstraint(new IntegerConstraint());
        sql.insert("Insert into EmployeeData values(101,\"Tushar Mahajan\",\"\",70000");
        sql.insert("Insert into EmployeeData values(102,\"Adam\",\"pass23\",65000");
        sql.insert("Insert into EmployeeData values(103,\"Fischer\",\"2345\",70000");
        employeeData.printAllRecords();

        //filter data
        List<Row> filteredValues = sql.query(employeeData.getTableName(),70000,salary.getColumnName(),new NotEqualsOperator());
        System.out.println(filteredValues);
    }
}
