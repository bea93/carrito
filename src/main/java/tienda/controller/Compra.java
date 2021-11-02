package tienda.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tienda.model.LineaPedido;
import tienda.model.Producto;
import tienda.util.Datos;

/**
 * Servlet implementation class Compra
 */
@WebServlet("/Compra")
public class Compra extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Compra() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		double total = 0;
		
		ArrayList<LineaPedido> carrito = (ArrayList<LineaPedido>) request.getSession().getAttribute("carrito");
		if(carrito.size() > 0) {
			for(int i = 0; i < carrito.size(); i++) {
				LineaPedido lp = carrito.get(i);
				Producto producto = lp.getProducto();
				int cantidad = lp.getCantidad();
				total += total + (producto.getPrecio() * cantidad);
				actualizarDisponibles(producto, cantidad);
			}
			request.getSession().setAttribute("carrito", null);
			
			total = Math.round(total = 100.0) / 100.0;
			request.getSession().setAttribute("mensaje", "Compra realizada. El total es: " + total + "€");
		}else {
			request.getSession().setAttribute("mensaje", "Carrito vacío");
		}
		response.sendRedirect("");
	}
	
	private void actualizarDisponibles(Producto producto, int cantidad) {
		ArrayList<Producto> catalogo = Datos.getCatalogo();
		for(int i = 0; i < catalogo.size(); i++) {
			Producto p = catalogo.get(i);
			if(producto.getId() == p.getId()) {
				p.setDisponibles(p.getDisponibles() - cantidad);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
