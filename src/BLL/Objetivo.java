package BLL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import DLL.Conexion2;

public class Objetivo {
	//-------CONEXION--------
	Conexion2 cn = new Conexion2();
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	//-----------------------
	private int id;
	private String descripcion;
	
	public Objetivo() {
		super();
	}

	public Objetivo(int id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return descripcion ;
	}
	
	public String obtenerNombreObjetivo(int idObjetivo) {
		String descripcion=null;
		String sql="SELECT descripcion FROM objetivo WHERE idObjetivo = ?";
		try {
			con=cn.getConnection();
			ps=con.prepareStatement(sql);
			ps.setInt(1, idObjetivo);
			rs=ps.executeQuery();
			
			if (rs.next()) {
				descripcion=rs.getString("descripcion");
				
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al obtener descripcion del objetivo...");
			System.out.println(e.toString());
		}
		return descripcion;
		
	}
	
	

}
