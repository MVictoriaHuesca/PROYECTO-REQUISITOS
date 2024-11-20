<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="es.ir.minipim.entity.AccountsEntity" %>
<html>
<head>
    <title>Accounts List</title>
</head>
<body>
<h1>Accounts List</h1>
<table border="1">
    <thead>
    <tr>
        <th>Account ID</th>
        <th>Account Name</th>
        <th>Email Address</th>
        <th>Created At</th>
    </tr>
    </thead>
    <tbody>
    <%
        List<AccountsEntity> accounts = (List<AccountsEntity>) request.getAttribute("accounts");
        if (accounts != null) {
            for (AccountsEntity account : accounts) {
    %>
    <tr>
        <td><%= account.getAccountId() %></td>
        <td><%= account.getAccountName() %></td>
        <td><%= account.getEmailAddress() %></td>
        <td><%= account.getCreatedAt() %></td>
    </tr>
    <%
            }
        }
    %>
    </tbody>
</table>
</body>
</html>