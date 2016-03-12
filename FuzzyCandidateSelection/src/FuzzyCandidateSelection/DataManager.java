package FuzzyCandidateSelection;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author Administrator
 */
public class DataManager {
   static String caUrl = "com.mysql.jdbc.Driver";
   static  String caConnUrl = "jdbc:mysql://localhost:3306/test";
   static String caUserName = "root";
   static String caPassword = "";

    public static Connection getConnection() {

        try {
//step1 load the driver class
            Class.forName(caUrl);

//step2 create  the connection object
            Connection con = DriverManager.getConnection(caConnUrl, caUserName, caPassword);

            return con;

        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public static boolean updateData(String caQuery, Connection con) {
        try {
            Statement stmt = con.createStatement();
//step4 execute query
            stmt.executeUpdate(caQuery);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public static ResultSet retrieveData(String caQuery, Connection con) {
        try {
            Statement stmt = con.createStatement();

//step4 execute query
//ResultSet rs= stmt.executeQuery(caQuery);
            ResultSet rs = stmt.executeQuery(caQuery);
            //System.out.print(rs);
            return rs;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public static void closeConnection(Connection con) {
        try {
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }


    }
    public static boolean Execute(String caQuery, Connection con) {
        try {
            Statement stmt = con.createStatement();
//step4 execute query
            stmt.executeQuery(caQuery);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
    public static boolean IsValidDate(String Date)
    {
    	 SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    	    dateFormat.setLenient(false);
    	    try {
    	      dateFormat.parse(Date.trim());
    	    } catch (ParseException pe) {
    	      return false;
    	    }
    	    return true;
    	
    }
    
}
