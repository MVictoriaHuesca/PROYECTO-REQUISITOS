<%@ page import="java.util.List" %>
<%@ page import="es.ir.minipim.entity.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Product producto = (Product) request.getAttribute("producto");
    List<Attribute> attributes = (List<Attribute>) request.getAttribute("attributes");
    List<ProductAttribute> productAttributes = (List<ProductAttribute>) request.getAttribute("productAttributes");
    List<Category> categories = (List<Category>) request.getAttribute("categories");
    List<ProductCategory> productCategories = (List<ProductCategory>) request.getAttribute("productCategories");

    List<Relationship> relationships = (List<Relationship>) request.getAttribute("relationships");
    List<ProductRelationship> productRelationships = (List<ProductRelationship>) request.getAttribute("productRelationships");

%>
<html>
<head>
    <title>Product Details</title>
    <style>
        .container {
            max-width: 800px;
            width: 100%;
            padding: 20px;
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            text-align: center;
        }

        h1 {
            color: #0033cc;
        }

        h3 {
            margin-top: 20px;
            color: #555;
        }

        p {
            margin: 10px 0;
            font-size: 16px;
        }

        ul {
            list-style-type: none;
            padding: 0;
            margin: 10px auto;
            border: 1px solid #ddd;
            border-radius: 5px;
            background-color: #fff;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            text-align: left;
            max-width: 600px;
        }

        ul li {
            padding: 10px;
            border-bottom: 1px solid #eee;
        }

        ul li:last-child {
            border-bottom: none;
        }

        ul li:nth-child(even) {
            background-color: #f9f9f9;
        }

        ul li:nth-child(odd) {
            background-color: #fff;
        }

        a {
            color: #0033cc;
            text-decoration: none;
        }

        a:hover {
            text-decoration: underline;
        }

        .info-container {
            padding: 15px;
            margin-bottom: 20px;
            border: 1px solid #ddd;
            border-radius: 5px;
            background-color: #f4f4f4;
        }

        .info-container p {
            margin: 5px 0;
        }

        .container-cabecera {
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
<div class="container-cabecera">
    <jsp:include page="cabecera.jsp" />
</div>
<div class="container">
    <h1><%= producto.getLabel() %></h1>

    <div class="info-container">
        <h3>Information</h3>
        <p><strong>SKU:</strong> <%= producto.getSku() %></p>
        <p><strong>GTIN:</strong> <%= producto.getGtin() %></p>
        <p><strong>Creation date:</strong> <%= producto.getCreatedAt() %></p>
    </div>

    <div class="container-attributes">
        <h3>Attributes</h3>
        <ul>
            <%
                for (Attribute att : attributes) {
                    for (ProductAttribute pa : productAttributes) {
                        if (pa.getAttributeIdFk().getId().equals(att.getId())) {
            %>
            <li><strong><%= att.getAttributeName() %>:</strong> <%= pa.getValue() %></li>
            <%
                        }
                    }
                }
            %>
        </ul>
    </div>

    <div class="container-categories">
        <h3>Categories</h3>
        <ul>
            <%
                for (Category cat : categories) {
                    for (ProductCategory pc : productCategories) {
                        if (pc.getCategoryIdFk().getId().equals(cat.getId())) {
            %>
            <li><%= cat.getCategoryName() %></li>
            <%
                        }
                    }
                }
            %>
        </ul>
    </div>

    <div class="container-relationships">
        <h3>Relationships</h3>
        <ul>
            <%
                for (Relationship rel : relationships) {
                    for (ProductRelationship pr : productRelationships) {
                        if (pr.getRelationshipIdFk().getId().equals(rel.getId())) {
            %>
            <li><%= pr.getRelationshipIdFk().getName()%></li>
            <%
                        }
                    }
                }
            %>
        </ul>
    </div>
</div>
</body>
</html>
