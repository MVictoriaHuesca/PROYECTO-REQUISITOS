<%@ page import="java.util.List" %>
<%@ page import="es.ir.minipim.entity.CategoryEntity" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    CategoryEntity categoria = (CategoryEntity) request.getAttribute("categoria");
    List<CategoryEntity> categorias = (List<CategoryEntity>) request.getAttribute("categorias");
    List<String> nombres = (List<String>) request.getAttribute("nombres");
%>
<html>
<head>
    <title>Add new Category</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        table {
            width: auto;
            max-width: 800px;
            margin: 0 auto;
            border-collapse: collapse;
            background-color: #f5f5f5;
            border: 2px solid #000;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
        }
        th {
            background-color: #f2f2f2;
        }
        .form-group {
            margin-bottom: 20px;
            display: flex;
            flex-direction: column;
            align-items: flex-start;
        }
        label {
            font-weight: bold;
        }
        input[type="text"] {
            padding: 8px;
            font-size: 14px;
            border: 1px solid #ddd;
            border-radius: 4px;
            width: 100%;
        }
        button {
            padding: 10px 20px;
            font-size: 16px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        button img {
            margin-left: 10px;
            vertical-align: middle;
        }
        .action-icons {
            display: flex;
            justify-content: flex-end;
            margin: 20px 0;
            gap: 15px;
        }
        .action-icons a {
            text-decoration: none;
        }
        .action-icons img {
            width: 30px;
            height: 30px;
            cursor: pointer;
        }
        .error-message {
            color: red;
            font-weight: bold;
        }
    </style>
</head>
<body>
<div class="container-cabecera">
    <jsp:include page="cabecera.jsp" />
</div>

<h1>Add New Category</h1>

<form action="/categories/save" method="post">
    <div class="form-group">
        <label for="categoryName">Category Name:</label>
        <input type="text" id="categoryName" name="categoryName" required>
    </div>

    <!-- Mostrar el mensaje de error si existe -->
    <% if (request.getAttribute("error") != null) { %>
    <div class="error-message">
        <%= request.getAttribute("error") %>
    </div>
    <% } %>

    <div class="form-actions">
        <button type="submit">Add Category</button>
        <a href="/categories/cancel" class="cancel-button">Cancel</a>
    </div>
</form>
</body>
</html>
