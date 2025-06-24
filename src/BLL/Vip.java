package BLL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import DLL.Conexion2;

public class Vip {
	//-------CONEXION--------
	Conexion2 cn = new Conexion2();
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	//-----------------------
	private int id_vip;
	private int precio;
	private int idObjetivo;
	private int id_rutina;
	private int id_dieta;
	private int id_cliente;
	public Vip() {
		super();
	}
	public Vip(int id_vip, int precio, int idObjetivo, int id_rutina, int id_dieta, int id_cliente) {
		super();
		this.id_vip = id_vip;
		this.precio = precio;
		this.idObjetivo = idObjetivo;
		this.id_rutina = id_rutina;
		this.id_dieta = id_dieta;
		this.id_cliente = id_cliente;
	}
	public int getId_vip() {
		return id_vip;
	}
	public void setId_vip(int id_vip) {
		this.id_vip = id_vip;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
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
	public int getId_dieta() {
		return id_dieta;
	}
	public void setId_dieta(int id_dieta) {
		this.id_dieta = id_dieta;
	}
	public int getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}
	public boolean obtenerPlanVipPorIdCliente(int id_cliente) {
		
		String sql="SELECT * FROM vip WHERE id_cliente = ?";
		try {
			con=cn.getConnection();
			ps=con.prepareStatement(sql);
			ps.setInt(1, id_cliente);
			rs=ps.executeQuery();
			if (rs.next()) {
				this.id_vip=rs.getInt("id_vip");
				this.precio=rs.getInt("precio");
				this.idObjetivo=rs.getInt("idObjetivo");
				this.id_rutina=rs.getInt("id_rutina");
				this.id_dieta=rs.getInt("id_dieta");
				this.id_cliente=rs.getInt("id_cliente");
				return true;
				
				
			}
		} catch (Exception e) {
	System.out.println(e.toString());
	JOptionPane.showMessageDialog(null, "Error al obtener Plan basico por id...");}
		 return false;
		
	}
	  public boolean tienePlanAsignado(int id_Cliente) {
	    	boolean tienePlan=false;
	    	try {
	    		String sqlBasico="SELECT * FROM basico WHERE id_cliente = ?";
	    		con=cn.getConnection();
				ps=con.prepareStatement(sqlBasico);
				ps.setInt(1, id_Cliente);
				rs=ps.executeQuery();
				if (rs.next()) {
					tienePlan=true;
					
				}if(!tienePlan) {
					String sqlVip="SELECT * FROM vip WHERE id_cliente = ?";
					
					ps=con.prepareStatement(sqlVip);
					ps.setInt(1, id_Cliente);
					rs=ps.executeQuery();
					if (rs.next()) {
						tienePlan=true;
						
					 }
				}
				rs.close();
				ps.close();
				con.close();
				
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Error al verificar Plan...");
	System.out.println(e.toString());		
	}
	    	return tienePlan;
	    	
	    	
	    }
}
