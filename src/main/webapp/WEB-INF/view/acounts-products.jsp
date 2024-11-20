<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="es.ir.minipim.entity.AccountsEntity" %>
<%@ page import="es.ir.minipim.entity.ProductsEntity" %>
<html>
<head>
    <title>Accounts and Products List</title>
</head>
<body>
<h1>Accounts and Products List</h1>
<%
    Map<AccountsEntity, List<ProductsEntity>> accountsProductsMap = (Map<AccountsEntity, List<ProductsEntity>>) request.getAttribute("accountsProductsMap");
    if (accountsProductsMap != null) {
        for (Map.Entry<AccountsEntity, List<ProductsEntity>> entry : accountsProductsMap.entrySet()) {
            AccountsEntity account = entry.getKey();
            List<ProductsEntity> products = entry.getValue();
%>
<h2>Account: <%= account.getAccountName() %></h2>
<table border="1">
    <thead>
    <tr>
        <th>Product ID</th>
        <th>Product Name</th>
        <th>Price</th>
        <th>Quantity</th>
    </tr>
    </thead>
    <tbody>
    <%
        if (products != null) {
            for (ProductsEntity product : products) {
    %>
    <tr>
        <td><%= product.getProductId() %></td>
    </tr>
    <%
            }
        }
    %>
    </tbody>
</table>
<%
        }
    }
%>
</body>
</html>