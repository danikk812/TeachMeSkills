package org.example.storage;

import org.example.domain.User;

public interface UserStorage {
	void save(User user);
	User getByLogin(String login);
	boolean contains(String login);
}
