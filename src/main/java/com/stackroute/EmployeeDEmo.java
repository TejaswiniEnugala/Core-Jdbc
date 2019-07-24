package com.stackroute;

import javax.sql.RowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.*;

import static java.sql.DriverManager.getConnection;

public class EmployeeDEmo {
    private Connection connection;
    private Statement statement;
    private ResultSet result;

    public void getEmployeeDetails() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/employee", "root", "Root@123");
            statement = connection.createStatement();
            result = statement.executeQuery("select * from employee");
            while (result.next()) {
                System.out.println("name: " + result.getString(1) + "  id: " + result.getInt(2) + "  age: " + result.getInt(3) + "  gender: " + result.getString(4));
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*Print ResultSet in reverse order*/
    public void getEmployeeDetailsInReverseOrder() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/employee", "root", "Root@123");
            statement = connection.createStatement();

            result = statement.executeQuery("select * from employee ");
            result.afterLast();
            while (result.previous()) {
                System.out.println("name: " + result.getString(1) + "  id: " + result.getInt(2) + "  age: " + result.getInt(3) + "  gender: " + result.getString(4));


            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

           /* finally {
                connection.close();
                statement.close();
                result.close();
            }*/
    }

    /*Move ResultSet to second row and print in reverse order*/
    public void getEmployeeDetailsFromSecondRowInReverse() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/employee", "root", "Root@123");
            statement = connection.createStatement();
            result = statement.executeQuery("select * from employee ");
            int count = 0;
            try {
                while (result.next()) {
                    count++;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println(count);

            result.afterLast();
            while (result.previous()) {
                if (count >= 2) {
                    System.out.println("name: " + result.getString(1) + "  id: " + result.getInt(2) + "  age: " + result.getInt(3) + "  gender: " + result.getString(4));
                    count--;
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //Use PreparedStatement to display by name and gender

    public void getEmployeeDetailsByNameAndGender(String name, String gender) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/employee", "root", "Root@123");
            statement = connection.createStatement();
            result = statement.executeQuery("select * from employee");
            while (result.next()) {
                if(result.getString(1).equals(name))
                {
                    System.out.println("name:" + result.getString(1) +" " +"gender:" + result.getString(4));

                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
