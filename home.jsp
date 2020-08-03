<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.TransactionMaker" %>
<%@ page import="java.sql.ResultSet" %>
<%! static int value=1; %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body> 

<table border="1">
    <tr>
	<td><b>TransactionId</b></td>
	<td><b>Debit</b></td>
	<td><b>Balance</b></td>
	</tr>
<%
TransactionMaker obj = new TransactionMaker();
try{
ResultSet res=obj.statement();
while(res.next()){
%>
	<tr>
	<td><%=res.getInt("TransID") %></td>
	<td><%=res.getInt("Debit") %></td>
	<td><%=res.getInt("Balance") %></td>
	</tr>
<%}  
}catch(Exception e){
	System.out.println("Haiiii");
	e.printStackTrace();
}%></table><%
if(value==1){
	%><br><br>
	<form action="trans" method="GET">
	<%value=1;%>
	<input type="submit" value="Transfer">
	</form><% 
}else{
	// 
}
%>


</body>
</html>