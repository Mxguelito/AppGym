package CONT;


public class Dieta {
	private String nombre;
	private int duracion;
	
	public Dieta(String nombre, int duracion ) {
		super();
		this.nombre = nombre;
		this.duracion = duracion;
		
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	
	
	
	public static void menu() {
		
	}
	public void mostrarMenuDia(int dia) {
		
	}
public void agregarComida(String comida ) {
		
	}
public void eliminarComida(String comida ) {
	
}

	
	@Override
	public String toString() {
		return "Dieta [nombre=" + nombre + ", duracion=" + duracion + ", comidasPorDia="  + "]";
	}
	

}
