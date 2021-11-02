package tienda.model;

public class Producto {
	private int id;
	private String nombre;
	private double precio;
	private int disponibles;
	
	public Producto(int id, String nombre, double precio, int disponibles) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.disponibles = disponibles;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public double getPrecio() {
		return precio;
	}
	
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public int getDisponibles() {
		return disponibles;
	}
	
	public void setDisponibles(int disponibles) {
		this.disponibles = disponibles;
	}
	
}
