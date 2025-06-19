package CONT;

public class Plan {
	private int id;
	private int precio;
	private String planBasico;
	private String planVip;
	private String objetivo;
	private int idCliente;
	public Plan(int id,int precio, String planBasico, String objetivo,String planVip, int idCliente) {
		super();
		this.id=id;
		this.precio = precio;
		
		this.planBasico = planBasico;
		this.objetivo = objetivo;
		this.planVip=planVip;
		this.idCliente=idCliente;
	}
	public int getId() {return id;}
	public void setId(int id) {this.id=id;}
	
	public String getPlanBasico() {
		return planBasico;
	}
	public void setPlanBasico(String planBasico) {
		this.planBasico = planBasico;
	}
	public String getPlanVip() {
		return planVip;
	}
	public void setPlanVip(String planVip) {
		this.planVip = planVip;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public String getPlan() {
		return planBasico;
	}
	public void setPlan(String plan) {
		this.planBasico = plan;
	}
	public String getObjetivo() {
		return objetivo;
	}
	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}
	public int getIdCliente() {return idCliente;}
	public void setIdCliente (int idCliente) {this.idCliente=idCliente;}
	
	
	public static void menu() {
		
	}
	@Override
	public String toString() {
		return "Plan [precio=" + precio + ", planBasico=" + planBasico + ", planVip=" + planVip + ", objetivo="
				+ objetivo + "]";
	}
	
	

}
