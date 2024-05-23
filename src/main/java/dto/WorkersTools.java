package dto;

public class WorkersTools {
	
	private String imeRadnika;
	private String nazivMasine;
	
	
	public WorkersTools(String imeRadnika, String nazivMasine) {
		super();
		this.imeRadnika = imeRadnika;
		this.nazivMasine = nazivMasine;
	}


	public WorkersTools() {
		super();
	}


	public String getImeRadnika() {
		return imeRadnika;
	}


	public void setImeRadnika(String imeRadnika) {
		this.imeRadnika = imeRadnika;
	}


	public String getNazivMasine() {
		return nazivMasine;
	}


	public void setNazivMasine(String nazivMasine) {
		this.nazivMasine = nazivMasine;
	}
	
	

}
