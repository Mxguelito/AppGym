package DLL;

public class Login2 {
private int id;
private String nombre;
private String email;
private String pass;
private String tipo;

//------VACIO------
public Login2() {
	super();
}
//------LLENO--------

public Login2(int id, String nombre, String email, String pass, String tipo) {
	super();
	this.id = id;
	this.nombre = nombre;
	this.email = email;
	this.pass = pass;
	this.tipo = tipo;
	//----------------------
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPass() {
	return pass;
}

public void setPass(String pass) {
	this.pass = pass;
}

public String getTipo() {
	return tipo;
}

public void setTipo(String tipo) {
	this.tipo = tipo;
}



}

