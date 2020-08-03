package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionMaker {
	public   ResultSet statement() throws SQLException,ClassNotFoundException{
		 ResultSet r = null;
		String connectionURL = "jdbc:mysql://localhost:3306/BankTransactions"; 
		   Connection connection = null; 
		   
		   Class.forName("com.mysql.jdbc.Driver"); 
		   connection = DriverManager.getConnection(connectionURL, "root", "root");
		   Statement stmt=connection.createStatement();
	       r=stmt.executeQuery("select * from Bank order by TransID desc limit 5");
		  
		return r;
	}

}
