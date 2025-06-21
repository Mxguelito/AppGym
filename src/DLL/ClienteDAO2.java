package DLL;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class ClienteDAO2 {
	
	//-------CONEXION--------
	Conexion2 cn = new Conexion2();
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	//-----------------------
	
	public boolean RegistrarCliente(Cliente2 cl) {
		String sql="INSERT INTO cliente (nombre,altura,peso,edad,nivel)VALUES (?,?,?,?,?)";
		try {
			con=cn.getConnection();
			ps=con.prepareStatement(sql);
			
			ps.setString(1,cl.getNombre());
			ps.setInt(2,cl.getAltura());
			ps.setInt(3,cl.getPeso());
			ps.setInt(4,cl.getEdad());
			ps.setString(5,cl.getNivel());
			
			ps.execute();
			
			return true;
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.toString());
			return false;
		}finally {
			try {
				con.close();
				
			} catch (Exception e) {
				System.out.println(e.toString()); 
			}
		}
	} 
    public List ListarCliente() {
    	List<Cliente2>ListaCl=new ArrayList();
    	String sql="SELECT * FROM cliente";
    	try {
			con =cn.getConnection();
			ps=con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Cliente2 cl=new Cliente2();
				
				cl.setId_cliente(rs.getInt("id_cliente"));
				cl.setNombre(rs.getString("nombre"));
				cl.setAltura(rs.getInt("altura"));
				cl.setPeso(rs.getInt("peso"));
				cl.setEdad(rs.getInt("edad"));
				cl.setNivel(rs.getString("nivel"));
				ListaCl.add(cl);
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
    	return ListaCl;
    }
    public boolean EliminarCliente(int id_cliente ) {
    	
    	String sql="DELETE FROM cliente WHERE id_cliente = ?";
    	
      try {
    	  ps=con.prepareStatement(sql);
		  ps.setInt(1,id_cliente);
		  ps.execute();
		  return true;
		  
		  
	} catch (SQLException e) {
System.out.println(e.toString());
 return false;
 
 
	}finally 
      {try {
    	  
	con.close();
	
} catch (Exception e) {
	
	System.out.println(e.toString());
	
	}

}
      
      
    }
    public boolean ModificarCliente(Cliente2 cl) {
    	String sql="UPDATE cliente SET nombre=?,altura=?,peso=?,edad=?,nivel=? WHERE id_cliente=?";
    	try {
			ps=con.prepareStatement(sql);
			ps.setString(1,cl.getNombre() );
			ps.setInt(2,cl.getAltura() );
			ps.setInt(3,cl.getPeso ());
			ps.setInt(4,cl.getEdad() );
			ps.setString(5,cl.getNivel() );
			ps.setInt(6,cl.getId_cliente() );
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
    public Cliente2 BuscarCliente(int id) {
    	Cliente2 cl=new Cliente2();
    	String sql="SELECT * FROM cliente WHERE id_cliente = ? ";
    	try {
    		con =cn.getConnection();
    		ps=con.prepareStatement(sql);
    		ps.setInt(1 , id);
    		rs=ps.executeQuery();
    		if (rs.next()) {
    			cl.setNombre(rs.getString("nombre"));
    			cl.setAltura(rs.getInt("altura"));
    			cl.setPeso(rs.getInt("peso"));
    			cl.setEdad(rs.getInt("edad"));
    			cl.setNivel(rs.getString("nivel"));
    			
				
			}
    		
    		
    		
			
		} catch (SQLException e) {
System.out.println(e.toString());	
JOptionPane.showMessageDialog(null, "No lee la baste de datos cliente...");
}
    	return cl;
    	
    	
    	
    }
    public boolean tienePlanAsignado(int id_Cliente) {
    	boolean tienePlan=false;
    	String sql="SELECT idCliente FROM basico WHERE idCliente = ?";
    	try {
    		con=cn.getConnection();
			ps=con.prepareStatement(sql);
			ps.setInt(1, id_Cliente);
			rs=ps.executeQuery();
			if (rs.next()) {
				tienePlan=true;
				
			}else {
				sql="SELECT idCliente FROM vip WHERE idCliente = ?";
				
				ps=con.prepareStatement(sql);
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
    public void asignarPlanBasico(int id_cliente) {
    	String sql ="INSERT INTO basico (precio,objetivo,rutina,idCliente) VALUES (?,?,?,?)";
    	try {
    		con=cn.getConnection();
			ps=con.prepareStatement(sql);
			ps.setInt(1,5000);
			ps.setString(2,"Tonificacion General");
		} catch (Exception e) {
System.out.println(e.toString());		
}
    	
    	
    }
    public void asignarPlanVip(int id_cliente) {
    	
try {
	con=cn.getConnection();
	//PRIMERO CREAMOS LA DIETA----
	int idDieta=crearDieta(
			"Avena  con banana",
			"Pollo con Arroz",
			"Fruta mas Yogurt",
			"Ensalada y carne Magra",id_cliente);
	
	//AHORA INSERTAMOS EL PLAN VIP-----
	String sql="INSERT INTO vip (precio,objetivo,id_rutina,id_dieta,idCliente) VALUES (?,?,?,?,?)";
	ps=con.prepareStatement(sql);
	ps.setInt(1, 10000);
	ps.
	
			
	
	
} catch (Exception e) {
System.out.println(e.toString());
}    
}
    public int crearDieta(String desayuno,String almuerzo,String merienda,String cena,int id_cliente) {
    	int idDieta=-1;
    	String sql="INSERT INTO dieta (desayuno,almuerzo,merienda,cena,idCliente) VALUES (?,?,?,?,?)";
    	try {
    		con=cn.getConnection();
			ps=con.prepareStatement(sql);
			ps.setString(1, desayuno);
			ps.setString(2, almuerzo);
			ps.setString(3, merienda);
			ps.setString(4, cena);
			ps.setInt(5,id_cliente);
			rs=ps.executeQuery();
			if (rs.next()) {
				
				idDieta=rs.getInt(1);
				
			}
			rs.close();
			ps.close();
			con.close();
			
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al crear Dieta...");
System.out.println(e.toString());
}
    	return idDieta;
    }
}
