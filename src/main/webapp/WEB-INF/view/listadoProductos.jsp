<%@ page import="es.ir.minipim.entity.ProductEntity" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  List<ProductEntity> lista = (List<ProductEntity>) request.getAttribute("lista");

%>
<html>
  <head>
    <title>Lista de productos</title>
  </head>
  <body>
  <div class="container-cabecera">
    <jsp:include page="cabecera.jsp"/>
  </div>
  <table border="1">
    <tr>
      <th>SKU</th>
      <th>Label</th>
      <th>GTIN</th>
      <th>Date</th>
      <th></th>
      <th></th>
      <th></th>
    </tr>
    <%
      for(ProductEntity producto: lista){
    %>
    <tr>
      <td><%=producto.getSku() %></td>
      <td><%=producto.getLabel() %></td>
      <td><%=producto.getGtin() %></td>
      <td><%=producto.getCreatedAt() %></td>
      <td><a href="/products/details?id=<%=producto.getProductId()%>">Consultar</a> </td>
      <td>
        <a href="/products/edit?id=<%= producto.getProductId() %>">
          <img src="/Images/editar.png" alt="Editar" />
        </a>
      </td>
      <td>
        <a href="/attributes/delete?id=<%= producto.getProductId() %>">
          <img src="/Images/eliminar.png" alt="Eliminar" />
        </a>
      </td>
    </tr>
    <%
        }
    %>
  </table>
  <a href="/products/new">
    <img src="/Images/ayadir.png" alt="Ayadir" />
  </a>

  </body>
</html>
