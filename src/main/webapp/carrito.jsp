<%@page import="tienda.model.LineaPedido"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Carrito</title>
</head>
<body>
<%
	//Para mostrar mensajes en la ventana
	String mensaje = (String) request.getAttribute("mensaje");

	//Si mensaje es null(no se ha creado aún), le asignamos el valor "" para que no salga nada
	if (mensaje == null) {
		mensaje = "";
	}
	ArrayList<LineaPedido> lp = (ArrayList<LineaPedido>)request.getAttribute("carrito");
	%>
	<h1>Carrito</h1>
	<h2><%= mensaje %></h2>
	
	
	<table>
		<tr>
			<th>Nombre</th>
			<th>Precio</th>
			<th>Cantidad</th>
			<th>Total</th>
			<th></th>
		</tr>
		<%
			//Si el catalogo de productos tiene alguno los mostramos dentro de la tabla	
			if(carrito != null){
				for(int i = 0; i < carrito.size(); i++){
					LineaPedido lp = carrito.get(i);
				}
			}
		%>
		<tr>
			<td><%= lp.getProducto().getNombre() %></td>
			<td><%= lp.getProducto().getPrecio() %></td>
			<td><%= lp.getCantidad() %></td>
			<td><%= Math.round(lp.getCantidad() * lp.getProducto().getPrecio() * 100.0) / 100.0 %></td>
			<td><a href="<% request.getContextPath();%>/carrito?o=del&p=<%=lp.getProducto().getId()%>">Eliminar del carro</a></td>
		</tr>
	</table>
</body>
</html>