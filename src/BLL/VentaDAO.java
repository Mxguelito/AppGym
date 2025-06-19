package BLL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import DLL.Conexion2;
public class VentaDAO {
	Connection con;
	Conexion2 cn =new Conexion2();
	PreparedStatement ps;
	ResultSet rs;
	int r;
	
	
	    public int idVenta() {
	    	int id=0;
	    	//OBTIENE EL ULTIMO ID DE LA BASE DE DATOS VENTA----------
	    	String sql="SELECT MAX(id_venta) FROM venta";
	    	try {
				con=cn.getConnection();
				ps=con.prepareStatement(sql);
				rs=ps.executeQuery();
				
				if (rs.next()) {
					id=rs.getInt(1);
					
				}
				
			} catch (Exception e) {
				System.out.println(e.toString());
				JOptionPane.showMessageDialog(null, "No lee la base de datos venta...");
			}
	    	return id;
		
	}
	
		public int RegistrarVenta(Venta v) {

	
		
		String sql="INSERT INTO venta (cliente, vendedor, total) VALUES (?,?,?)";
		try {
			con=cn.getConnection();
			ps=con.prepareStatement(sql);
			ps.setString(1, v.getCliente());
			ps.setString(2, v.getVendedor());
			ps.setDouble(3, v.getTotal());
			ps.execute();
			
			JOptionPane.showMessageDialog(null, "Venta Registrada con Exito....");
			
		} catch (SQLException e) {
			System.out.println(e.toString());	
		}
		return r;
	}
	
	
    public int RegistrarDetalle(Detalle Dv) {
    	
    	String sql="INSERT INTO detalle_venta (codigo_producto,cantidad,precio,id_venta) VALUES (?,?,?,?) ";
    	try {
			con=cn.getConnection();
			ps=con.prepareStatement(sql);
			ps.setString(1,Dv.getCodigo_producto() );
			ps.setInt(2,Dv.getCantidad() );
			ps.setDouble(3,Dv.getPrecio() );
			ps.setInt(4,Dv.getId_venta() );
			ps.execute();
			
		} catch (SQLException e) {
			System.out.println(e.toString());
			JOptionPane.showMessageDialog(null, "No lee la base de datos Detalle de Ventas...");
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
System.out.println(e.toString());
}
		}
    	return r;
    	
    } 
    public boolean ActualizarStock(int cantidad,String codigo) {
    	String sql="UPDATE producto SET stock = ? WHERE codigo = ? ";
    	try {
			con=cn.getConnection();
			ps=con.prepareStatement(sql);
			ps.setInt(1, cantidad);
			ps.setString(2, codigo);
			ps.execute();
			return true;
		} catch (SQLException e) {
			System.out.println(e.toString());
			JOptionPane.showMessageDialog(null, "No lee la base de datos producto...");
			return false;
		}
    	
    	
    }
    public List ListarVenta() {
		//CREO LISTA PARA ALMACENAR DATOS
		List<Venta> listaVenta=new ArrayList();
		
		 String sql="SELECT * FROM venta";
		 try {
			 //CONEXION---
			 con=cn.getConnection();
			 ps=con.prepareStatement(sql);
			 rs=ps.executeQuery();
			 
			 while (rs.next()) {
				 //CREO UN ENTRENADOR--
				 Venta venta=new Venta();
			   //LEO LOS CAMPOS DE LA BASE DE DATOS---	 
				 venta.setId_venta(rs.getInt("id_venta"));
				 venta.setCliente(rs.getString("cliente"));
				 venta.setVendedor(rs.getString("vendedor"));
				 venta.setTotal(rs.getDouble("total"));
			
				 //AÑADO LOS DATOS DE LA BASE DE DATOS A LA LISTA DE ENTRENADORES---
				 listaVenta.add(venta);
				
			}
			 
			
		} catch (SQLException e) {
			System.out.println(e.toString());
			JOptionPane.showMessageDialog(null, "No lee la base de Datos...");
		}
		 return listaVenta;
	}
}
