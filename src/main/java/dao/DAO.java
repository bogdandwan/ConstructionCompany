package dao;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import dto.WorkersByTools;
import dto.WorkersTools;
import model.Masina;
import model.TipMasine;
import model.User;





public class DAO {
	
	
      private DataSource ds;
      
      private final String INSERT_USER = "INSERT INTO `user`(`id`, `ime`, `password`, `admin`) VALUES (NULL, ?, ?, ?)";
      private final String SELECT_USER_BY_NAME = "SELECT * FROM `user` WHERE ime = ?";
      private final String SELECT_USER_BY_NAME_AND_PASSWORD = "SELECT * FROM `user` WHERE ime=? AND password=?";
      private final String SELECT_ALL_USERS_AND_TOOLS = "SELECT user.ime AS worker, masina.naziv AS tool FROM najam JOIN user ON najam.radnik_id = user.id JOIN masina ON najam.masina_id = masina.id";
      private final String SELECT_ALL_TOOLS_BY_USER_ID = "SELECT masina.* FROM najam JOIN masina ON najam.masina_id = masina.id WHERE najam.radnik_id = ?";
      private final String DELETE_NAJAM_BY_RADNIK_AND_MASINA = "DELETE FROM `najam` WHERE radnik_id=? AND masina_id=? LIMIT 1";
      private final String INCREMENT_MASINA = "UPDATE masina SET broj_slobodnih = broj_slobodnih + ? WHERE id=?";
      private final String SELECT_MASINE = "SELECT * FROM masina WHERE broj_slobodnih > 0";
      private final String INSERT_NAJAM = "INSERT INTO najam (`radnik_id`, `masina_id`) VALUES (?,?)";
      private final String SELECT_ALL_USERS_BY_MACHINETYPE = "SELECT user.ime AS worker, masina.naziv AS tool FROM najam INNER JOIN user ON najam.radnik_id = user.id INNER JOIN masina ON najam.masina_id = masina.id WHERE masina.tip = ?";
      
	public DAO(){
		
	try {
		InitialContext cxt = new InitialContext();
		
		ds = (DataSource) cxt.lookup( "java:/comp/env/jdbc/mysql" ); 
		if ( ds == null ) { 
		} 		
		} catch (NamingException e) {
		}
	}
	
	public void addUser(User user) {
		Connection con = null;
		PreparedStatement pstm = null;
		
		
			try {
				con = ds.getConnection();
				pstm = con.prepareStatement(INSERT_USER);
				
			
				pstm.setString(1, user.getIme());
				pstm.setString(2, user.getPassword());
				pstm.setBoolean(3, user.isAdmin());
				
				pstm.execute();
				
			
				con.close();
			
			}catch (SQLException e) {
			e.printStackTrace();
		
		}
	}
	public void incrementMasina(int counter ,int masinaId) {
		Connection con = null;
		PreparedStatement pstm = null;
		
		
			try {
				con = ds.getConnection();
				pstm = con.prepareStatement(INCREMENT_MASINA);
				
				pstm.setInt(1, counter);
				pstm.setInt(2, masinaId);
				
				pstm.execute();
				
			
				con.close();
			
			}catch (SQLException e) {
			e.printStackTrace();
		
		}
	}
	
	public void deleteNajam(int userId, int masinaId) {
		Connection con = null;
		PreparedStatement pstm = null;
		
		
			try {
				con = ds.getConnection();
				pstm = con.prepareStatement(DELETE_NAJAM_BY_RADNIK_AND_MASINA);
				
			
				pstm.setInt(1, userId);
				pstm.setInt(2, masinaId);				
				pstm.execute();
				
			
				con.close();
			
			}catch (SQLException e) {
			e.printStackTrace();
		
		}
	}
	
