<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="java.util.List" %>
<%@ page import="es.ir.minipim.entity.Product" %>
<%
    // Suponiendo que la lista de posibles productos está disponible en el request
    //List<Product> productos = (List<Product>) request.getAttribute("productos");
%>
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
<%--@elvariable id="category" type=""--%>
    <form:form method="post" action="/categories/save" modelAttribute="category">
        <form:hidden path="id" />
        <table>
            <tr>
                <th>Category Name:</th>
                <td><form:input path="categoryName" size="50" maxlength="50"/></td>
                <td colspan="2" style="text-align: center;">
                    <button type="submit">Accept</button>
                </td>
            </tr>
        </table>
    </form:form>
</body>
</html>
