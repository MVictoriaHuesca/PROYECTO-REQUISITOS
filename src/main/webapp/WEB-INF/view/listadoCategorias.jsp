<%@ page import="es.ir.minipim.entity.CategoryEntity" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<CategoryEntity> lista = (List<CategoryEntity>) request.getAttribute("lista");
%>
<html>
<head>
    <title>Categorías</title>
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
        td.delete-icon {
            text-align: center;
        }
        .delete-icon img {
            cursor: pointer;
        }
        .action-icons {
            display: flex;
            justify-content: flex-end; /* Alinea los íconos a la derecha */
            margin: 20px 0; /* Espaciado superior e inferior */
            gap: 15px; /* Espaciado entre íconos */
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
            const confirmar = confirm("¿Estás seguro de que deseas eliminar esta categoría?");
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
<div class="action-icons">
    <a href="/categories/crear.jsp" title="Crear categoría">
        <img src="/Images/ayadir.png" alt="Crear" />
    </a>
    <a href="/categories/modificar.jsp" title="Modificar categoría">
        <img src="/Images/editar.png" alt="Modificar" />
    </a>
    <a href="/categories/eliminar.jsp" title="Borrar categoría">
        <img src="/Images/eliminar.png" alt="Borrar" />
    </a>
</div>

<h2>Lista de Categorías</h2>

<table>
    <tr>
        <th>Nombre</th>
        <th># Productos</th>
        <th>Fecha de Creación</th>
        <th>Eliminar</th>
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