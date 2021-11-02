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
 * Servlet implementation class Carrito
 */
@WebServlet("/carrito")
public class Carrito extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Carrito() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operacion = request.getParameter("o");
		Integer idProducto = new Integer(request.getParameter("p"));
		
		ArrayList<LineaPedido> carrito = (ArrayList<LineaPedido>) request.getSession().getAttribute("carrito");
		if(operacion.equals("add")) {
			Producto producto = Datos.getProductoById(idProducto);
			if(producto != null) {
				boolean existe = existeProducto(idProducto, carrito);
				if(!existe) {
					LineaPedido lp = new LineaPedido(carrito.size() + 1, producto, 1);
					carrito.add(lp);
				}else {
					LineaPedido lp = buscarLineaPedidoCarritoByIdProducto(idProducto, carrito);
					lp.setCantidad(lp.getCantidad()+1);
				}
			}
			response.sendRedirect("");
		}else if(operacion.equals("del")) {
			LineaPedido lp = buscarLineaPedidoCarritoByIdProducto(idProducto, carrito);
			if(lp.getCantidad() == 1) {
				for(int i = 0; i < carrito.size(); i++) {
					Producto producto = carrito.get(i).getProducto();
					if(producto.getId() == idProducto) {
						carrito.remove(i);
					}
				}
			}else {
				lp.setCantidad(lp.getCantidad() -1);
			}
			request.getRequestDispatcher("/carrito.jsp").forward(request, response);
			
		}
		
	}
	
	private boolean existeProducto(int id, ArrayList<LineaPedido> carrito) {
		for(int i = 0; i < carrito.size(); i++) {
			Producto producto = carrito.get(i).getProducto();
			if(producto.getId() == id) {
				return true;
			}
		}
		return false;
	}
	
	private LineaPedido buscarLineaPedidoCarritoByIdProducto(int id, ArrayList<LineaPedido>carrito) {
		for(int i = 0; i < carrito.size(); i++) {
			Producto producto = carrito.get(i).getProducto();
			if(producto.getId() == id) {
				return carrito.get(i);
			}
		}
		return null;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
