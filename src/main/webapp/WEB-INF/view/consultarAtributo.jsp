<%@ page import="es.ir.minipim.entity.AttributeEntity" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    AttributeEntity attribute = (AttributeEntity) request.getAttribute("attribute");
%>
<html>
<head>
    <title>Attribute Details</title>
    <style>
        /* Estilo para la tabla */
        table {
            width: auto; /* Ajusta el ancho de la tabla al contenido */
            max-width: 800px; /* Limita el ancho máximo de la tabla */
            margin: 20px auto; /* Centra la tabla en la página */
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

        /* Estilo para el contenedor del botón */
        .button-container {
            text-align: center; /* Centra el botón */
            margin-top: 20px; /* Espacio superior para el botón */
        }

        /* Estilo para el botón de volver */
        button {
            background-color: #4CAF50; /* Verde */
            color: white; /* Texto blanco */
            padding: 10px 20px; /* Espaciado interno */
            border: none; /* Sin borde */
            cursor: pointer; /* Cambia el cursor */
            transition: background-color 0.3s; /* Transición suave para el cambio de color */
        }

        /* Efecto hover para el botón */
        button:hover {
            background-color: #45a049; /* Verde más oscuro al pasar el ratón */
        }

    </style>
</head>
<body>

<jsp:include page="cabecera.jsp"/>

<table>
    <tr>
        <td>Nombre:</td>
        <td><%= attribute.getAttributeName() %></td>
    </tr>
    <tr>
        <td>Type:</td>
        <td><%= attribute.getAttributeType() %></td>
    </tr>
</table>

<!-- Contenedor para centrar el botón debajo de la tabla -->
<div class="button-container">
    <button onclick="window.location.href='/attributes/'">Volver</button>
</div>

</body>
</html>
