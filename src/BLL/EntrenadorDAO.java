package BLL;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import DLL.Conexion2;

public class EntrenadorDAO {
	Connection con;
	Conexion2 cn=new Conexion2();
	PreparedStatement ps;
	//RESULTSET PARA EJECUTAR CONSULTA--
	ResultSet rs;
	
	public boolean RegistrarEntrenador(Entrenador en) {
		String sql="INSERT INTO entrenador (nombre,telefono,especializacion) VALUES (?,?,?)";
		try {
			con=cn.getConnection();
			ps=con.prepareStatement(sql);
			
			ps.setString(1,en.getNombre());
			ps.setInt(2,en.getTelefono());
			ps.setString(3,en.getEspecializacion());
	
			ps.execute();
			return true;
			
		} catch (SQLException e) {
			System.out.println(e.toString());
			JOptionPane.showMessageDialog(null, "La conexion fallo...");
			return false;
		}finally {
			try {
				con.close();
				
			} catch (SQLException e) {
				System.out.println(e.toString());JOptionPane.showMessageDialog(null, "El finally fallo...");
			}
		}
		
	}

	public List ListarEntrenador() {
		//CREO LISTA PARA ALMACENAR DATOS
		List<Entrenador> listaEntrenador=new ArrayList();
		
		 String sql="SELECT * FROM entrenador";
		 try {
			 //CONEXION---
			 con=cn.getConnection();
			 ps=con.prepareStatement(sql);
			 rs=ps.executeQuery();
			 
			 while (rs.next()) {
				 //CREO UN ENTRENADOR--
				 Entrenador en=new Entrenador();
			   //LEO LOS CAMPOS DE LA BASE DE DATOS---	 
				 en.setId_entrenador(rs.getInt("id_entrenador"));
				 en.setNombre(rs.getString("nombre"));
				 en.setTelefono(rs.getInt("telefono"));
				 en.setEspecializacion(rs.getString("especializacion"));
				 //AÑADO LOS DATOS DE LA BASE DE DATOS A LA LISTA DE ENTRENADORES---
				 listaEntrenador.add(en);
				
			}
			 
			
		} catch (SQLException e) {
			System.out.println(e.toString());
			JOptionPane.showMessageDialog(null, "No lee la base de Datos...");
		}
		 return listaEntrenador;
	}
	public boolean EliminarEntrenador(int id) {
		String sql= "DELETE FROM entrenador WHERE id_entrenador =? ";
		try {
			con=cn.getConnection();
			ps=con.prepareStatement(sql);
			ps.setInt(1,id);
			ps.execute();
			return true;
		} catch (SQLException e) {	
			System.out.println(e.toString());
			return false;
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				
System.out.println(e.toString());			
}
		}
		
	}
	public boolean ModificarEntrenador(Entrenador en) {
		String sql="UPDATE entrenador SET nombre=?, telefono=?,especializacion=? WHERE id_entrenador=? ";
		try {
			con=cn.getConnection();
			ps=con.prepareStatement(sql);
			ps.setString(1, en.getNombre() );
			ps.setInt(2, en.getTelefono() );
			ps.setString(3, en.getEspecializacion() );
			//---ACA VA EL WHERE ID---
			ps.setInt(4,en.getId_entrenador());
			//EJECUTAMOS
			ps.execute();
			return true;
			
			
			
		} catch (SQLException e) {
System.out.println(e.toString());	
return false;
}finally {
	try {
		con.close();
	} catch (Exception e) {
System.out.println(e.toString());	}
}
		
	}
}
