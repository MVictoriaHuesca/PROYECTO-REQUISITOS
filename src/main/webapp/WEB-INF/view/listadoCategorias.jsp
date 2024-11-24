<%@ page import="es.ir.minipim.entity.Category" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Category> lista = (List<Category>) request.getAttribute("lista");
%>
<html>
<head>
    <title>Categories</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        table {
            width: auto; /* Ajusta el ancho de la tabla al contenido */
            max-width: 800px; /* Limita el ancho máximo de la tabla */
            margin: 0 auto; /* Centra la tabla en la página */
            border-collapse: collapse; /* Elimina el espacio entre bordes de las celdas */
            background-color: #f5f5f5; /* Fondo gris claro para la tabla */
            border: 2px solid #000; /* Borde negro alrededor de la tabla */
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
        }
        th {
            background-color: #f2f2f2;
        }
        td.delete-icon, td.edit-icon {
            text-align: center;
        }
        .delete-icon img, .edit-icon img {
            cursor: pointer;
        }
        td a:hover {
            text-decoration: underline; /* Subrayado al pasar el mouse sobre el nombre */
        }
        .add-icon {
            display: flex;
            justify-content: flex-end; /* Coloca el botón a la derecha */
            margin: 20px 10%; /* Margen superior e inferior y margen lateral para alinearlo con la tabla */
        }
        .add-icon img {
            width: 30px;
            height: 30px;
            cursor: pointer;
        }
    </style>
    <script>
        function confirmarEliminacion(url) {
            const confirmar = confirm("Are you sure you want to delete this category?");
            if (confirmar) {
                window.location.href = url;
            }
        }
    </script>
</head>
<body>
<div class="container-cabecera">
    <jsp:include page="cabecera.jsp" />
</div>

<!-- Íconos de acción (colocados debajo de la cabecera) -->
<div class="add-icon">
    <a href="/categories/new" title="Crear categoría">
        <img src="/Images/ayadir.png" alt="Add" />
    </a>
</div>

<table>
    <tr>
        <th>Name</th>
        <th># Products</th>
        <th>Creation Date</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
        <%
        for (Category categoria : lista) {
            int numeroProductos = categoria.getId() != null
                                  ? categoria.getProductCategories().size()
                                  : 0;
    %>
    <tr>
        <td><%= categoria.getCategoryName() %></td>
        <td><%= numeroProductos %></td>
        <td><%= categoria.getCreatedAt() %></td>
        <td class="edit-icon">
            <a href="/categories/edit?id=<%= categoria.getId() %>">
                <img src="/Images/editar.png" alt="Edit" width="20px" height="20px" />
            </a>
        </td>
        <td class="delete-icon">
            <a href="javascript:void(0);"
               onclick="confirmarEliminacion('/categories/borrar?id=<%= categoria.getId() %>')">
                <img src="/Images/eliminar.png" alt="Delete" width="20px" height="20px" />
            </a>
        </td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>