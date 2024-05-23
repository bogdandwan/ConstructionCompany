package dto;

public class WorkersByTools {
	
	private String radnik;
	private String inzajmljenaMasina;
	
	
	public WorkersByTools() {
		super();
	}


	public WorkersByTools(String radnik, String inzajmljenaMasina) {
		super();
		this.radnik = radnik;
		this.inzajmljenaMasina = inzajmljenaMasina;
	}


	public String getRadnik() {
		return radnik;
	}


	public void setRadnik(String radnik) {
		this.radnik = radnik;
	}


	public String getInzajmljenaMasina() {
		return inzajmljenaMasina;
	}


	public void setInzajmljenaMasina(String inzajmljenaMasina) {
		this.inzajmljenaMasina = inzajmljenaMasina;
	}


	@Override
	public String toString() {
		return "WorkersByTools [radnik=" + radnik + ", inzajmljenaMasina =" + inzajmljenaMasina + "]";
	}
}
