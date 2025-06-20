package DLL;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;





public class LoginDAO{
	
	//------CONEXION---------
		Connection con;
		PreparedStatement ps;
		ResultSet rs;
		Conexion2 cn =new Conexion2();
	//---------------------------

	
	public Login2 log (String email,String pass) {
		
		//-------CREA LA INFORMACION---------
		Login2 l=new Login2();
		
		
		//CONSULTA----------BASE DE DATOS-----
		String sql="SELECT * FROM usuario WHERE email = ? AND  pass = ?";
		try {
			con = cn.getConnection();
			
			ps=con.prepareStatement(sql);
			
			ps.setString(1, email);
			ps.setString(2, pass);
			
			rs=ps.executeQuery();
			//-----ACA LEE LOS DATOS-----
			if (rs.next()) {
				
				l.setId(rs.getInt("id_usuario"));
				l.setNombre(rs.getString("nombre"));
				l.setEmail(rs.getString("email"));
				l.setPass(rs.getString("pass"));
				l.setTipo(rs.getNString("tipo"));
				
				;
				
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
		return l;
	}
	
	
	public boolean Registrar(Login2 registrar) {
		String sql="INSERT INTO usuario (nombre,email,pass,tipo) VALUES (?,?,?,?)";
		try {
			con=cn.getConnection();
			ps=con.prepareStatement(sql);
			ps.setString(1, registrar.getNombre());
			ps.setString(2,registrar.getEmail());
			ps.setString(3,registrar.getPass());
			ps.setString(4, registrar.getTipo());
			ps.execute();
			return true;
		} catch (SQLException e) {
System.out.println(e.toString());	
return false;
}
		
	}
}



