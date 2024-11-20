<!DOCTYPE html>
<%@ page import="es.ir.minipim.entity.AccountEntity" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>Accounts List</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        table, th, td {
            border: 1px solid black;
        }
        th, td {
            padding: 10px;
            text-align: left;
        }
    </style>
</head>
<body>
<h1>Accounts List</h1>
<table>
    <thead>
    <tr>
        <th>Account ID</th>
        <th>Account Name</th>
        <th>Account Type</th>
    </tr>
    </thead>
    <tbody>
    <%
        List<AccountEntity> accounts = (List<AccountEntity>) request.getAttribute("accounts");
        for (AccountEntity account : accounts) {
    %>
    <tr>
        <td><%= account.getAccountId() %></td>
        <td><%= account.getAccountName() %></td>
        <td><%= account.getEmailAddress() %></td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
</body>
</html>