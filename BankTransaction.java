package com;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
@WebServlet("/trans")
public class BankTransaction extends HttpServlet {

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			response.setContentType("text/html");
			TransactionMaker obj = new TransactionMaker();
			
			ResultSet res=null;
			try {
				   String connectionURL = "jdbc:mysql://localhost:3306/BankTransactions"; 
				   Connection connection = null; 
				 
				   Class.forName("com.mysql.jdbc.Driver"); 
				   connection = DriverManager.getConnection(connectionURL, "root", "root");
				   Statement stmt=connection.createStatement();
				   ResultSet r=stmt.executeQuery("select Balance from Bank order by TransID desc limit 1");r.next();
				   int b=r.getInt("Balance");
				   stmt.executeUpdate("insert into Bank(Debit,Balance) values(1000,'"+(b-1000)+"')");
;
				 res = obj.statement();
				request.setAttribute("statement", res);
				RequestDispatcher rd =request.getRequestDispatcher("home.jsp");
				rd.forward(request, response);
			
			} catch (Exception e) {e.printStackTrace();}			

		}

}
