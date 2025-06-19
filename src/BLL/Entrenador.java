package BLL;


public class Entrenador {
	
	
	private int id_entrenador;
	private String nombre;
	private int telefono;
	private String especializacion;
	public Entrenador() {
		super();
	}
	public Entrenador(int id_entrenador, String nombre, int telefono, String especializacion) {
		super();
		this.id_entrenador = id_entrenador;
		this.nombre = nombre;
		this.telefono = telefono;
		this.especializacion = especializacion;
	}
	public int getId_entrenador() {
		return id_entrenador;
	}
	public void setId_entrenador(int id_entrenador) {
		this.id_entrenador = id_entrenador;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public String getEspecializacion() {
		return especializacion;
	}
	public void setEspecializacion(String especializacion) {
		this.especializacion = especializacion;
	}
	
	
	

	
}
