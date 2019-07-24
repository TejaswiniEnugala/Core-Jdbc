package com.stackroute;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException, ClassNotFoundException, IOException {
        EmployeeDEmo emp=new EmployeeDEmo();
        emp.getEmployeeDetails();
        emp.getEmployeeDetailsInReverseOrder();
        emp.getEmployeeDetailsFromSecondRowInReverse();
       emp.getEmployeeDetailsByNameAndGender("teju","female");
        DatabaseMetaDemo databaseMetaDemo=new DatabaseMetaDemo();
        databaseMetaDemo.getMetaData();
        ResultSetMetadataDemo resultSetMetadataDemo=new ResultSetMetadataDemo();
        resultSetMetadataDemo.resultMetaData();
        RowSetDemo rowSetDemo=new RowSetDemo();
        rowSetDemo.rowSetDemo();
         JdbcTransactionDemo jdbcTransactionDemo=new JdbcTransactionDemo();
        jdbcTransactionDemo.transactionDemo();
         JdbcBatchDemo jdbcBatchDemo=new JdbcBatchDemo();
        jdbcBatchDemo.batchDemo();
    }
}
