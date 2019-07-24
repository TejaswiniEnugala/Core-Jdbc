package com.stackroute;

import java.sql.*;

public class ResultSetMetadataDemo {
    Connection connection;
    public void resultMetaData()

    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/employee", "root", "Root@123");
            PreparedStatement ps = connection.prepareStatement("select * from employee");
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();

            System.out.println("Total columns: " + rsmd.getColumnCount());
            System.out.println("Column Name of 1st column: " + rsmd.getColumnName(1));
            System.out.println("Column Type Name of 1st column: " + rsmd.getColumnType(1));

            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
