package service;

import dao.DAO;
import model.User;

public class UserService {
	
	static DAO dao = new DAO();
	
	public static void addUser(User user) {
		dao.addUser(user);
	}

}
