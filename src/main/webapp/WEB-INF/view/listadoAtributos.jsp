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
    </style>
</head>
<body>
<jsp:include page="cabecera.jsp"/>

<a href="/attributes//crear"></a>
<a href="/attributes/crear">
    <img src="/Images/ayadir.png" alt="Ayadir" />
</a>
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
