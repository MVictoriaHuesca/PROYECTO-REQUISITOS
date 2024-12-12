<%@ page import="es.ir.minipim.entity.Product" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Usuario
  Date: 10/12/2024
  Time: 20:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Product> lista = (List<Product>) request.getAttribute("lista");
%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="/styles/CSVProducts.css">
</head>
<body>
<div class="container-cabecera">
  <jsp:include page="../cabecera.jsp" />
</div>
<div class="content">
<h1>Export</h1>
<form:form method="post" action="/products/filter" modelAttribute="filtro">
    <table border="0">
        <tr>
            <td>Search by category:</td>
            <td><form:select path="category" items="${categories}" itemLabel="categoryName" itemValue="id"/>
            </td>
        </tr>
        <tr>
            <td colspan="2"> <button>Filter</button></td>
        </tr>
    </table>
</form:form>
<form:form method="post" action="/products/filter" modelAttribute="filtro">
    <tr>
        <td colspan="2"> <button>No filter</button></td>
    </tr>
</form:form>
<form:form method="post" action="/products/generate" modelAttribute="filtro">
    <form:hidden path="category" />
    <table border="0">
        <tr>
            <td>Price:</td>
            <td><form:select path="price" items="${atributosFloat}" itemLabel="attributeName" itemValue="id"/>
            </td>
        </tr>
        <tr>
            <td colspan="2"> <button>Export</button></td>
        </tr>
    </table>
</form:form>

<h2>Products</h2>
<table>
    <thead>
    <tr>
        <th>SKU</th>
        <th>Label</th>
        <th>GTIN</th>
        <th>Date</th>
    </tr>
    </thead>
    <tbody>
    <%
        for(Product producto: lista){
    %>
    <tr>
        <td><%= producto.getSku() %></td>
        <td><%= producto.getLabel() %></td>
        <td><%= producto.getGtin() %></td>
        <td><%= producto.getCreatedAt() %></td>
    </tr>
    <%
        }
    %>
</div>
    </tbody>
</table>
</body>
</html>