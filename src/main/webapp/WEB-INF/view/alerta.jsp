<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Alerta</title>
    <style>
        /* Estilo general del cuerpo */
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh;
            text-align: center;
        }

        /* Estilo para el título principal */
        h1 {
            font-size: 36px;
            color: #ff0000; /* Rojo para resaltar la alerta */
            margin-bottom: 10px;
        }

        /* Estilo para el subtítulo */
        h2 {
            font-size: 20px;
            color: #333;
            margin-bottom: 30px;
        }

        /* Contenedor del botón */
        .button-container {
            margin-top: 20px;
        }

        /* Estilo del botón */
        button {
            background-color: #007BFF; /* Azul estándar */
            color: white;
            padding: 10px 20px;
            font-size: 16px;
            font-family: Arial, sans-serif;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease, transform 0.2s ease;
        }

        button:hover {
            background-color: #0056b3; /* Azul más oscuro */
            transform: scale(1.05); /* Efecto de agrandamiento */
        }
    </style>
</head>
<body>


<h1>Alerta</h1>
<h2>You can't create more than 5 attributes</h2>

<div class="button-container">
    <button onclick="window.location.href='/attributes/'">Volver</button>
</div>

</body>
</html>
