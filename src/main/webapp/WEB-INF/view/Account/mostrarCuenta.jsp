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
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Account Details</title>
    <link rel="stylesheet" type="text/css" href="/styles/account-details.css">
</head>
<body>

<div class="container-cabecera">
    <jsp:include page="../cabecera.jsp" />
</div>

<div class="content">
    <h1>Account Details</h1>

    <p><strong>Account Name:</strong> <%= account.getAccountName() %></p>
    <p><strong>Company:</strong> <%= account.getGroupName() %></p>
    <p><strong>Creation Date:</strong> <%= account.getCreatedAt() %></p>

    <button>
        <a href="/account/export">
            Export Data
        </a>
    </button>

    <div class="stats">
        <h2>Information</h2>
        <p>Number of user products: <%= nProductos %></p>
        <p>Number of user attributes: <%= nAtributos %></p>
        <p>Number of user categories: <%= nCategorias %></p>
        <p>Number of user relationships: <%= nRelaciones %></p>
    </div>

    <h2>Subscription Plan</h2>
    <p>Your subscription plan is currently <b>basic</b>.</p>
    <button>Upgrade Your Plan</button>

    <h2>Users</h2>
    <table>
        <thead>
        <tr>
            <th>Profile Picture</th>
            <th>Account Name</th>
            <th>Email Address</th>
        </tr>
        </thead>
        <tbody>
        <%
            for(Account user : users) {
                if(user.equals(account)) {
                    continue;
                }
        %>
        <tr>
            <td>
                <% if(user.getAccountProfilePicture() == null) { %>
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="svg-icon bi bi-person-square" viewBox="0 0 16 16">
                    <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0"/>
                    <path d="M2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2zm12 1a1 1 0 0 1 1 1v12a1 1 0 0 1-1 1v-1c0-1-1-4-6-4s-6 3-6 4v1a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1z"/>
                </svg>
                <% } else { %>
                <img src="<%= user.getAccountProfilePicture() %>" alt="Profile Picture" style="width: 40px; height: 40px; border-radius: 50%;">
                <% } %>
            </td>
            <td><%= user.getAccountName() %></td>
            <td><%= user.getEmailAddress() %></td>
        </tr>
        <% } %>
        </tbody>
    </table>
</div>

</body>
</html>
