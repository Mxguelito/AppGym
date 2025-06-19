package DLL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Conexion2 {
	
	Connection con ;
	public Connection getConnection() {
		try {
			String myBD ="jdbc:mysql://localhost:3306/appgym";
			con=DriverManager.getConnection(myBD,"root","");
			return con;
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return null;
	}

}
