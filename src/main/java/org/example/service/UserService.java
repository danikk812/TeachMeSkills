package org.example.service;

import org.example.domain.User;
import org.example.storage.InMemoryUserStorage;
import org.example.storage.UserStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class UserService {

	@Autowired
	@Qualifier("inMemoryUserStorage")
	private UserStorage userStorage;

	public boolean add(User user) {
		if (userStorage.contains(user.getLogin())) {
			return false;
		}
		userStorage.save(user);
		return true;
	}

	public User getByLogin(String login) {
		if (userStorage.contains(login)){
			User byLogin = userStorage.getByLogin(login);
			return byLogin;
		}
		return null;
	}
}
