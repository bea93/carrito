package tienda.util;

import java.util.ArrayList;
import tienda.model.Producto;

public class Datos {

	private static ArrayList<Producto> catalogo = cargarCatalogo();
	
	private static ArrayList<Producto> cargarCatalogo(){
		ArrayList<Producto> catalogo = new ArrayList<Producto>();
		catalogo.add(new Producto(1, "Cerveza", 1.0, 50));
		catalogo.add(new Producto(2, "Macarrones", 1.8, 20));
		catalogo.add(new Producto(3, "Queso", 2.5, 30));
		catalogo.add(new Producto(4, "Chocolate", 3.0, 50));
		catalogo.add(new Producto(5, "Galletas", 4.30, 25));
		
		return catalogo;
	}
	
	public static ArrayList<Producto> getCatalogo(){
		return catalogo;
	}
	
	public static Producto getProductoById(Integer id) {
		for(int i = 0; i < catalogo.size(); i++) {
			Producto producto = catalogo.get(i);
			if(producto.getId() == id) {
				return producto;
			}
		}
		
		return null;
	}
}
