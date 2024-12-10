<%@ page import="es.ir.minipim.entity.Account" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<%
    Account account = (Account) request.getAttribute("account");
    List<Account> users = (List<Account>) request.getAttribute("users");
    int nAtributos = account.getAttributes().size();
    int nProductos = account.getProducts().size();
    int nCategorias = account.getCategories().size();
    int nRelaciones = account.getRelationships().size();
%>
<html lang="en">
<head>
    <title>Mostrar información de la cuenta</title>

</head>
<body>
<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person-square" viewBox="0 0 16 16">
    <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0"/>
    <path d="M2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2zm12 1a1 1 0 0 1 1 1v12a1 1 0 0 1-1 1v-1c0-1-1-4-6-4s-6 3-6 4v1a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1z"/>
</svg>
<p><%= account.getAccountName() %></p>
<p>Creation date:</p>
<p><%= account.getCreatedAt() %></p>
<p>Export data</p>
<button>Export</button>
<p>Information</p>
<p>Number of user products: <%= nProductos %> </p>
<p>Number of user attributes: <%= nAtributos%> </p>
<p>Number of user categories: <%= nCategorias%> </p>
<p>Number of user relationships: <%= nRelaciones %></p>
<p>Current plan</p>
<p>Your subscription plan is currently <b>basic</b></p>
<button>Upgrade your plan</button>
<p>Users</p>
<table>

    <%
        for(Account user : users) {
            if(user.equals(account)) {
                continue;
            }
    %>
    <tr>
        <%
            if(user.getAccountProfilePicture() == null) {
        %>
        <td><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person-square" viewBox="0 0 16 16">
            <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0"/>
            <path d="M2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2zm12 1a1 1 0 0 1 1 1v12a1 1 0 0 1-1 1v-1c0-1-1-4-6-4s-6 3-6 4v1a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1z"/>
        </svg></td>
        <%
            } else {
        %>
        <td> <%= user.getAccountProfilePicture()%> </td>
        <%
            }
        %>
        <td> <%= user.getAccountName()%> </td>
        <td> <%= user.getEmailAddress()%> </td>
    </tr>
    <%
        }
    %>

</table>
</body>
</html>
