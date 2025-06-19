package BLL;
import javax.swing.JOptionPane;

public class Usuario {
	private int id;
    private String nombre;
	private String email;
	private String contrasena;
	private String tipo;
	
	public Usuario() {
		
	}
	public Usuario(int id, String nombre, String email, String contrasena,String tipo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.contrasena = contrasena;
		this.tipo = tipo;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	

public void recuperarContrasena(String email) {
	  String sos=JOptionPane.showInputDialog("<<..Ingrese email..>>");
		JOptionPane.showMessageDialog(null,"enviando código a "+ sos);
	}
	
	
	
	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", email=" + email + ", contrasena=" + contrasena + "]";
	}
	

}
