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
 * Servlet implementation class Tienda
 */
@WebServlet("")
public class Tienda extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Tienda() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mensaje = (String)request.getSession().getAttribute("mensaje");
		request.getSession().setAttribute("mensaje", null);
		request.setAttribute("mensaje", mensaje);
		
		ArrayList<LineaPedido>  carrito = (ArrayList<LineaPedido>)request.getSession().getAttribute("carrito");
		
		if(carrito == null) {
			carrito = new ArrayList<LineaPedido>();
			request.getSession().setAttribute("carrito", carrito);
		}
		
		ArrayList<Producto> catalogo = Datos.getCatalogo();
		request.setAttribute("catalogo", catalogo);
		
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				doGet(request, response);
	}

}