	public User getUserByName(String ime) {
		
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		User user = null;
		
		try {
			con = ds.getConnection();
			pstm = con.prepareStatement(SELECT_USER_BY_NAME);
			pstm.setString(1, ime);
			
			pstm.execute();
			
			rs = pstm.getResultSet();
			
			while(rs.next()){
				user= new User();
				user.setId(rs.getInt("id"));
				user.setIme(rs.getString("ime"));
				user.setPassword(rs.getString("password"));
				user.setAdmin(rs.getBoolean("admin"));
			}
			
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;
		
		
	}
	
	public boolean checkIfUserExist(String ime, String password) {
		
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		
		try {
			con = ds.getConnection();
			pstm = con.prepareStatement(SELECT_USER_BY_NAME_AND_PASSWORD);
			pstm.setString(1, ime);
			pstm.setString(2, password);
			pstm.execute();
			
			rs = pstm.getResultSet();
			
			
			while(rs.next()){
				return true;
			}
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
		return false;
	}
	
	public List<WorkersTools> getAllWorkersAndTools(){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		List<WorkersTools> workersTools = new ArrayList<WorkersTools>();
		
		try {
			con = ds.getConnection();
			pstm = con.prepareStatement(SELECT_ALL_USERS_AND_TOOLS);
			pstm.execute();
			
			rs = pstm.getResultSet();
			
			while(rs.next()) {
				String worker = rs.getString("worker");
				String tool = rs.getString("tool");
				WorkersTools workerTool = new WorkersTools(worker, tool);
				workersTools.add(workerTool);
			}
			
			
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return workersTools;
	}

	
		public List<Masina> getUserTools(int id) {
		
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<Masina> tools = new ArrayList<Masina>();
		
		try {
			con = ds.getConnection();
			pstm = con.prepareStatement(SELECT_ALL_TOOLS_BY_USER_ID);
			pstm.setInt(1, id);
			pstm.execute();
			
			
			rs = pstm.getResultSet();
			
			
			while(rs.next()) {
				Masina masina = new Masina();
				masina.setId(rs.getInt("id"));
				masina.setNaziv(rs.getString("naziv"));
				masina.setBrojSlobodnih(rs.getInt("broj_slobodnih"));
				masina.setTip(TipMasine.valueOf(rs.getString("tip")));
				tools.add(masina);
				
			}
			
			
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return tools;
	}

		public List<Masina> getMasine() {
			Connection con = null;
			PreparedStatement pstm = null;
			ResultSet rs = null;
			List<Masina> tools = new ArrayList<Masina>();
			
			try {
				con = ds.getConnection();
				pstm = con.prepareStatement(SELECT_MASINE);
				pstm.execute();
				
				
				rs = pstm.getResultSet();
				
				
				while(rs.next()) {
					Masina masina = new Masina();
					masina.setId(rs.getInt("id"));
					masina.setNaziv(rs.getString("naziv"));
					masina.setBrojSlobodnih(rs.getInt("broj_slobodnih"));
					masina.setTip(TipMasine.valueOf(rs.getString("tip")));
					tools.add(masina);
					
				}
				
				
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return tools;
		}

		public void addNajam(int radnikId, int masinaId) {
			Connection con = null;
			PreparedStatement pstm = null;
			
			
				try {
					con = ds.getConnection();
					pstm = con.prepareStatement(INSERT_NAJAM);
					
				
					pstm.setInt(1, radnikId);
					pstm.setInt(2, masinaId);
					
					pstm.execute();
					
				
					con.close();
				
				}catch (SQLException e) {
				e.printStackTrace();
			
			}
			
		}
		
		public List<WorkersByTools> getAllWorkersByTools(){
			Connection con = null;
			PreparedStatement pstm = null;
			ResultSet rs = null;
			
			List<WorkersByTools> workersByTools = new ArrayList<WorkersByTools>();
			
			try {
				con = ds.getConnection();
				pstm = con.prepareStatement(SELECT_ALL_USERS_BY_MACHINETYPE);
				pstm.execute();
				
				rs = pstm.getResultSet();
				
				while(rs.next()) {
					String worker = rs.getString("worker");
					String tool = rs.getString("tool");
					WorkersByTools workerByTool = new WorkersByTools(worker, tool);
					workersByTools.add(workerByTool);
				}
				
				
				con.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return workersByTools;
		}
	
	
}
