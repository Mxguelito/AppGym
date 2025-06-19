package BLL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import DLL.Cliente2;
import DLL.Conexion2;

public class ProductoDAO {
	Connection con;
	Conexion2 cn=new Conexion2();
	PreparedStatement ps;
	ResultSet rs;
	public  boolean RegistrarProducto(Producto pro) {
		String sql="INSERT INTO producto (nombre,codigo,precio,stock) VALUES (?,?,?,?)";
		try {
			con=cn.getConnection();
			ps=con.prepareStatement(sql);
			ps.setString(1,pro.getNombre());
			ps.setString(2,pro.getCodigo());
			ps.setDouble(3,pro.getPrecio());
			
			ps.setInt(4,pro.getStock());
			ps.execute();
			return true;
			
		} catch (SQLException e) {
System.out.println(e.toString());
JOptionPane.showMessageDialog(null,"El producto no lee");
return false;
}finally {
	try {
		con.close();
	} catch (Exception e) {
		System.out.println(e.toString());
		
	}
}
		
	}
	public List ListarProducto() {
		//CREO LISTA PARA ALMACENAR DATOS
		List<Producto> listaProducto=new ArrayList();
		
		 String sql="SELECT * FROM producto";
		 try {
			 //CONEXION---
			 con=cn.getConnection();
			 ps=con.prepareStatement(sql);
			 rs=ps.executeQuery();
			 
			 while (rs.next()) {
				 //CREO UN ENTRENADOR--
				 Producto pro=new Producto();
			   //LEO LOS CAMPOS DE LA BASE DE DATOS---	 
				 pro.setId_producto(rs.getInt("id_producto"));
				 pro.setNombre(rs.getString("nombre"));
				 pro.setCodigo(rs.getString("codigo"));
				 pro.setPrecio(rs.getDouble("precio"));
				 pro.setStock(rs.getInt("stock"));
				 //AÑADO LOS DATOS DE LA BASE DE DATOS A LA LISTA DE ENTRENADORES---
				 listaProducto.add(pro);
				
			}
			 
			
		} catch (SQLException e) {
			System.out.println(e.toString());
			JOptionPane.showMessageDialog(null, "No lee la base de Datos...");
		}
		 return listaProducto;
	}
	
	public boolean EliminarProducto(int id) {
		String sql= "DELETE FROM producto WHERE id_producto =? ";
		try {
			con=cn.getConnection();
			ps=con.prepareStatement(sql);
			ps.setInt(1,id);
			ps.execute();
		
			return true;
			
		} catch (SQLException e) {	
			System.out.println(e.toString());
			JOptionPane.showMessageDialog(null, "No entra a la base de datos Producto");
			return false;
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				
System.out.println(e.toString());	
JOptionPane.showMessageDialog(null,"Entra al segundo TRY CATCH...");
}
		}
		
	}
	 public boolean ModificarProducto(Producto pro) {
	    	String sql="UPDATE producto SET nombre=?,codigo=?,precio=?,stock=? WHERE id_producto=?";
	    	try {
				ps=con.prepareStatement(sql);
				ps.setString(1,pro.getNombre() );
				ps.setString(2,pro.getCodigo() );
				ps.setDouble(3,pro.getPrecio());
				ps.setInt(4,pro.getStock() );
				ps.setInt(5, pro.getId_producto());
				
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
	 public Producto BuscarProducto(String codigo) {
		 Producto producto=new Producto();
		 String sql="SELECT * FROM producto WHERE codigo = ?";
		 try {
			con=cn.getConnection();
			ps=con.prepareStatement(sql);
			ps.setString(1, codigo);
			rs=ps.executeQuery();
			if (rs.next()) {
				producto.setNombre(rs.getString("nombre"));
				
				producto.setStock(rs.getInt("stock"));
				producto.setPrecio(rs.getInt("precio"));
				
			}
			
		} catch (SQLException e) {
		System.out.println(e.toString());
		JOptionPane.showMessageDialog(null,"No lee la base de datos Producto");
		}
		 return producto;
	 }
}
