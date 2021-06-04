package org.example.storage;

import org.example.domain.User;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;

@Component
public class JdbcUserStorage implements UserStorage {
	@Override
	public void save(User user) {
//		Connection connection = DriverManager.getConnection();
//		connection.prepareStatement()
	}

	@Override
	public User getByLogin(String login) {
		return null;
	}

	@Override
	public boolean contains(String login) {
		return false;
	}
}
