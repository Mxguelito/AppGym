package BLL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import DLL.Conexion;
import DLL.ControllerUsuario;

public class Cliente extends Usuario {
	
	private static Connection con = Conexion.getInstance().getConnection();
	
	private int altura=0;
	private int peso=0;
    private int edad=0;
    private String nivel="";

	
	
    public Cliente(int id, String nombre, String email) {
    	
    }
    

	public Cliente( int id, String nombre, String email, String contrasena,String tipo, int altura, int peso, int edad, String nivel) {
		super(id, nombre, email, contrasena,tipo);
		this.altura = altura;
		this.peso = peso;
		this.edad = edad;
		this.nivel = nivel;
	}
	

	

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int  peso) {
		this.peso = peso;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	public static void menuCliente() {
		//-----------------------DATOS DEL CLIENTE------------------------------------
		
		//-------------------------------------------------------------------
	       String []opciones = {                                     
   				"Elegir Plan", //0
   				"Ver Rutinas", //1 
   				"Mostrar Proceso" //2
   				,">>Cerrar Sesión<<"//3
   			};
   /***********/		int elegido ;
   		do {
   		
   		elegido= JOptionPane.showOptionDialog(null,
   				"Bienvenido", null, 0, 0, null, opciones, opciones[0]);
   		switch (elegido) {
   		case 0:
   			String []opciones0= {"Basico","Vip"};
   			String opcionSelecionada=(String)JOptionPane.showInputDialog(null,"Selecione una Opcion:","Menú Principal",JOptionPane.QUESTION_MESSAGE,null,opciones0,opciones[0]);
   			if (opcionSelecionada.equals("Basico")) {
   		
   			}else {
   			
   			}
   			break;
   				
   			



   			
   /************/		case 1:
   	LinkedList<String> rutinas = new LinkedList<String>();
   	
   			break;
   /************/		case 2:
   	JOptionPane.showMessageDialog(null,"Mostrando progreso...");
   	
   	
   	
   		
   			
   			break;
   /************/		case 3:
   			JOptionPane.showMessageDialog(null, "Saliendo...");

   			break;
   		default:
   			break;
   		}
   		
   		} while (elegido!=3);
   		
	
	//--------------------------------------------------------------------------------	
		
		
		String []opciones1 = {                                     
				"Elegir Plan", //0
				"Ver Rutinas", //1 
				"Mostrar Proceso" //2
				,">>Cerrar Sesión<<"//3
			};
/***********/		int elegido1 ;
		do {
		
		elegido1= JOptionPane.showOptionDialog(null,
				"Bienvenido", null, 0, 0, null, opciones1, opciones1[0]);
		switch (elegido1) {
		case 0:
			String []opciones0= {"Basico","Vip"};
			String opcionSelecionada=(String)JOptionPane.showInputDialog(null,"Selecione una Opcion:","Menú Principal",JOptionPane.QUESTION_MESSAGE,null,opciones0,opciones1[0]);
			if (opcionSelecionada.equals("Basico")) {
				
				
			}else {JOptionPane.showMessageDialog(null,"Descargando Entrenamiento Vip...");
				
			}
			break;
				
			



			
/************/		case 1:
	LinkedList<String> rutinas = new LinkedList<String>();
	rutinas.add(" Cinta 20 min...");
	JOptionPane.showMessageDialog(null, rutinas);
			
			break;
/************/		case 2:
	JOptionPane.showMessageDialog(null,"Mostrando progreso...");
	
	
	
		
			
			break;
/************/		case 3:
			JOptionPane.showMessageDialog(null, "Saliendo...");

			break;
		default:
			break;
		}
		
		} while (elegido1!=3);
		
		
	}
	public static void menuPlan() {

		String []opciones = {                                     
				"Basico", //0
				"Vip", //1 
				"<<Volver Inicio"//2
			};
/***********/		int elegido ;
		do {
		
		elegido= JOptionPane.showOptionDialog(null,
				"Bienvenido", null, 0, 0, null, opciones, opciones[0]);
		switch (elegido) {
		case 0:
			
			break;
				
			



			
/************/		case 1:
	
			
			break;
/************/		
/************/		
		default:
			break;
		}
		
		} while (elegido!=2);
		
		
	}



@Override
public String toString() {
	return "Cliente [altura=" + altura + ", peso=" + peso + ", edad=" + edad + ", nivel=" + nivel + "]";
}

	

}
