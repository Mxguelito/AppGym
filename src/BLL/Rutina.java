package BLL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import DLL.Conexion2;

public class Rutina {
	Connection con;
	Conexion2 cn=new Conexion2();
	
	PreparedStatement ps;
	ResultSet rs;
	
	private int id_rutina;
	private String codigo;
	private String ejercicio;
	private String series;
	private int veces_semana;
	private String entrenador;
	private int idObjetivo;
	private String objetivoDescripcion;
	
	
	
	public Rutina() {
		super();
	}
	public Rutina(int id_rutina, String codigo, String ejercicio, String series, int veces_semana,String entrenador,int idObjetivo) {
		super();
		this.id_rutina = id_rutina;
		this.codigo = codigo;
		this.ejercicio = ejercicio;
		this.series = series;
		this.veces_semana = veces_semana;
		this.entrenador=entrenador;
	}
	public int getIdObjetivo() {
		return idObjetivo;
	}
	public void setIdObjetivo(int idObjetivo) {
		this.idObjetivo = idObjetivo;
	}
	public int getId_rutina() {
		return id_rutina;
	}
	public void setId_rutina(int id_rutina) {
		this.id_rutina = id_rutina;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getEjercicio() {
		return ejercicio;
	}
	public void setEjercicio(String ejercicio) {
		this.ejercicio = ejercicio;
	}
	public String getSeries() {
		return series;
	}
	public void setSeries(String series) {
		this.series = series;
	}
	public int getVeces_semana() {
		return veces_semana;
	}
	public void setVeces_semana(int veces_semana) {
		this.veces_semana = veces_semana;
	}
	public String getEntrenador() {
		return entrenador;
	}
	public void setEntrenador(String entrenador) {
		this.entrenador = entrenador;
	}
	public String getObjetivoDescripcion() {
		return objetivoDescripcion;
	}
	public void setObjetivoDescripcion(String objetivoDescripcion) {
		this.objetivoDescripcion = objetivoDescripcion;
	}
	   public int obtenerRutinaPorObjetivo(int idObjetivo) {
	    	int id_rutina=-1;
	    	try {
	    		con=cn.getConnection();
	    		String sql="SELECT id_rutina FROM rutina WHERE codigo = ? LIMIT 1";
	    		ps=con.prepareStatement(sql);
	    		
	    		ps.setInt(1, idObjetivo);
	    		rs=ps.executeQuery();
	    		if (rs.next()) {
	    			id_rutina =rs.getInt("id_rutina");
					
				}
	    		
			} catch (SQLException e) {
	System.out.println(e.toString());	
	JOptionPane.showMessageDialog(null, "Error al obtener rutina...");
	}
	    	return id_rutina;
	    }
	

}
