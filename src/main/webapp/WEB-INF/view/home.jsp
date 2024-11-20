<%@ page import="es.ir.minipim.dto.AccountDto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    AccountDto account = (AccountDto) request.getAttribute("account");
    String accountName = account.getAccountName();
%>
<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
    <link rel="stylesheet" type="text/css" href="/Styles/home.css">
</head>
<body>
<div class="container-cabecera">
    <jsp:include page="cabecera.jsp"/>
</div>

<div class="home-container">
    <h1>home de <%= accountName %></h1>
</div>
</body>
</html>