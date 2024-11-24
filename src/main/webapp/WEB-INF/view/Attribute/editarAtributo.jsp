<%@ page import="es.ir.minipim.entity.Account" %>
<%@ page import="es.ir.minipim.ui.AttributeUI" %>
<%@ page import="es.ir.minipim.entity.AttributeType" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    AttributeUI attribute = (AttributeUI) request.getAttribute("attribute");
%>
<html>
<head>


    <title>New Attribute</title>
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

<jsp:include page="../cabecera.jsp" />
<form:form method="post" action="/attributes/guardar" modelAttribute="attributeModel">
    <form:hidden path="idAttribute" value="<%= attribute.getIdAttribute() %>"/>
    <table>
        <tr>
            <th>Name</th>
            <td><form:input path="name" size="50" maxlength="50" value="<%= attribute.getName() %>"/></td>
        </tr>
        <tr>
            <th>Type</th>
            <td>
                <form:select path="type">
                    <form:options items="${attributeTypes}" value="<%= attribute.getType()%>"/>
                </form:select>
            </td>
        </tr>
        <tr>
            <td colspan="2" style="text-align: center;">
                <button type="submit">Enviar</button>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
