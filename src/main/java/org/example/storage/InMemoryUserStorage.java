package org.example.storage;

import org.example.domain.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InMemoryUserStorage implements UserStorage {
	private List<User> users = new ArrayList<>();
 	@Override
	public void save(User user) {
		users.add(user);
	}

	@Override
	public User getByLogin(String login) {
		for (User user : users) {
			if (user.getLogin().equals(login)){
				return user;
			}
		}
		return null;
	}

	@Override
	public boolean contains(String login) {
		for (User user : users) {
			if (user.getLogin().equals(login)) {
				return true;
			}
		}
		return false;
	}
}
