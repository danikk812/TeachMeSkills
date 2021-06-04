package org.example.console.action;

import org.example.console.ConsoleApplication;
import org.example.console.Session;
import org.example.console.util.ConsoleReader;
import org.example.console.util.ConsoleWriter;
import org.example.domain.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class UserAction {

	@Autowired
	private UserService userService;

	@Autowired
	private Session session;

	public void registration(){

		ConsoleWriter.write("Enter name");
		String name = ConsoleReader.readString();

		ConsoleWriter.write("Enter login");
		String login = ConsoleReader.readString();

		ConsoleWriter.write("Enter password");
		String password = ConsoleReader.readString();

		User user = new User(login, password, name);
		userService.add(user);
	}

	public void authorization(){
		ConsoleWriter.write("Enter login");
		String login = ConsoleReader.readString();

		ConsoleWriter.write("Enter password");
		String password = ConsoleReader.readString();

		User byLogin = userService.getByLogin(login);
		if (byLogin != null) {
			if (byLogin.getPassword().equals(password)){
				session.setUser(byLogin);
			} else {
				ConsoleWriter.write("Wrong password!");
			}
		} else {
			ConsoleWriter.write("User not found!");
		}
	}

	public void logout(){
		session.setUser(null);
	}
}
