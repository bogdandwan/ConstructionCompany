package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;
import service.LoginService;

import java.io.IOException;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		
		if(action.equals("logout")) {
			request.getSession().invalidate();
			request.getRequestDispatcher("index.jsp").forward(request, response);
			
		}
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String ime = request.getParameter("ime");
		String password = request.getParameter("password");
		String action = request.getParameter("action");
		
		if (action != null) {
			if (action.equals("login")) {
				String errMsg = "";

				boolean fieldsEmpty = true;

				if (ime == null || ime.isEmpty() || password == null || password.isEmpty()) {
					errMsg += "All fields must be entered";
				}

				if (errMsg.length() == 0) {
					fieldsEmpty = false;
				}

				if (LoginService.checkUser(ime, password)) {
					try {
						User user = LoginService.getUser(ime);

						if (user.isAdmin()) {
							request.getSession().setAttribute("user", user);
							request.getRequestDispatcher("pages/adminHome.jsp").forward(request, response);
						} else {
							request.getSession().setAttribute("user", user);
							request.getRequestDispatcher("pages/workerHome.jsp").forward(request, response);						}

					} catch (Exception e) {

						e.printStackTrace();
					}
				} else {
					response.sendRedirect("index.jsp");
					System.out.println("IN-VALID LOGIN");
					
				}

				
			}else {
				Object user = request.getSession().getAttribute("user");
				if(user==null) {
					request.getRequestDispatcher("index.jsp").forward(request, response);
					return;
				}
			}
		}

	}

}
