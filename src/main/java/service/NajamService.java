package service;

import dao.DAO;

public class NajamService {
	
	static DAO dao = new DAO();
	
	public static void incrementMasina(int counter ,int masinaId) {
		dao.incrementMasina(counter ,masinaId);
	}
	public static void deleteNajam(int radnikId, int masinaId) {
		dao.deleteNajam(radnikId, masinaId);
	}
	public static void addNajam(int radnikId, int masinaId) {
		
		dao.addNajam(radnikId, masinaId);
		
	}
}
