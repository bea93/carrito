<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tienda Online</title>
</head>
<body>
	<%
	//Para mostrar mensajes en la ventana
	String mensaje = (String) request.getAttribute("mensaje");

	//Si mensaje es null(no se ha creado aún), le asignamos el valor "" para que no salga nada
	if (mensaje == null) {
		mensaje = "";
	}
	ArrayList<Producto> catalogo = (ArrayList<Producto>)request.getAttribute("catalogo");
	%>
	<h1>Tienda</h1>
	<h2><%= mensaje %></h2>
	<p><a href="<%=request.getContextPath() %>/carrito.jsp">Ir al carrito</a></p>
	
	<table>
		<tr>
			<th>Nombre</th>
			<th>Precio</th>
			<th>Disponibles</th>
			<th></th>
		</tr>
		<%
			//Si el catalogo de productos tiene alguno los mostramos dentro de la tabla	
			if(catalogo != null){
				for(int i = 0; i < catalogo.size(); i++){
					Producto p = catalogo.get(i);
				}
			}
		%>
		<tr>
			<td><%= p.getNombre() %></td>
			<td><%= p.getPrecio() %></td>
			<td><%= p.getDisponibles() %></td>
			<td><a href="<% request.getContextPath();%>/carrito?o=add&p=<%=p.getId()%>">Añadir al carro</a></td>
		</tr>
	</table>
</body>
</html>