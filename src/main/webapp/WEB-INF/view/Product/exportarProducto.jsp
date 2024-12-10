<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Usuario
  Date: 10/12/2024
  Time: 20:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container-cabecera">
  <jsp:include page="../cabecera.jsp" />
</div>

<h1>Export</h1>
<form:form method="post" action="/products/export" modelAttribute="filtro">
    <table border="0">
        <tr>
            <td>Search by category:</td>
            <td><form:select path="category" items="${categories}" itemLabel="category_name" itemValue="category_id"/>
            </td>
        </tr>
        <tr>
            <td colspan="2"> <button>Export</button></td>
        </tr>
    </table>
</form:form>
</body>
</html>