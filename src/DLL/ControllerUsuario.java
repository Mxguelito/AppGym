package DLL;
import java.sql.ResultSet;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import java.sql.Connection;
import java.sql.PreparedStatement;
import BLL.Cliente;
import BLL.Entrenador;
import BLL.Usuario;
import Repository.UsuarioRepository;
import BLL.Admin;
public class ControllerUsuario<T extends Usuario> implements UsuarioRepository {
	
	private static Connection con = Conexion.getInstance().getConnection();
	 
	@SuppressWarnings("unchecked")
	public T login(String email, String pass) {
	        T usuario = null;
	        try {
	            PreparedStatement stmt = con.prepareStatement(
	                
	                  "SELECT * FROM usuario WHERE email = ? AND pass = ?" 
	               
	            );
	            stmt.setString(1, email);
	            stmt.setString(2, pass);
	            ResultSet rs = stmt.executeQuery();
	          
	            
	            if (rs.next()) {
	                int id_usuario =rs.getInt("id_usuario");
	                String nombre = rs.getString("nombre");
	                String correo = rs.getString("email");
	                String password = rs.getString("pass");
	               

	                
	                
	                
	/*                switch (tipo.toLowerCase()) {
                    case "cliente":
                    	int altura=rs.getInt("altura");
                 
                    	int peso=rs.getInt("peso");
                    	int edad=rs.getInt("edad");
                    	String nivel=rs.getString("nivel");
                 
                        usuario = (T) new Cliente(id,nombre,email,contrasena, tipo,altura,peso,edad,nivel);
	                
                        
              
                        break;
                    case "entrenador":
                    	int telefono=rs.getInt("telefono");
                        usuario = (T) new Entrenador(id, nombre,email,contrasena,tipo,telefono,id);
                        break;
                    case "admin":
                    	int dni=rs.getInt("dni");
                        usuario = (T) new Admin(id,nombre,email,contrasena,tipo,dni);
                        break;
                    default:
                        System.out.println("Tipo de usuario desconocido: " + tipo);
                        break;
                }*/
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuario;
    }
	
	
	
	public static void  agregarUsuario(Usuario usuario) {
		try {
			 PreparedStatement statement = con.prepareStatement(
					"INSERT INTO `usuario`( `nombre`, `email`, `contrasena`, `tipo`) VALUES (?,?,?,?)"  );
			 statement.setString(1, usuario.getNombre());
			 statement.setString(2, usuario.getEmail());
			 statement.setString(3, usuario.getContrasena());
			 statement.setString(4, usuario.getTipo());
			   int filas = statement.executeUpdate();
			   if (filas > 0) {
	                System.out.println("Usuario agregado correctamente.");
	            }
			
		} catch (Exception e) {
			 e.printStackTrace();
		}
	}
	
	
	
	public static LinkedList<Usuario> mostrarUsuarios() {
		//CREA UNA LISTA DE USUARIOS
        LinkedList<Usuario> usuarios = new LinkedList<>();
        try {
        	//SELECCIONA LA TABLA USUARIO
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM usuario");
            //EJECUTA LA TABLA DE USUARIO Y EL RESULTADO LO GUARDA EN RESULTSET
            ResultSet rs = stmt.executeQuery();

            
            //RS.NEXT MUEVE EL CURSOR A LA SIGUIENTE FILA DE RESULTADO
            while (rs.next()) {
                int id = rs.getInt("idUsuario");
                String nombre = rs.getString("nombre");
                String email = rs.getString("email");
                String contrasena = rs.getString("contrasena");
                String tipo = rs.getString("tipo");

                usuarios.add(new Usuario(id, nombre, email,contrasena,tipo));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuarios;
    }
	
	
	 public static void RegistrarUsuario(Usuario nuevo) {
	    	//CREA UNA LISTA
	    	LinkedList<Usuario> existentes = mostrarUsuarios();
	    	//CREA UNA BANDERA VERDADERA
	    	boolean flag = true;
	    	
	    	//RECORRE LA LISTA DE USUARIO EXISTENTES
	    	for (Usuario existente : existentes) {
	    		
	    		//SI EL USUARIO EXISTE 
				if (existente.getEmail().equals(nuevo.getEmail())) {
					//LA BANDERA ES FALSA
					flag = false;
					break;
				}
			}
	    	//BANDERA VERDADERA
	    	if (flag) {
	    		//CREA USUARIO*********
	    		agregarUsuario(nuevo);
	    		
	    		//BANDERA FALSA,USUARIO YA CREADO
			}else {
				JOptionPane.showMessageDialog(null, "Usuario ya creado");
			}
	    	
	    	
	    }
	 public T IngresarCliente(String nombre, String contrasena) {
	        T cliente = null;
	        try {
	            PreparedStatement stmt = con.prepareStatement(
	                
	                  "SELECT * FROM usuario u " + 
	                  "LEFT JOIN cliente c ON u.idUsuario = c.Usuario_idUsuario " +
	                 
	                  "WHERE u.nombre = ? AND u.contrasena = ?"
	            );
	            stmt.setString(1, nombre);
	            stmt.setString(2, contrasena);
	            ResultSet rs = stmt.executeQuery();
	          
	            
	            if (rs.next()) {
	                int id = rs.getInt("idUsuario");
	                String email = rs.getString("email");
	                String tipo = rs.getString("tipo");
	                
	                
	                
	                
	               int altura= rs.getInt("altura");
	               
	               
	                boolean tieneCliente=! rs.wasNull();
	                
	                if(tieneCliente) {
	                	int peso= rs.getInt("peso");
	                	int edad= rs.getInt("edad");
	                	String nivel= rs.getString("nivel");
	                	JOptionPane.showMessageDialog(null, "Ya tenes datos cargados: \n altura:"+ altura + "\n peso:" + peso+"\n edad:"+ edad + "\n nivel:"+ nivel );
	             //*****************************************************************  
	                	
	                	
	                	
	                	
	                }else{
	                	
	                	altura = Integer.parseInt(JOptionPane.showInputDialog("Ingrese altura"));
	                	 int peso = Integer.parseInt(JOptionPane.showInputDialog("Ingrese peso"));
	                	int edad= Integer.parseInt(JOptionPane.showInputDialog("Ingrese edad"));
	                   String nivel=JOptionPane.showInputDialog("Ingrese Su Nivel Físico\n.....Principiante.....\n.....Intermedio.....\n.....Avanzado.....");
	                			
	        			
	        			
	                			
	                			
	                			
	                	PreparedStatement insertCliente= con.prepareStatement(
	                			
	                			"INSERT INTO cliente (altura,peso,edad,nivel,Usuario_idUsuario) VALUES (?,?,?,?,?)"
	                			);
	                	
	                	insertCliente.setInt(1, altura);
	                	insertCliente.setInt(2, peso);
	                	insertCliente.setInt(3, edad);
	                	insertCliente.setString(4, nivel);
	                	insertCliente.setInt(5,id );
	                	
	                	insertCliente.executeUpdate();
	                	
	                	JOptionPane.showMessageDialog(null, "Datos insertados correctamente");
	                }
	                
	                
	                }else {JOptionPane.showMessageDialog(null, "usuario o contraseña incorrecta");
	                
	                }       	
	             
     } catch (Exception e) {
         e.printStackTrace();
     }
     return cliente;
 }
	 public T IngresarEntrenador(String nombre, String contrasena) {
	        T entrenador = null;
	        try {
	            PreparedStatement stmt = con.prepareStatement(
	                
	                  "SELECT * FROM usuario u " + 
	                  "LEFT JOIN entrenador c ON u.idUsuario = c.Usuario_idUsuario " +
	                 
	                  "WHERE u.nombre = ? AND u.contrasena = ?"
	            );
	            stmt.setString(1, nombre);
	            stmt.setString(2, contrasena);
	            ResultSet rs = stmt.executeQuery();
	          
	            
	            if (rs.next()) {
	                int id = rs.getInt("idUsuario");
	                String email = rs.getString("email");
	                String tipo = rs.getString("tipo");
	                
	                
	                
	                
	               int telefono= rs.getInt("telefono");
	               
	               
	                boolean tieneEntrenador=! rs.wasNull();
	                
	                if(tieneEntrenador) {
	                	
	                	telefono= rs.getInt("telefono");
	                	 
	                	JOptionPane.showMessageDialog(null, "Ya tenes datos cargados: \n Usuario:"+ id + "\n email:" + email+"\n Tipo De Usuario:"+ tipo + "\n telefono:"+ telefono );
	             //*****************************************************************  
	                	
	                	
	                	
	                	
	                }else{
	                	
	                	telefono = Integer.parseInt(JOptionPane.showInputDialog("ingrese telefono"));
	                
	                			
	        			
	        			
	                			
	                			
	                			
	                	PreparedStatement insertEntrenador= con.prepareStatement(
	                			
	                			"INSERT INTO entrenador (telefono,Usuario_idUsuario) VALUES (?,?)"
	                			);
	                	
	                	insertEntrenador.setInt(1, telefono);
	                	insertEntrenador.setInt(2, id);
	                	
	                	
	                	insertEntrenador.executeUpdate();
	                	
	                	JOptionPane.showMessageDialog(null, "Datos insertados correctamente");
	                }
	                
	                
	                }else {JOptionPane.showMessageDialog(null, "usuario o contraseña incorrecta");
	                
	                }       	
	             
  } catch (Exception e) {
      e.printStackTrace();
  }
  return entrenador;
}
	 public T IngresarAdmin(String nombre, String contrasena) {
	        T admin = null;
	        try {
	            PreparedStatement stmt = con.prepareStatement(
	                
	                  "SELECT * FROM usuario u " + 
	                  "LEFT JOIN admin c ON u.idUsuario = c.Usuario_idUsuario " +
	                 
	                  "WHERE u.nombre = ? AND u.contrasena = ?"
	            );
	            stmt.setString(1, nombre);
	            stmt.setString(2, contrasena);
	            ResultSet rs = stmt.executeQuery();
	          
	            
	            if (rs.next()) {
	                int id = rs.getInt("idUsuario");
	                String email = rs.getString("email");
	                String tipo = rs.getString("tipo");
	                
	                
	                
	                
	               int dni= rs.getInt("dni");
	               
	               
	                boolean tieneAdmin=! rs.wasNull();
	                
	                if(tieneAdmin) {
	                	
	                	dni= rs.getInt("dni");
	                	 
	                	JOptionPane.showMessageDialog(null, "Ya tenes datos cargados: \n Usuario:"+ id + "\n email:" + email+"\n Tipo De Usuario:"+ tipo + "\n dni:"+ dni );
	             //*****************************************************************  
	                	
	                	
	                	
	                	
	                }else{
	                	
	                	dni = Integer.parseInt(JOptionPane.showInputDialog("Ingrese Su DNI"));
	                
	                			
	        			
	        			
	                			
	                			
	                			
	                	PreparedStatement insertAdmin= con.prepareStatement(
	                			
	                			"INSERT INTO admin (dni,Usuario_idUsuario) VALUES (?,?)"
	                			);
	                	
	                	insertAdmin.setInt(1, dni);
	                	insertAdmin.setInt(2, id);
	                	
	                	
	                	insertAdmin.executeUpdate();
	                	
	                	JOptionPane.showMessageDialog(null, "Datos insertados correctamente");
	                }
	                
	                
	                }else {JOptionPane.showMessageDialog(null, "usuario o contraseña incorrecta");
	                
	                }       	
	             
} catch (Exception e) {
   e.printStackTrace();
}
return admin;
}
	 public T InsertarPlanBasico(String nombre, String contrasena) {
	        T planBasico = null;
	        try {
	            PreparedStatement stmt = con.prepareStatement(
	                
	                  "SELECT * FROM usuario u " + 
	                  "LEFT JOIN plan c ON u.idUsuario = u.idUsuario " +
	                 
	                  "WHERE u.nombre = ? AND u.contrasena = ?"
	            );
	            stmt.setString(1, nombre);
	            stmt.setString(2, contrasena);
	            ResultSet rs = stmt.executeQuery();
	          
	            
	            if (rs.next()) {
	                int id = rs.getInt("idUsuario");
	                String email = rs.getString("email");
	                String tipo = rs.getString("tipo");
	                
	                
	                
	                int id_Plan=rs.getInt("id_Plan");

	                
	               int Basico= rs.getInt("Basico");
	               
	        			Basico=1;
	        			int VIP=rs.getInt("VIP");
	        			
	        			 VIP=0;
	                			
	                			
	                			
	                	PreparedStatement insertPlanBasico= con.prepareStatement(
	                			
	                			"INSERT INTO plan (Basico,VIP, idCliente) VALUES (?,?,?)"
	                			);
	                	
	                	insertPlanBasico.setInt(1, Basico);
	                	insertPlanBasico.setInt(2, VIP);
	                	insertPlanBasico.setInt(3, id);
	                	
	                	
	                	insertPlanBasico.executeUpdate();
	                	
	                	JOptionPane.showMessageDialog(null, "Plan Basico asignado");
	                
	                
	                
	                }else {JOptionPane.showMessageDialog(null, "usuario o contraseña incorrecta");
	                
	                }       	
	             
} catch (Exception e) {
e.printStackTrace();
}
return planBasico;
}
	 public T InsertarPlanVIP(String nombre, String contrasena) {
	        T planVIP = null;
	        try {
	            PreparedStatement stmt = con.prepareStatement(
	                
	                  "SELECT * FROM usuario u " + 
	                  "LEFT JOIN plan c ON u.idUsuario = u.idUsuario " +
	                 
	                  "WHERE u.nombre = ? AND u.contrasena = ?"
	            );
	            stmt.setString(1, nombre);
	            stmt.setString(2, contrasena);
	            ResultSet rs = stmt.executeQuery();
	          
	            
	            if (rs.next()) {
	                int id = rs.getInt("idUsuario");
	                String email = rs.getString("email");
	                String tipo = rs.getString("tipo");
	                
	                
	                
	                
	                
	               
	               int id_Plan=rs.getInt("id_Plan");

	        			int Basico=rs.getInt("Basico");
	        			Basico=0;
	        			int VIP=rs.getInt("VIP");
	        			VIP=1;
	                			
	                			
	                			
	                	PreparedStatement insertPlanVIP= con.prepareStatement(
	                			
	                			"INSERT INTO plan (Basico,VIP, idCliente) VALUES (?,?,?)"
	                			);
	                	insertPlanVIP.setInt(1, Basico);
	                	insertPlanVIP.setInt(2, VIP);
	                	insertPlanVIP.setInt(3, id);
	                	
	                	
	                	
	                	insertPlanVIP.executeUpdate();
	                	
	               
	                
	                
	                }else {JOptionPane.showMessageDialog(null, "usuario o contraseña incorrecta");
	                
	                }       	
	             
} catch (Exception e) {
e.printStackTrace();
}
return planVIP;
}
	 public T insertarBasico(String nombre, String contrasena) {
		    T basico = null;
	        try {
	            PreparedStatement stmt = con.prepareStatement(
	                
	                  "SELECT * FROM usuario u " + 
	                  "LEFT JOIN plan c ON u.idUsuario = u.idUsuario " +
	                 
	                  "WHERE u.nombre = ? AND u.contrasena = ?"
	            );
	            stmt.setString(1, nombre);
	            stmt.setString(2, contrasena);
	            ResultSet rs = stmt.executeQuery();
	          
	            
	            if (rs.next()) {
	                int id = rs.getInt("idUsuario");
	                String email = rs.getString("email");
	                String tipo = rs.getString("tipo");
	                
	                
	                
	                
	               int Basico= rs.getInt("Basico");
	               
	               
	           
	                
	                	
	               
	                	
	                	String Objetivo="";
	                	
	                	String []opciones1= {"Volumen","Definicion","Estetica","Salud"};
	        			String opcionSelecionada=(String)JOptionPane.showInputDialog(null,"Selecione una Opcion:","Menú Principal",JOptionPane.QUESTION_MESSAGE,null,opciones1,opciones1[0]);
	        			if (opcionSelecionada.equals("Volumen")) {
	        			Objetivo=opcionSelecionada;
	        			}else if (opcionSelecionada.equals("Definicion")) {
	        				Objetivo=opcionSelecionada;
	        				
	        			}else if (opcionSelecionada.equals("Estetica")) {
	        				Objetivo=opcionSelecionada;
	        			}else if (opcionSelecionada.equals("Salud")) {
	        				Objetivo=opcionSelecionada;
	        			}else {
	        				JOptionPane.showMessageDialog(null, "Algo anda Mal...Verifique info...");
	        			}
	        			
	                
	        			
	        			int Precio=5000;
	        			
	        			
	        			
	        			int id_Plan=rs.getInt("id_Plan");
	        			
	        			
	        			
	        			
	                			
	                			
	                			
	                	PreparedStatement insertBasico= con.prepareStatement(
	                			
	                		  "INSERT INTO basico(Precio,Objetivo,idCliente)VALUES 	(?,?,?)"
	                
	                			);
	                	
	                	insertBasico.setInt(1,Precio);
	                	insertBasico.setString(2,Objetivo);
	                	insertBasico.setInt(3,id);
	                	
	                	
	                
	                	
	                	
	                	insertBasico.executeUpdate();
	                	
	                	JOptionPane.showMessageDialog(null, "Basico Aceptado...");
	                	
	                	
	                
	                
	            
	            }
	            }
	               
	                      	
	             
 catch (Exception e) {
e.printStackTrace();
}
return basico;
}
	 public T insertarVIP(String nombre, String contrasena) {
	        T vip = null;
	        try {
	            PreparedStatement stmt = con.prepareStatement(
	                
	                  "SELECT * FROM usuario u " + 
	                  "LEFT JOIN plan c ON u.idUsuario = u.idUsuario " +
	                 
	                  "WHERE u.nombre = ? AND u.contrasena = ?"
	            );
	            stmt.setString(1, nombre);
	            stmt.setString(2, contrasena);
	            ResultSet rs = stmt.executeQuery();
	          
	            
	            if (rs.next()) {
	                int id = rs.getInt("idUsuario");
	                String email = rs.getString("email");
	                String tipo = rs.getString("tipo");
	                
	                
	                
	                
	               int VIP= rs.getInt("VIP");
	               
	               
	           
	                
	                	
	               
	                	
	                	String Objetivo="";
	                	
	                	String []opciones1= {"Volumen","Definicion","Estetica","Salud"};
	        			String opcionSelecionada=(String)JOptionPane.showInputDialog(null,"Selecione una Opcion:","Menú Principal",JOptionPane.QUESTION_MESSAGE,null,opciones1,opciones1[0]);
	        			if (opcionSelecionada.equals("Volumen")) {
	        			Objetivo=opcionSelecionada;
	        			}else if (opcionSelecionada.equals("Definicion")) {
	        				Objetivo=opcionSelecionada;
	        				
	        			}else if (opcionSelecionada.equals("Estetica")) {
	        				Objetivo=opcionSelecionada;
	        			}else if (opcionSelecionada.equals("Salud")) {
	        				Objetivo=opcionSelecionada;
	        			}else {
	        				JOptionPane.showMessageDialog(null, "Algo anda Mal...Verifique info...");
	        			}
	        			
	                
	        			
	        			int Precio=10000;
	        			
	        			
	        			
	        			int id_Plan=rs.getInt("id_Plan");
	        			
	        			
	        			
	        			
	                			
	                			
	                			
	                	PreparedStatement insertVIP= con.prepareStatement(
	                			
	                		  "INSERT INTO vip(Precio,Objetivo,idCliente)VALUES 	(?,?,?)"
	                
	                			);
	                	
	                	insertVIP.setInt(1,Precio);
	                	insertVIP.setString(2,Objetivo);
	                	insertVIP.setInt(3,id);
	                	
	                	
	                
	                	
	                	
	                	insertVIP.executeUpdate();
	                	
	                	JOptionPane.showMessageDialog(null, "Vip Aceptado...");
	                	
	                	
	                
	                
	            
	            }
	            }
	               
	                      	
	             
 catch (Exception e) {
e.printStackTrace();
}
return vip;
}
	 public T insertarEjercicio(String nombre, String contrasena) {
	        T ejercicio = null;
	        try {
	            PreparedStatement stmt = con.prepareStatement(
	                
	                  "SELECT * FROM usuario u " + 
	                  "LEFT JOIN rutina c ON u.idUsuario = c.Usuario_idUsuario " +
	                 
	                  "WHERE u.nombre = ? AND u.contrasena = ?"
	            );
	            stmt.setString(1, nombre);
	            stmt.setString(2, contrasena);
	            ResultSet rs = stmt.executeQuery();
	          
	            
	            if (rs.next()) {
	                int id = rs.getInt("idUsuario");
	                String email = rs.getString("email");
	                String tipo = rs.getString("tipo");
	                
	                
	                
	                
	               String Ejercicio= rs.getString("Ejercicio");
	               
	               
	                boolean tieneEjercicio=! rs.wasNull();
	                
	                if(tieneEjercicio) {
	                	String Series=rs.getString("Series");
	                	int VecesXsemana=rs.getInt("VecesXsemana");
	                	
	                	
	                	JOptionPane.showMessageDialog(null, "Ya tiene Ejercicio: \n Ejercicio:"+ Ejercicio + "\n Series:" + Series+"\n VecesXsemana:"+ VecesXsemana + "\n usuario:"+ nombre );
	             //*****************************************************************  
	                	
	                	
	                	
	                	
	                }else{
	                	
	                	
	                	
	                	
	                	String []opciones1= {"Sentadillas","Cardio","FullBody","GAP","Resistencia"};
	        			String opcionSelecionada=(String)JOptionPane.showInputDialog(null,"Selecione Ejercicio:","Rutinas",JOptionPane.QUESTION_MESSAGE,null,opciones1,opciones1[0]);
	        			if (opcionSelecionada.equals("Sentadillas")) {
	        			Ejercicio=opcionSelecionada;
	        			}else if (opcionSelecionada.equals("Cardio")) {
	        				Ejercicio=opcionSelecionada;
	        				
	        			}else if (opcionSelecionada.equals("FullBody")) {
	        				Ejercicio=opcionSelecionada;
	        			}else if (opcionSelecionada.equals("GAP")) {
	        				Ejercicio=opcionSelecionada;
	        			}else if (opcionSelecionada.equals("Resistencia")) {
	        				Ejercicio=opcionSelecionada;
	        			}
	        			else {
	        				JOptionPane.showMessageDialog(null, "Algo anda Mal...Verifique info...");
	        			}
	        			//----------------------------------------------------
	        			String Series=rs.getString("Series");
	        			String []opciones2= {"2x10","3x10","3x15","4x10","4x15"};
	        			String opcionSelecionada1=(String)JOptionPane.showInputDialog(null,"Selecione una Opcion:","Menú Principal",JOptionPane.QUESTION_MESSAGE,null,opciones2,opciones2[0]);
	        			if (opcionSelecionada.equals("2x10")) {
	        				Series=opcionSelecionada;
	        			}else if (opcionSelecionada.equals("3x10")) {
	        				Series=opcionSelecionada;
	        				
	        			}else if (opcionSelecionada.equals("3x15")) {
	        				Series=opcionSelecionada;
	        			}else if (opcionSelecionada.equals("4x10")) {
	        				Series=opcionSelecionada;
	        			}else if (opcionSelecionada.equals("4x15")) {
	        				Series=opcionSelecionada;
	        			}
	        			else {
	        				JOptionPane.showMessageDialog(null, "Algo anda Mal...Verifique info...");
	        			}
	        			
	        			int VecesXsemana=rs.getInt("VecesXsemana");
	        			VecesXsemana=Integer.parseInt(JOptionPane.showInputDialog("Cantidad De VecesXsemana"));
	        			
	        			
	                			int id_Plan=rs.getInt("id_Plan");
	        			
	        			
	                			
	                			
	                			
	                	PreparedStatement insertEjercicio= con.prepareStatement(
	                			
	                			"INSERT INTO  ( Ejercicio, Series, VecesXsemana, id_Plan) VALUES (?,?,?,?)"
	                			);
	                	
	                	insertEjercicio.setString(1, Ejercicio);
	                	insertEjercicio.setString(2, Series);
	                	insertEjercicio.setInt(3, VecesXsemana);
	                	insertEjercicio.setInt(4, id_Plan);
	               
	                	
	                	
	                	insertEjercicio.executeUpdate();
	                	
	                	JOptionPane.showMessageDialog(null, "Datos insertados correctamente");
	                }
	                
	                
	                }else {JOptionPane.showMessageDialog(null, "usuario o contraseña incorrecta");
	                
	                }       	
	             
} catch (Exception e) {
e.printStackTrace();
}
return ejercicio;
}
	 public T IngresarDieta(String nombre, String contrasena) {
	        T dieta = null;
	        try {
	            PreparedStatement stmt = con.prepareStatement(
	                
	                  "SELECT * FROM usuario u " + 
	                  "LEFT JOIN dieta c ON u.idUsuario = c.Usuario_idUsuario " +
	                 
	                  "WHERE u.nombre = ? AND u.contrasena = ?"
	            );
	            stmt.setString(1, nombre);
	            stmt.setString(2, contrasena);
	            ResultSet rs = stmt.executeQuery();
	          
	            
	            if (rs.next()) {
	                int id = rs.getInt("idUsuario");
	                String email = rs.getString("email");
	                String tipo = rs.getString("tipo");
	                
	                
	                
	                
	               int id_Dieta= rs.getInt("id_Dieta");
	               
	               
	                boolean tieneDieta=! rs.wasNull();
	                
	                if(tieneDieta) {
	                	
	                	
	                	 
	                	JOptionPane.showMessageDialog(null, "Ya Tenes Un Plato: \n Plato:"+ id_Dieta + "\n email:" + email+"\n Tipo De Usuario:"+ tipo );
	             //*****************************************************************  
	                	
	                	
	                	
	                	
	                }else{
	                	
	                String Desayuno=rs.getString("Desayuno");
	                String Almuerzo=rs.getString("Almuerzo");
	                String Merienda=rs.getString("Merienda");
	                String Cena=rs.getString("Cena");
	                int id_Plan=rs.getInt("id_Plan");

	                
	                			
	        			
	        			
	                			
	                			
	                			
	                	PreparedStatement insertDieta= con.prepareStatement(
	                			
	                			"INSERT INTO admin (Desayuno, Almuerzo, Merienda, Cena, id_Plan) VALUES (?,?,?,?,?)"
	                			);
	                	
	                	insertDieta.setString(1, Desayuno);
	                	insertDieta.setString(2, Almuerzo);
	                	insertDieta.setString(3, Merienda );
	                	insertDieta.setString(4, Cena);
	                	insertDieta.setInt(5, id_Plan);
	                	
	                	
	                	insertDieta.executeUpdate();
	                	
	                	JOptionPane.showMessageDialog(null, "Datos insertados correctamente");
	                }
	                
	                
	                }else {JOptionPane.showMessageDialog(null, "usuario o contraseña incorrecta");
	                
	                }       	
	             
} catch (Exception e) {
e.printStackTrace();
}
return dieta;
}
	
	
	 
	  
	           
}
