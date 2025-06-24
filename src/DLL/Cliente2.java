package DLL;

public class Cliente2 {
	
private int id_cliente;
private String nombre;
private int altura;
private int peso;
private int edad;
private String nivel;
private int idObjetivo;
private int id_usuario;
public Cliente2() {
	super();
}
public Cliente2(int id_cliente, String nombre, int altura, int peso, int edad, String nivel,int idObjetivo,int id_usuario) {
	super();
	this.id_cliente = id_cliente;
	this.nombre = nombre;
	this.altura = altura;
	this.peso = peso;
	this.edad = edad;
	this.nivel = nivel;
	this.idObjetivo=idObjetivo;
	this.id_usuario=id_usuario;
}
public int getId_usuario() {
	return id_usuario;
}
public void setId_usuario(int id_usuario) {
	this.id_usuario = id_usuario;
}
public int getIdObjetivo() {
	return idObjetivo;
}
public void setIdObjetivo(int idObjetivo) {
	this.idObjetivo = idObjetivo;
}
public int getId_cliente() {
	return id_cliente;
}
public void setId_cliente(int id_cliente) {
	this.id_cliente = id_cliente;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public int getAltura() {
	return altura;
}
public void setAltura(int altura) {
	this.altura = altura;
}
public int getPeso() {
	return peso;
}
public void setPeso(int peso) {
	this.peso = peso;
}
public int getEdad() {
	return edad;
}
public void setEdad(int edad) {
	this.edad = edad;
}
public String getNivel() {
	return nivel;
}
public void setNivel(String nivel) {
	this.nivel = nivel;
}


}
