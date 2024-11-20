<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Nuevo Atributo</title>
    <style>
        /* Estilo para la tabla */
        table {
            width: 60%; /* Ajusta el ancho de la tabla al 60% del contenedor */
            margin: 50px auto; /* Centra la tabla en la página con margen superior */
            border-collapse: collapse; /* Elimina el espacio entre bordes de las celdas */
            background-color: #f5f5f5; /* Fondo gris claro para la tabla */
            border: 2px solid #000; /* Borde negro alrededor de la tabla */
        }

        /* Estilo de las celdas de la tabla */
        th, td {
            padding: 10px; /* Espaciado interno de las celdas */
            border: 1px solid #000; /* Borde negro en cada celda */
            text-align: left; /* Alineación del texto a la izquierda */
        }

        /* Estilo de las cabeceras de la tabla */
        th {
            background-color: #dcdcdc; /* Fondo gris más oscuro para las cabeceras */
            font-weight: bold; /* Texto en negrita en las cabeceras */
        }

        /* Estilo de los campos de entrada */
        input[type="text"] {
            width: 100%; /* Ocupa todo el ancho disponible de la celda */
            padding: 8px;
            border: 1px solid #ccc; /* Borde gris claro */
            background-color: #fff; /* Fondo blanco */
        }
    </style>
    <script>
        // JavaScript para establecer la fecha en formato MM/DD/YYYY
        window.onload = function() {
            var today = new Date();
            var day = ("0" + today.getDate()).slice(-2); // Asegura el formato de dos dígitos para el día
            var month = ("0" + (today.getMonth() + 1)).slice(-2); // Asegura el formato de dos dígitos para el mes
            var year = today.getFullYear();

            // Formateamos la fecha en formato MM/DD/YYYY
            var formattedDate = month + "/" + day + "/" + year;

            // Establecemos el valor del campo de fecha
            document.getElementById("dateField").value = formattedDate;
        }
    </script>
</head>
<body>
<jsp:include page="cabecera.jsp" />
<form:form method="post" action="/attributes/crear" modelAttribute="attribute">
    <table>
        <tr>
            <th>Name</th>
            <td><form:input path="name" size="50" maxlength="50"/></td>
        </tr>
        <tr>
            <th>Type</th>
            <td><form:input path="type" size="50" maxlength="50"/></td>
        </tr>
        <tr>
            <th>Date Creation</th>
            <td><form:input path="date" size="50" maxlength="50" id="dateField" readonly="true"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>
