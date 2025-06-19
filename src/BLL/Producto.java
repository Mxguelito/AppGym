package BLL;

public class Producto {
	
	private int id_producto;
	private String nombre;
	private String codigo;
	private double precio;
	private String proveedor;
	private int  stock;
	public Producto() {
		super();
	}
	public Producto(int id_producto, String nombre, String codigo, double precio, String proveedor, int stock) {
		super();
		this.id_producto = id_producto;
		this.nombre = nombre;
		this.codigo = codigo;
		this.precio = precio;
		this.proveedor = proveedor;
		this.stock = stock;
	}
	public int getId_producto() {
		return id_producto;
	}
	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public String getProveedor() {
		return proveedor;
	}
	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	

}
