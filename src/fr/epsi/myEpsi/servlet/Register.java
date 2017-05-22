package fr.epsi.myEpsi.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.epsi.myEpsi.beans.User;
import fr.epsi.myEpsi.service.IUserService;
import fr.epsi.myEpsi.service.UserService;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		
		session.setAttribute("mailregister", request.getParameter("mailregister"));
		session.setAttribute("passwordregister", request.getParameter("passwordregister"));
		session.setAttribute("confirmpasswordregister", request.getParameter("confirmpasswordregister"));
		
		boolean usercreate = true;
		
		//TestDeCondition #OnfaitpasduDRY
		if(session.getAttribute("passswordregister").toString().equals(session.getAttribute("confirmpassswordregister").toString()))
		{
			IUserService userService = new UserService();
			for(User oneuser:userService.getListOfUsers()){
				if (oneuser.getId().equals(session.getAttribute("mailregister").toString()))
				{
					usercreate = false;
				}
			}
		}
		
		
		//CreerUser => User.java
		if (usercreate)
		{
			User user = new User();
			user.setId(session.getAttribute("mailregister").toString());
			user.setPassword(session.getAttribute("mailregister").toString());
			user.setAdministrator(false);			

			//AddUser => UserService.java
			IUserService newUserService = new UserService();
			newUserService.addUser(user);
			
			
			
		}

		
		
		
		//Appelservice

		//Redirection
		response.sendRedirect("login.jsp");
//		response.sendRedirect("accueil.jsp");

		
		//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
