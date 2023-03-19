package com.mtit.service;
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.SQLException; 
import java.sql.Statement;  
import java.sql.PreparedStatement; 
import java.sql.ResultSet;  
public class Connect {  
	
	
	
   public static  void connect() {  
       Connection conn = null;  
       String sql = "CREATE TABLE IF NOT EXISTS members (\n"  
               + " id integer PRIMARY KEY AUTOINCREMENT,\n"  
               + " name text NOT NULL,\n"  
               + " email text NOT NULL,\n"
               + " password text NOT NULL,\n"
               + " package real NOT NULL\n"
               + ");";  
       try {  
          
           String url = "jdbc:sqlite:my_db.db";  
         
           conn = DriverManager.getConnection(url);  
           Statement stmt = conn.createStatement();  
           stmt.execute(sql);  
           login("gimhan@gmail.com","132456");  
           System.out.println("Connection to SQLite has been established.");  
         
             
       } catch (SQLException e) {  
           System.out.println(e.getMessage());  
       } finally {  
           try {  
               if (conn != null) {  
                   conn.close();  
               }  
           } catch (SQLException ex) {  
               System.out.println(ex.getMessage());  
           }  
       }  
   } 
   
  public static void main(String args[]) {
	  connect();
   }
   
   public static void insertUserDataToDb(String email,String password,String name,int pcg) {
	   Connection conn = null;  
	   String url = "jdbc:sqlite:my_db.db";  
	   String sql = "INSERT INTO members(name, email,password,package) VALUES(?,?,?,?)"; 
       try {
		conn = DriverManager.getConnection(url);
		PreparedStatement pstmt = conn.prepareStatement(sql);  
        pstmt.setString(1, name);  
        pstmt.setString(2, email);  
        pstmt.setString(3, password);
        pstmt.setDouble(4, pcg/1.0);
        pstmt.executeUpdate();  
        System.out.println("Data inserted succesfully");
		
	} catch (SQLException e) {
		System.out.println(e.getMessage());  
	} 
   }
   
   public MemberModel  getUserDetails(String email) {
	    String sql = "SELECT * FROM members WHERE  'email' = '" + email + "'"; 
	    Connection conn = null;  
		String url = "jdbc:sqlite:my_db.db";  
		try {
			conn = DriverManager.getConnection(url);
			Statement stmt  = conn.createStatement();  
            ResultSet rs    = stmt.executeQuery(sql); 
            while(rs.next()) {
            	MemberModel member = new MemberModel(
            			rs.getString("name"),
            			rs.getString("password"),
            			rs.getString("email"),
            			rs.getDouble("package")
            			);
   
            	return member;
            }
            return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	    
   }
   
   public static MemberModel login(String email,String password) {
	   System.out.println("Email is " + email);
	   String sql = "SELECT * FROM members"; 
	    Connection conn = null;  
		String url = "jdbc:sqlite:my_db.db";  
		try {
			conn = DriverManager.getConnection(url);
			Statement stmt  = conn.createStatement();  
           ResultSet rs    = stmt.executeQuery(sql); 
           while(rs.next()) {
           	if(rs.getString("password") == password) {
           		MemberModel member = new MemberModel(
               			rs.getString("name"),
               			rs.getString("password"),
               			rs.getString("email"),
               			rs.getDouble("package")
               			);
           		System.out.println("Welcome back " + member.name);
           		System.out.println("Email: "+member.email);
           		System.out.println("Selected Package " + member.pckg);
               	return member;
           	}else {
           		return null;
           	}
           }
           return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
   }
   
   
}  