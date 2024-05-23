package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;
import service.UserService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dao.DAO;
import dto.WorkersByTools;
import dto.WorkersTools;

@WebServlet("/admin")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AdminController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		Object user = request.getSession().getAttribute("user");
		String options = request.getParameter("options");
		
		
		if(user==null) {
			request.getRequestDispatcher("index.jsp").forward(request, response);
			return;
		}
		
		if(action.equals("pregled")) {
			
			DAO dao = new DAO();
			List<WorkersTools> workerTools = dao.getAllWorkersAndTools();
			
			request.setAttribute("workerTools", workerTools);
			request.getRequestDispatcher("pages/pregledRadnika.jsp").forward(request, response);
			
		}else if(action.equals("dodaj")){
			response.sendRedirect("pages/dodajRadnika.jsp");
			
			
		}else if(action.equals("nazad")) {
			response.sendRedirect("pages/adminHome.jsp");
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String ime = request.getParameter("ime");
		String password = request.getParameter("password");
		String userType = request.getParameter("userType");
		String action = request.getParameter("action");
		String msg = "Uspesno dodavanje u bazu";
		
		if(action.equals("dodaj")) {
			User user = new User();
			if(userType.equals("admin")) {
				user.setIme(ime);
				user.setPassword(password);
				user.setAdmin(true);
				
			}else {
				user.setIme(ime);
				user.setPassword(password);
				user.setAdmin(false);
			}
			UserService.addUser(user);
			DAO dao = new DAO();
			List<WorkersTools> workerTools = dao.getAllWorkersAndTools();
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("pages/dodajRadnika.jsp").forward(request, response);
		}
		
	}
}
