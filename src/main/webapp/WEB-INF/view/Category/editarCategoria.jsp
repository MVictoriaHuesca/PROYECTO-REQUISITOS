<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="java.util.List" %>
<%@ page import="es.ir.minipim.entity.Product" %>
<%@ page import="es.ir.minipim.entity.Category" %>
<html>
<head>


    <title>New Category</title>
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
<h1>Add Category</h1>
<form:form method="post" action="/categories/save" modelAttribute="categoria">
    <form:hidden path="idCategory" />
    <table>
        <tr>
            <th>Category Name:</th>
            <td><form:input path="name" size="50" maxlength="50"/></td>
            <td colspan="2" style="text-align: center;">
                <button type="submit">Accept</button>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
