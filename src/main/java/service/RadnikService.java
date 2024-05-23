package service;

import java.util.List;

import dao.DAO;
import model.Masina;

public class RadnikService {
	
	static DAO dao = new DAO();
	
	public static List<Masina> getUserTools(int id) {
		
		return dao.getUserTools(id);
	}

}
