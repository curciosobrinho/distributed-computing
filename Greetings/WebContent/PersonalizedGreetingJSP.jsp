<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Personalized Greetings</title>
</head>
<body>
<%! String name = null; %>
<% name = request.getParameter("name"); %>
Welcome master <%=name!=null?name:"Unknown" %>
</body>
</html>