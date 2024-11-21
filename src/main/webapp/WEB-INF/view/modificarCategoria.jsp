<%@ page import="java.util.List" %>
<%@ page import="es.ir.minipim.entity.CategoryEntity" %>
<%@ page import="es.ir.minipim.entity.ProductEntity" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    // La categoría y sus productos se envían desde el controlador
    CategoryEntity categoria = (CategoryEntity) request.getAttribute("categoria");
    List<ProductEntity> productos = (List<ProductEntity>) request.getAttribute("productos");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Modify Category</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
        }
        .container {
            display: inline-block;
            border: 2px solid #ccc;
            border-radius: 8px;
            padding: 20px;
            background-color: #f9f9f9;
            margin-top: 20px;
        }
        .container h2 {
            font-size: 24px;
            margin-bottom: 20px;
            text-transform: uppercase;
            color: #555;
        }
        .product-list {
            list-style-type: none;
            padding: 0;
            margin: 0;
        }
        .product-item {
            border: 1px solid #ccc;
            border-radius: 4px;
            margin: 5px 0;
            padding: 10px;
            background-color: #fff;
            cursor: pointer;
        }
        .product-item:hover {
            background-color: #e0e0e0;
        }
        input[type="text"] {
            font-size: 16px;
            padding: 10px;
            width: 100%;
            max-width: 300px;
            margin: 10px auto;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        button {
            margin-top: 20px;
            padding: 10px 20px;
            font-size: 16px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        button.cancel {
            background-color: #f44336;
            margin-left: 10px;
        }
    </style>
</head>
<body>

<div class="container">
    <!-- Título de la categoría editable -->
    <h2>
        <input type="text" name="categoryName" value="<%= categoria.getCategoryName() %>" />
    </h2>

    <!-- Lista de productos asociados -->
    <ul class="product-list">
        <% for (ProductEntity producto : productos) { %>
        <li class="product-item"><%= producto.getLabel() %></li>
        <% } %>
    </ul>

    <!-- Botones de acción -->
    <form action="/categories/edit" method="post">
        <!-- ID de la categoría para enviarlo al backend -->
        <input type="hidden" name="categoryId" value="<%= categoria.getCategoryId() %>" />

        <!-- Nombre actualizado -->
        <input type="hidden" name="categoryNameUpdated" id="categoryNameUpdated" />

        <button type="submit" onclick="submitForm()">Save Changes</button>
        <button type="button" class="cancel" onclick="window.location.href='/categories';">Cancel</button>
    </form>
</div>

<script>
    function submitForm() {
        // Copiar el valor del input al campo oculto antes de enviar
        document.getElementById("categoryNameUpdated").value = document.querySelector("input[name='categoryName']").value;
    }
</script>

</body>
</html>
