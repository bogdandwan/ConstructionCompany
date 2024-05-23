package service;

import java.util.List;

import dao.DAO;
import model.Masina;

public class MasinaService {
	
	static DAO dao = new DAO();
	
	public static List<Masina> getMasine(){
		return dao.getMasine();
	}

}
