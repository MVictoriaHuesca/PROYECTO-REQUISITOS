<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="es.ir.minipim.entity.AttributeEntity" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    List<AttributeEntity> list = (List<AttributeEntity>) request.getAttribute("attributesList");
%>

<html>
<head>
    <title>Title</title>
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

        /* Contenedor para el botón de añadir */
        .add-button-container {
            display: flex;
            justify-content: flex-end; /* Coloca el botón a la derecha */
            margin: 20px 10%; /* Margen superior e inferior y margen lateral para alinearlo con la tabla */
        }

        /* Estilo de la imagen del botón añadir */
        .add-button img {
            width: 40px; /* Ancho más grande para destacar */
            height: 40px; /* Altura más grande para destacar */
            cursor: pointer; /* Cambia el cursor a un puntero */
            transition: transform 0.2s ease, box-shadow 0.2s ease; /* Suaviza los efectos */
        }

        /* Efecto hover para la imagen del botón añadir */
        .add-button img:hover {
            transform: scale(1.2); /* Aumenta ligeramente el tamaño */
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.3); /* Agrega una sombra */
        }

        /* Estilo de los enlaces dentro de las celdas */
        a img {
            width: 20px; /* Ancho de las imágenes */
            height: 20px; /* Altura de las imágenes */
            transition: transform 0.2s ease, box-shadow 0.2s ease; /* Suaviza el efecto */
        }

        /* Efecto hover en las imágenes de las celdas */
        a img:hover {
            transform: scale(1.2); /* Aumenta el tamaño de la imagen */
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.3); /* Agrega una sombra alrededor */
        }
    </style>
</head>
<body>
<jsp:include page="cabecera.jsp"/>

<div class="add-button-container">
    <a href="/attributes/crear" class="add-button">
        <img src="/Images/ayadir.png" alt="Añadir" />
    </a>
</div>

<table>
    <tr>
        <th>Type</th>
        <th>Name</th>
        <th>Creation Date</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <%
        for (AttributeEntity attribute : list) {
    %>
    <tr>
        <td><%=attribute.getAttributeType()%></td>
        <td><%=attribute.getAttributeName()%></td>
        <td><%=attribute.getCreatedAt()%></td>
        <td>
            <a href="/attributes/aditar?id=<%= attribute.getAttributeId() %>">
                <img src="/Images/editar.png" alt="Editar" />
            </a>
        </td>
        <td>
            <a href="/attributes/borrar?id=<%= attribute.getAttributeId() %>">
                <img src="/Images/eliminar.png" alt="Eliminar" />
            </a>
        </td>
    </tr>
    <%
        }
    %>
</table>

</body>
</html>
