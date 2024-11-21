<%@ page import="es.ir.minipim.entity.CategoryEntity" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<CategoryEntity> lista = (List<CategoryEntity>) request.getAttribute("lista");
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
        /* Estilo de las cabeceras de la tabla */
        th {
            background-color: #dcdcdc; /* Fondo gris más oscuro para las cabeceras */
            font-weight: bold; /* Texto en negrita en las cabeceras */
        }
        td.delete-icon {
            text-align: center;
        }
        .delete-icon img {
            cursor: pointer;
        }
        .action-icons {
            display: flex;
            justify-content: right;
            margin: 20px 0; /* Espaciado superior e inferior */
            margin-right: 30px;
        }
        .action-icons a {
            text-decoration: none;
        }
        .action-icons img {
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
<!----------------------------------------------------------------------------------------------------------------------------------------------->
<body>
<div class="container-cabecera">
    <jsp:include page="cabecera.jsp" />
</div>

<!-- Íconos de acción (colocados debajo de la cabecera) -->
<div class="action-icons">
    <a href="/categories/new" title="Add category">
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
        for (CategoryEntity categoria : lista) {
            int numeroProductos = categoria.getProductCategoriesByCategoryId() != null
                    ? categoria.getProductCategoriesByCategoryId().size()
                    : 0;
    %>
    <tr>
        <td><%= categoria.getCategoryName() %></td>
        <td><%= numeroProductos %></td>
        <td><%= categoria.getCreatedAt() %></td>
        <td class="edit-icon">
            <a href="/categories/edit?id=<%= categoria.getCategoryId() %>" title="Edit category">
                <img src="/Images/editar.png" alt="Editar" width="20px" height="20px" />
            </a>
        </td>
        <td class="delete-icon">
            <a href="javascript:void(0);"
               onclick="confirmarEliminacion('/categories/borrar?id=<%= categoria.getCategoryId() %>')">
                <img src="/Images/eliminar.png" alt="Eliminar" width="20px" height="20px" />
            </a>
        </td>
    </tr>
    <%
        }
    %>
</table>

</body>
</html>