package BLL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import DLL.Conexion;
import DLL.Conexion2;

public class RutinaDAO {

	Connection con;
	Conexion2 cn=new Conexion2();
	
	PreparedStatement ps;
	ResultSet rs;
	
	public boolean RegistrarRutina(Rutina ru) {

		
		String sql="INSERT INTO rutina (codigo,ejercicio,series,veces_semana,entrenador) VALUES (?,?,?,?,?) ";
		try {
			con=cn.getConnection();
			ps=con.prepareStatement(sql);
			ps.setString(1,ru.getCodigo());
			ps.setString(2,ru.getEjercicio());
			ps.setString(3,ru.getSeries());
			ps.setInt(4,ru.getVeces_semana());
			ps.setString(5,ru.getEntrenador());
			
			ps.execute();
			
			return true;
			
			
			
			
		} catch (SQLException e) {
System.out.println(e.toString());	
JOptionPane.showMessageDialog(null,"Registrar no Lee...");
return false;}
		
	}
	public void ConsultarEntrenador(JComboBox entrenador ) {
		String sql="SELECT  DISTINCT nombre FROM entrenador ";
		try {
			con=cn.getConnection();
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			
			
			//ACA LEE LA BASE DE DATOS---
			while(rs.next()) {
			
				
				entrenador.addItem(rs.getString("nombre"));
				
				
			}
			
		} catch (SQLException e) {
System.out.println(e.toString());	
JOptionPane.showMessageDialog(null,"No lee el nombre del entrenador en la base de datos...");}
		
	}
	public List ListarRutina() {
		//CREO LISTA PARA ALMACENAR DATOS
		List<Rutina> listaRutina=new ArrayList();
		
		 String sql="SELECT * FROM rutina";
		 try {
			 //CONEXION---
			 con=cn.getConnection();
			 ps=con.prepareStatement(sql);
			 rs=ps.executeQuery();
			 
			 while (rs.next()) {
				 //CREO UN ENTRENADOR--
				Rutina ru=new Rutina();
			   //LEO LOS CAMPOS DE LA BASE DE DATOS---	 
				 ru.setId_rutina(rs.getInt("id_rutina"));
				 ru.setCodigo(rs.getString("codigo"));
				 ru.setEjercicio(rs.getString("ejercicio"));
				 ru.setSeries(rs.getString("series"));
				 ru.setVeces_semana(rs.getInt("veces_semana"));
				 ru.setEntrenador(rs.getString("entrenador"));
				 //AÑADO LOS DATOS DE LA BASE DE DATOS A LA LISTA DE ENTRENADORES---
				 listaRutina.add(ru);
				
			}
			 
			
		} catch (SQLException e) {
			System.out.println(e.toString());
			JOptionPane.showMessageDialog(null, "No lee la base de Datos rutina...");
		}
		 return listaRutina ;
	}
	public boolean EliminarRutina(int id) {
		String sql= "DELETE FROM rutina WHERE id_rutina =? ";
		try {
			con=cn.getConnection();
			ps=con.prepareStatement(sql);
			ps.setInt(1,id);
			ps.execute();
			return true;
		} catch (SQLException e) {	
			System.out.println(e.toString());
			JOptionPane.showMessageDialog(null, "El eliminar no funciona");
			return false;
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				
System.out.println(e.toString());			
}
		}
		
	}
	public boolean ModificarRutina(Rutina ru) {
		String sql="UPDATE rutina SET codigo=?, ejercicio=?,series=?,veces_semana=?,entrenador=? WHERE id_rutina=?";
		try {
			con=cn.getConnection();
			ps=con.prepareStatement(sql);
			ps.setString(1, ru.getCodigo() );
			ps.setString(2, ru.getEjercicio() );
			ps.setString(3, ru.getSeries() );
			//---ACA VA EL WHERE ID---
			ps.setInt(4,ru.getVeces_semana());
			ps.setString(5,ru.getEntrenador());
			ps.setInt(6, ru.getId_rutina());
			//EJECUTAMOS
			ps.execute();
			return true;
			
			
			
		} catch (SQLException e) {
System.out.println(e.toString());
JOptionPane.showMessageDialog(null, "El update no entra...");
return false;
}finally {
	try {
		con.close();
	} catch (Exception e) {
System.out.println(e.toString());	}
}
		
	}
	//BUSQUED POR CODIGO,ID,NOMBRE --APLICA PARA PRODUCTOS,PLANES,CLIENTES-------
	public Rutina BuscarRutina(String codigo) {
		Rutina rutina =new Rutina();
		String sql="SELECT codigo,ejercicio,series,veces_semana,entrenador FROM rutina WHERE codigo = ?";
		try {
			con=cn.getConnection();
			ps=con.prepareStatement(sql);
			ps.setString(1, codigo);
			rs=ps.executeQuery();
			if (rs.next()) {
				rutina.setCodigo(rs.getString("codigo"));
				rutina.setEjercicio(rs.getString("ejercicio"));
				rutina.setSeries(rs.getString("series"));
				//PUEDO PONER STOCK SI LO NECESITO-----
				rutina.setVeces_semana(rs.getInt("veces_semana"));
				rutina.setEntrenador(rs.getString("entrenador"));
				
				
				
				
			}
} catch (SQLException e) {
System.out.println(e.toString());	
JOptionPane.showMessageDialog(null,"El buscar rutina no entra...");}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
System.out.println(e.toString());			}
		}
		return rutina;
		
		
		
	}
}

