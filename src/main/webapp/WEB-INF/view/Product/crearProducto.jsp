<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="es.ir.minipim.ui.ProductDTO" %>
<%@ page import="java.util.List" %>
<%@ page import="es.ir.minipim.entity.Attribute" %>
<%@ page import="es.ir.minipim.entity.ProductAttribute" %>
<%@ page import="es.ir.minipim.entity.ProductAttributeId" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<ProductAttribute> attributes = (List<ProductAttribute>) request.getAttribute("attributes");
%>
<html>
<head>
    <title>New Product</title>
</head>
<body>
<div class="container-cabecera">
    <jsp:include page="../cabecera.jsp" />
</div>
<h1>Product data</h1>
<form:form method="post" action="/products/save" modelAttribute="product">
    <form:hidden path="id" />
    <table border="0">
        <tr>
            <td>Label:</td>
            <td> <form:input path="label" size="100" maxlength="100"  />
            </td>
        </tr>
        <tr>
            <td>SKU:</td>
            <td>
                <form:input path="SKU" size="100" maxlength="100" />
            </td>
        </tr>
        <tr>
            <td>GTIN:</td>
            <td>
                <form:input path="GTIN" size="100" maxlength="100" />
            </td>
        </tr>
        <tr>
            <td>Creation date:</td>
            <td><form:input path="creationDate" size="50" maxlength="50" readonly="true"/></td>
        </tr>
        <tr>
            <td>Categories:</td>
            <td><form:checkboxes path="categories" items="${categories}" itemLabel="categoryName" itemValue="id" /></td>
        </tr>
        <tr>
            <td>Attributes:</td>
            <%
                for (ProductAttribute att : attributes) {
            %>
            <td>
                <form:input path="attributeValues[<%= att.getAttributeIdFk().getId() %>]" size="100" maxlength="100"/>
            </td>
            <%
                }
            %>
        </tr>
        <tr>
            <td colspan="2"> <button>Enviar</button></td>
        </tr>
    </table>
</form:form>
</body>
</html>
