package fr.epsi.myEpsi.servlet;

import java.io.IOException;
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
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession(true);
		session.setAttribute("mail", request.getParameter("mail"));
		session.setAttribute("password", request.getParameter("password"));
		
		//TestDeCondition #OnfaitpasduDRY
		
		IUserService userService = new UserService();
		User thisuser = userService.getUserById(session.getAttribute("mail").toString());
		
		//Si l'utilisateur indique le bon password avec le mail, on redirige vers la bonne page
		System.out.println(thisuser);
		if(thisuser.getPassword().equals(session.getAttribute("password")))
		{
			response.sendRedirect("accueil.jsp");
		} 
		else 
		{
			response.sendRedirect("index.jsp");
		}
				
		//Appel service
		
		//Redirection
//		response.sendRedirect("accueil.jsp");
		
//		request.getRequestDispatcher("login.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//request.getRequestDispatcher("login.jsp").forward(request, response);

//		doGet(request, response);
	}

}
