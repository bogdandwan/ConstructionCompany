package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Masina;
import model.User;
import service.MasinaService;
import service.NajamService;
import service.RadnikService;

import java.io.IOException;
import java.util.List;

@WebServlet("/radnik")
public class RadnikController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public RadnikController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if(user == null) {
			request.getRequestDispatcher("index.jsp").forward(request, response);
			return;
		}
		
		
		if(action.equals("najam")) {
			List<Masina> masine = MasinaService.getMasine();
			request.setAttribute("masine", masine);
			request.getRequestDispatcher("pages/selectTool.jsp").forward(request, response);
		}else if(action.equals("pregled")) {
			
			List<Masina> tools = RadnikService.getUserTools(user.getId());
			request.setAttribute("tools", tools);
			request.getRequestDispatcher("pages/pregledAlata.jsp").forward(request, response);
			
		}else if(action.equals("odjavi")) {
			int masinaId = Integer.parseInt(request.getParameter("masinaId"));
			NajamService.deleteNajam(user.getId(), masinaId);
			NajamService.incrementMasina(1 ,masinaId);
			List<Masina> tools = RadnikService.getUserTools(user.getId());
			request.setAttribute("tools", tools);
			
			request.getRequestDispatcher("pages/pregledAlata.jsp").forward(request, response);
		}else if(action.equals("nazad")) {
			response.sendRedirect("pages/workerHome.jsp");
		}

		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String masinaId = request.getParameter("masinaId");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		NajamService.addNajam(user.getId(), Integer.parseInt(masinaId));
		NajamService.incrementMasina(-1 ,Integer.parseInt(masinaId));
		
		
		List<Masina> tools = RadnikService.getUserTools(user.getId());
		request.setAttribute("tools", tools);
		
		request.getRequestDispatcher("pages/pregledAlata.jsp").forward(request, response);
	}

}
