package fr.epsi.myEpsi.servlet;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.epsi.myEpsi.beans.Message;
import fr.epsi.myEpsi.beans.User;
import fr.epsi.myEpsi.service.IMessageService;
import fr.epsi.myEpsi.service.IUserService;
import fr.epsi.myEpsi.service.MessageService;
import fr.epsi.myEpsi.service.UserService;

/**
 * Servlet implementation class NewMessage
 */
@WebServlet("/NewMessage")
public class NewMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewMessage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession(true);
		session.setAttribute("title", request.getParameter("title"));
		session.setAttribute("content", request.getParameter("content"));
		session.setAttribute("status", request.getParameter("radios"));
		
		boolean messagecreate = true;
		//TestDeCondition #OnfaitpasduDRYc'estfaux
		
		
		//CreateMessage => Message.java
		if(messagecreate)
		{
			String status = session.getAttribute("status").toString();
			int statusf;
			if(status.equals("Public"))
			{
				statusf = 0;
			} else
			{
				statusf = 1;
			}
			
			Message message = new Message();
			message.setTitle(session.getAttribute("title").toString());
			message.setContent(session.getAttribute("content").toString());
			message.setAuthor(session.getAttribute("mail").toString());
			message.setCreationDate(new Timestamp(System.currentTimeMillis()));
			message.setUpdateDate(new Timestamp(System.currentTimeMillis()));
			message.setStatus(statusf);
			
			User currentuser = new User();
			currentuser.setId(session.getAttribute("mail").toString());
			
			IMessageService allmessage = new MessageService();
			Message lastmessage = new Message();
			lastmessage = allmessage.getListOfMessagesAll(currentuser).get(allmessage.getListOfMessagesAll(currentuser).size() -1);
			message.setId(lastmessage.getId()+1);
			
			IMessageService newMessageService = new MessageService();
			newMessageService.addMessage(message);
			
		}

		//Redirection
		response.sendRedirect("accueil.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
