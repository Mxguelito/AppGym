package BLL;

public class Rutina {
	private int id_rutina;
	private String codigo;
	private String ejercicio;
	private String series;
	private int veces_semana;
	private String entrenador;
	
	
	public Rutina() {
		super();
	}
	public Rutina(int id_rutina, String codigo, String ejercicio, String series, int veces_semana,String entrenador) {
		super();
		this.id_rutina = id_rutina;
		this.codigo = codigo;
		this.ejercicio = ejercicio;
		this.series = series;
		this.veces_semana = veces_semana;
		this.entrenador=entrenador;
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
	

}
