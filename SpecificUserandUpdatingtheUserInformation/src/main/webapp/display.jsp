<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="java.util.*" %>
    <%@ page import="com.example.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
List<Employee> list=(List<Employee>)request.getAttribute("list");
int i=0;
%>

<table border="1"> 
<tr><th>Employee id</th><th>Employee name</th><th>Employee email</th><th>Edit</th></tr>
<%for(Employee e:list){ 
	if (e.getEid()==Integer.parseInt(EmployeeContoller.id)){  i+=1; %>
	
<tr><td><%=e.getEid() %></td><td><%=e.getEname() %></td><td><%=e.getEmail() %></td><td><a href="update.jsp?id=<%=e.getEid() %>">Edit</a></td></tr>
	<%}
	}%>
</table>
<% if(i==0) {%>
		
			<jsp:forward page="failure.jsp"></jsp:forward>
		
		<% } %>
		
</body>
</html>