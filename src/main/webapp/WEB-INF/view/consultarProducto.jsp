<%@ page import="es.ir.minipim.entity.ProductEntity" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="es.ir.minipim.entity.ProductAttributeEntity" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ProductEntity producto = (ProductEntity) request.getAttribute("producto");
%>
<html>
<head>
    <title>Product Details</title>
</head>
<body>
<div class="container-cabecera">
    <jsp:include page="cabecera.jsp"/>
</div>
<h1><%= producto.getLabel() %></h1>


</body>
</html>
