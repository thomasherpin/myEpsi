package fr.epsi.myEpsi.service;

import fr.epsi.myEpsi.beans.User;

public class ConnectionService implements IConnectionService {

	IUserService userService = new UserService();
	
	@Override
	public boolean isAuthorized(User user) {
		// TODO Auto-generated method stub
		if (userService.getUserById(user.getId()).getPassword().equals(user.getPassword())) {
			return true;
		}
		return false;
	}

}
