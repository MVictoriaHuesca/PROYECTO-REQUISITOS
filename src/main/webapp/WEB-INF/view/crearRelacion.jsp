<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="java.util.List" %>
<%@ page import="es.ir.minipim.entity.Product" %>
<%
    List<Product> lista = (List<Product>) request.getAttribute("listaprod");
    String error = (String) request.getAttribute("error");
%>
<html>
<head>
    <title>New Relationship</title>
    <style>
        /* Estilo para la tabla */
        table {
            width: 60%;
            margin: 50px auto;
            border-collapse: collapse;
            background-color: #f5f5f5;
            border: 2px solid #000;
        }

        th, td {
            padding: 10px;
            border: 1px solid #000;
            text-align: left;
        }

        th {
            background-color: #dcdcdc;
            font-weight: bold;
        }

        input[type="text"], input[type="datetime-local"] {
            width: 100%;
            padding: 8px;
            border: 1px solid #ccc;
            background-color: #fff;
        }
    </style>
</head>
<body>
<jsp:include page="cabecera.jsp" />
<h1>Add Relationship</h1>
<% if (error != null) { %>
    <p style="color: red;"><%= error %></p>
<% } %>
<%--@elvariable id="relacion" type=""--%>
<form:form method="post" action="/relationships/save" modelAttribute="relacion">
    <form:hidden path="idRelationship" />
    <table>
        <tr>
            <th>Relationship Name:</th>
            <td><form:input path="name" size="50" maxlength="50" /></td>
            <td colspan="2" style="text-align: center;">
                <button type="submit">Accept</button>
            </td>
        </tr>
    </table>

    <!-- Primera tabla: Selección del primer producto -->
    <h2>Select Product 1</h2>
    <table>
        <tr>
            <th>Select</th>
            <th>Product Label</th>
        </tr>
        <tr>
            <td><form:radiobuttons path="product_1" items="${lista}" itemLabel="label" itemValue="id"/></td>
        </tr>
    </table>

    <!-- Segunda tabla: Selección del segundo producto -->
    <h2>Select Product 2</h2>
    <table>
        <tr>
            <th>Select</th>
            <th>Product Label</th>
        </tr>
        <tr>
            <td><form:radiobuttons path="product_2" items="${lista}" itemLabel="label" itemValue="id"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>
