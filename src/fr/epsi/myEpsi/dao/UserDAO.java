package fr.epsi.myEpsi.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.epsi.myEpsi.beans.Message;
import fr.epsi.myEpsi.beans.User;

public class UserDAO implements IUserDao {

	@Override
	public List<User> getListOfUsers() {
		List<User> users = new ArrayList<>();
		
		Connection con = ConnectionTool.getConnection();
		if (con != null)
		{
			try {
				
			Statement stmt = con.createStatement();
			ResultSet result = stmt.executeQuery("SELECT * FROM USERS");
			while (result.next()) {
				User user = new User();

				user.setId(result.getString(1));
				user.setAdministrator(result.getBoolean(3));

				users.add(user);
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
		return users;
	}

	@Override
	public User getUserById(String id) {
		User user = new User();
		Connection con = ConnectionTool.getConnection();
		if (con != null)
		{
			try {
				
			Statement stmt = con.createStatement();
			ResultSet result = stmt.executeQuery("SELECT * FROM USERS WHERE ID ='" + id + "'");

			user.setId(result.getString(1));
			user.setAdministrator(result.getBoolean(3));

			stmt.close();
			con.close();
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		} else {
			return null;
		}
		return user;
	}

	@Override
	public void addUser(User user) {
		Connection con = ConnectionTool.getConnection();
		if (con != null)
		{
			try {
				Statement stmt = con.createStatement();
				stmt.executeQuery("INSERT INTO USERS VALUES ("
						+ user.getId() +"," 
						+ user.getPassword() + ","
						+ user.getAdministrator());
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Alerte: Création de l'utilisateur non réussi");
			}
		} else {
			System.out.println("Alerte: Connection failed");
		}
		System.out.println("Succes: Création de l'utilisateur réussi");
			
	}

	@Override
	public void updateUser(User user) {
		Connection con = ConnectionTool.getConnection();
		if (con != null)
		{
			try {
				Statement stmt = con.createStatement();
				stmt.executeQuery("UDPATE USERS SET PASSWORD = '"
						+ user.getPassword()
						+ "', ISADMINISTRATOR = "
						+ user.getAdministrator()
						+ ", WHERE ID = " 
						+ user.getId());
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Alerte: Update de l'utilisateur non réussi");
			}
		} else {
			System.out.println("Alerte: Connection failed");
		}
		System.out.println("Succes: Mise à jour de l'utilisateur réussi");


	}

	@Override
	public void deleteUser(User user) {
		Connection con = ConnectionTool.getConnection();
		if (con != null)
		{
			try {
				Statement stmt = con.createStatement();
				stmt.executeQuery("DELETE FROM USERS "
						+ "WHERE ID = "
						+ user.getId());
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Alerte: Suppression de l'utilisateur non réussi");
			}
		} else {
			System.out.println("Alerte: Connection failed");
		}
		System.out.println("Succes: Suppression de l'utilisateur réussi");

	}

}