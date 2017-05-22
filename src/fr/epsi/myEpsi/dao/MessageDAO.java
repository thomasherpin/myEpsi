package fr.epsi.myEpsi.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import fr.epsi.myEpsi.beans.Message;
import fr.epsi.myEpsi.beans.Status;
import fr.epsi.myEpsi.beans.User;

public class MessageDAO implements IMessageDao {

	@Override
	public List<Message> getListOfMessages(User user) {
		List<Message> messages = new ArrayList<>();
		
		Connection con = ConnectionTool.getConnection();
		if (con != null)
		{
			try {
				
			Statement stmt = con.createStatement();
			ResultSet result = stmt.executeQuery("SELECT * FROM MESSAGES WHERE USER_ID ='"+ user.getId());
			while (result.next()) {
				Message message = new Message();
				message.setId(result.getLong(1));
				message.setTitle(result.getString(2));
				message.setContent(result.getString(3));
				//ce qu'on veut récupérer du message
				messages.add(message);
				stmt.close();
				con.close();
			}
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		} else {
			return null;
		}
		return messages;
	}
	
	@Override
	public List<Message> getListOfMessagesAll(User user) {
		List<Message> messages = new ArrayList<>();
		
		Connection con = ConnectionTool.getConnection();
		if (con != null)
		{
			try {
				
			Statement stmt = con.createStatement();
			ResultSet result = stmt.executeQuery("SELECT * FROM MESSAGES");
			while (result.next()) {
				Message message = new Message();
				message.setId(result.getLong(1));
				message.setTitle(result.getString(2));
				message.setContent(result.getString(3));
				//ce qu'on veut récupérer du message
				messages.add(message);
				stmt.close();
				con.close();
			}
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		} else {
			return null;
		}
		return messages;
	}

	@Override
	public Message getMessage(Long id) {
		Message message = new Message();
		Connection con = ConnectionTool.getConnection();
		if (con != null)
		{
			try {
				
			Statement stmt = con.createStatement();
			ResultSet result = stmt.executeQuery("SELECT first FROM MESSAGES WHERE ID ='"+ id);
			message.setId(result.getLong(1));
			message.setTitle(result.getString(2));
			//ce qu'on veut récupérer du message
			stmt.close();
			con.close();
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		} else {
			return null;
		}
		return message;
	}

	@Override
	public void addMessage(Message message) {
		Connection con = ConnectionTool.getConnection();
		if (con != null)
		{
			try {
				Statement stmt = con.createStatement();

				stmt.executeQuery("INSERT INTO MESSAGES VALUES ("
//						+ message.getId() +"," 
						+ "'" + message.getTitle() + "', "
						+ "'" + message.getContent() + "', "
						+ "'" + message.getAuthor() + "', "
						+ "'" + message.getCreationDate() + "', "
						+ "'" + message.getUpdateDate() + "', "
						+ message.getStatus() + ")");
				stmt.close();
				con.close();
				System.out.println("Succes: Ajout du message réussi");
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Alerte: Ajout du message non réussi");
			}
		} else {
			System.out.println("Alerte: Connection failed");
		}
	}

	@Override
	public void updateMessageStatus(Message message, int status) {
		Connection con = ConnectionTool.getConnection();
		if (con != null)
		{
			try {
				Statement stmt = con.createStatement();
				stmt.executeQuery("UDPATE MESSAGES SET STATUS '"
						+ message.getStatus() 
						+ "' WHERE ID = "
						+ message.getId());
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Alerte: Update du message non réussi");
			}
		} else {
			System.out.println("Alerte: Connection failed");
		}
		System.out.println("Succes: Mise à jour du message réussi");

	}

	@Override
	public void deleteMessage(Message message) {
		Connection con = ConnectionTool.getConnection();
		if (con != null)
		{
			try {
				Statement stmt = con.createStatement();
				stmt.executeQuery("DELETE FROM MESSAGES "
						+ "WHERE ID = "
						+ message.getId());
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Alerte: Suppression du message non réussi");
			}
		} else {
			System.out.println("Alerte: Connection failed");
		}
		System.out.println("Succes: Suppression du message réussi");

	}

}
