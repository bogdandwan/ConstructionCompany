package model;

public class Masina {
	
	private int id;
	private String naziv;
	private int brojSlobodnih;
	private TipMasine tip;
	
	
	public Masina(int id, String naziv, int brojSlobodnih, TipMasine tip) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.brojSlobodnih = brojSlobodnih;
		this.tip = tip;
	}


	public Masina() {
		super();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNaziv() {
		return naziv;
	}


	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}


	public int getBrojSlobodnih() {
		return brojSlobodnih;
	}


	public void setBrojSlobodnih(int brojSlobodnih) {
		this.brojSlobodnih = brojSlobodnih;
	}


	public TipMasine getTip() {
		return tip;
	}


	public void setTip(TipMasine tip) {
		this.tip = tip;
	}
	
	
	
}
