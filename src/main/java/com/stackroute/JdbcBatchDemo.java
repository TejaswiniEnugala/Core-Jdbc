package com.stackroute;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcBatchDemo {
    public void batchDemo() throws IOException, SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "Root@123");

        PreparedStatement ps = con.prepareStatement("insert into employee values(?,?,?,?)");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {

            System.out.println("enter name");
            String username = br.readLine();

            System.out.println("enter id");
            String s1 = br.readLine();
            int userid = Integer.parseInt(s1);


            System.out.println("enter age");
            String s3 = br.readLine();
            int age = Integer.parseInt(s3);


            System.out.println("enter gender");
            String gender = br.readLine();

            ps.setString(1, username);
            ps.setInt(2, userid);
           ps.setInt(3, age);
            ps.setString(4,gender);


            ps.addBatch();
            System.out.println("Want to add more records y/n");
            String ans = br.readLine();
            if (ans.equals("n")) {
                break;
            }

        }
        try {
            ps.executeBatch();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        System.out.println("record successfully saved");

    }
}
