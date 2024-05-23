package model;

public class User {
	
	private int id;
	private String ime;
	private String password;
	private boolean admin;
	
	
	public User(String ime, String password) {
		super();
		this.ime = ime;
		this.password = password;
	}


	public User() {
		super();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getIme() {
		return ime;
	}


	public void setIme(String ime) {
		this.ime = ime;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public boolean isAdmin() {
		return admin;
	}


	public void setAdmin(boolean admin) {
		this.admin = admin;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", ime=" + ime + ", password=" + password + ", admin=" + admin + "]";
	}
	
	
	
}
