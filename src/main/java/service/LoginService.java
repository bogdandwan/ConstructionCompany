package service;

import dao.DAO;
import model.User;

public class LoginService {
	
	static DAO dao = new DAO();
	
		
	
	public static boolean checkUser(String ime, String password) {
		
		return dao.checkIfUserExist(ime, password);
		
	}
	
	public static User getUser(String ime) throws Exception {
		
		return dao.getUserByName(ime);
	
	}
	
}
