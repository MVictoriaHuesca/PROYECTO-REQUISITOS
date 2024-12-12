<%@ page import="es.ir.minipim.entity.AccountRelationship" %>
<%@ page import="java.util.List" %>
<%@ page import="es.ir.minipim.entity.Relationship" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Relationship> lista = (List<Relationship>) request.getAttribute("lista");
%>
<html>
<head>
    <title>List of Relationships</title>
    <style>
        /* Estilo para la tabla */
        table {
            width: auto; /* Ajusta el ancho de la tabla al contenido */
            max-width: 800px; /* Limita el ancho máximo de la tabla */
            margin: 0 auto; /* Centra la tabla en la página */
            border-collapse: collapse; /* Elimina el espacio entre bordes de las celdas */
            background-color: #f5f5f5; /* Fondo gris claro para la tabla */
            border: 2px solid #000; /* Borde negro alrededor de la tabla */
        }

        /* Estilo de las celdas de la tabla */
        th, td {
            padding: 12px 16px; /* Aumenta el espaciado interno de las celdas */
            border: 1px solid #000; /* Borde negro en cada celda */
            text-align: left; /* Alineación del texto a la izquierda */
        }

        /* Estilo de las cabeceras de la tabla */
        th {
            background-color: #dcdcdc; /* Fondo gris más oscuro para las cabeceras */
            font-weight: bold; /* Texto en negrita en las cabeceras */
        }

        /* Estilo de los enlaces dentro de las celdas */
        a {
            text-decoration: none; /* Elimina el subrayado */
        }

        /* Estilo de las imágenes en las celdas */
        img {
            width: 20px; /* Ancho de las imágenes */
            height: 20px; /* Altura de las imágenes */
            transition: transform 0.2s ease, box-shadow 0.2s ease; /* Suaviza el efecto */
        }

        /* Efecto hover en las imágenes */
        img:hover {
            transform: scale(1.2); /* Aumenta el tamaño de la imagen */
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.3); /* Agrega una sombra alrededor */
        }

        .add-relationship {
            margin: 30px auto; /* Agrega margen superior e inferior */
            text-align: center; /* Centra el botón horizontalmente */
        }

        .add-relationship a {
            display: inline-block;
            padding: 12px 20px; /* Espaciado interno */
            font-size: 16px; /* Tamaño de la fuente */
            font-weight: bold; /* Texto en negrita */
            color: white; /* Color del texto */
            background-color: #007BFF; /* Color azul para el fondo */
            border-radius: 5px; /* Bordes redondeados */
            text-decoration: none; /* Elimina el subrayado */
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1); /* Sombra alrededor */
            transition: all 0.3s ease; /* Suaviza los cambios al hacer hover */
        }

        .add-relationship a:hover {
            box-shadow: 0 6px 8px rgba(0, 0, 0, 0.2); /* Incrementa la sombra */
            transform: translateY(-2px); /* Mueve el botón ligeramente hacia arriba */
        }
    </style>
</head>
<body>
<div class="container-cabecera">
    <jsp:include page="cabecera.jsp" />
</div>

<table>
    <thead>
    <tr>
        <th>Relationship ID</th>
        <th>Name</th>
        <th>Delete</th>
    </tr>
    </thead>
    <tbody>
    <%
        for (Relationship relationship : lista) {

    %>
    <tr>
        <td><%= relationship.getId() %></td>
        <td><%= relationship.getName() %></td>
        <td class="action-icons">
            <a href="/relationships/delete?id=<%= relationship.getId() %>">
                <img src="/Images/eliminar.png" alt="Delete" title="Delete" />
            </a>
        </td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>

<div class="add-relationship">
    <a href="/relationships/new">
        Add New Relationship
    </a>
</div>
</body>
</html>
