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
</head>
<body>
<jsp:include page="cabecera.jsp"/>
<h1>home de <%= accountName %></h1>
<p></p>
</body>
</html>