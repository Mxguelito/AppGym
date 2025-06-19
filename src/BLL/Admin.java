package BLL;
import java.util.LinkedList;

import javax.swing.JOptionPane;

public class Admin extends Usuario {

	private int dni;
	public Admin() {}
	public Admin(int id,String nombre, String email, String contrasena,String tipo,int dni) {
		super(id,nombre,email,contrasena,tipo);
		this.dni=dni;
		
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	
	public  static void menuAdmin() {
		
		String []opciones = {                                     
				"Gestionar Usuario", //0
				">>Cerrar Sesión<<"//1
				//FALTA MODIFICAR,ELIMINAR...
			};
		int elegido ;
		do {
		
		elegido= JOptionPane.showOptionDialog(null,
				"Bienvenido", null, 0, 0, null, opciones, opciones[0]);
		switch (elegido) {
		case 0:
			gestionarUsuario();
			break;
				
		
/************/		case 1:
			JOptionPane.showMessageDialog(null, "Saliendo...");

			break;
		default:
			break;
		}
		
		} while (elegido!=1);
	}
	public static void gestionarUsuario() {
		LinkedList<String>listaDeClientes= new LinkedList<String>();
		LinkedList<String>listaDeEntrenadores= new LinkedList<String>();
		JOptionPane.showMessageDialog(null,listaDeEntrenadores);
		JOptionPane.showMessageDialog(null,listaDeClientes);
		
	}
	
	@Override
	public String toString() {
		return "Admin [dni=" + dni + "]";
	}
	
	
	     

}
