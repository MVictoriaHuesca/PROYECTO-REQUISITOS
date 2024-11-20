<%@ page import="es.ir.minipim.dto.AccountDto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="/Styles/cabecera.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <title>Cabecera</title>
</head>
<body>

<nav class="mynavbar">
    <a class="navbar-brand" href="#">
        <img src="/Images/logo.png" alt="Logo" width="254.4px" height="40px">
    </a>
    <div class="nav-links-container">
        <a class="nav-link" href="/Dashboard">Dashboard</a>
        <a class="nav-link" href="/products/">Products</a>
        <a class="nav-link" href="/Assets">Assets</a>
        <a class="nav-link" href="/categories/">Categories</a>
        <a class="nav-link" href="/attributes/">Attributes</a>
        <a class="nav-link" href="/Relationships">Relationships</a>
    </div>
    <div class="container-perfil">
        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person-square" viewBox="0 0 16 16">
            <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0"></path>
            <path d="M2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2zm12 1a1 1 0 0 1 1 1v12a1 1 0 0 1-1 1v-1c0-1-1-4-6-4s-6 3-6 4v1a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1z"></path>
        </svg>
        <p class="username">User1</p>
    </div>
</nav>
</body>
</html>