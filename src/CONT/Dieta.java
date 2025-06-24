package CONT;


public class Dieta {
	private String desayuno;
	private String almuerzo;
	private String merienda;
	private String cena;
	private int idObjetivo;
	public Dieta() {
		super();
	}
	public Dieta(String desayuno, String almuerzo, String merienda, String cena, int idObjetivo) {
		super();
		this.desayuno = desayuno;
		this.almuerzo = almuerzo;
		this.merienda = merienda;
		this.cena = cena;
		this.idObjetivo = idObjetivo;
	}
	public String getDesayuno() {
		return desayuno;
	}
	public void setDesayuno(String desayuno) {
		this.desayuno = desayuno;
	}
	public String getAlmuerzo() {
		return almuerzo;
	}
	public void setAlmuerzo(String almuerzo) {
		this.almuerzo = almuerzo;
	}
	public String getMerienda() {
		return merienda;
	}
	public void setMerienda(String merienda) {
		this.merienda = merienda;
	}
	public String getCena() {
		return cena;
	}
	public void setCena(String cena) {
		this.cena = cena;
	}
	public int getIdObjetivo() {
		return idObjetivo;
	}
	public void setIdObjetivo(int idObjetivo) {
		this.idObjetivo = idObjetivo;
	}
	
	

}
