<%@ page import="es.ir.minipim.entity.ProductEntity" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="es.ir.minipim.entity.ProductAttributeEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="es.ir.minipim.entity.AttributeEntity" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ProductEntity producto = (ProductEntity) request.getAttribute("producto");
    List<AttributeEntity> attributes = (List<AttributeEntity>) request.getAttribute("attributes");
    List<ProductAttributeEntity> productAttributes = (List<ProductAttributeEntity>) request.getAttribute("productAttributes");
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
<p>Attributes</p>
<ul style="border: 1px">
    <%
        for(AttributeEntity att : attributes) {
            for(ProductAttributeEntity pa : productAttributes) {
                if(pa.getAttributeByAttributeIdFk().getAttributeId().equals(att.getAttributeId())) {
    %>
    <li><%= att.getAttributeName() %>: <%= pa.getValue() %></li>
    <%
                }
            }
        }
    %>
</ul>
</body>
</html>
