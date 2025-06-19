package BLL;

public class Detalle {
	private int id_detalle;
	private String codigo_producto;
	private int cantidad;
	private double precio;
	private int id_venta;
	public Detalle() {
		super();
	}
	public Detalle(int id_detalle, String codigo_producto, int cantidad, double precio, int id_venta) {
		super();
		this.id_detalle = id_detalle;
		this.codigo_producto = codigo_producto;
		this.cantidad = cantidad;
		this.precio = precio;
		this.id_venta = id_venta;
	}
	public int getId_detalle() {
		return id_detalle;
	}
	public void setId_detalle(int id_detalle) {
		this.id_detalle = id_detalle;
	}
	public String getCodigo_producto() {
		return codigo_producto;
	}
	public void setCodigo_producto(String codigo_producto) {
		this.codigo_producto = codigo_producto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getId_venta() {
		return id_venta;
	}
	public void setId_venta(int id_venta) {
		this.id_venta = id_venta;
	}
	
	

}
