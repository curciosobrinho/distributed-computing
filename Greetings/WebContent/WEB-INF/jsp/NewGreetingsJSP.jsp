<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Personalized Greetings</title>
</head>
<body>
<%! String personalizedGreeting = null; %>
<% personalizedGreeting = request.getAttribute("personalizedGreeting").toString(); %>
<%=personalizedGreeting!=null?personalizedGreeting:"Missing greeting" %>

</body>
</html>