package org.example.console;

import org.example.console.action.UserAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.example.console.util.ConsoleWriter.*;
import static org.example.console.util.ConsoleReader.*;

@Component
public class ConsoleApplication {

	@Autowired
	public Session session;

	@Autowired
	private UserAction userAction;


	public void run() {
		while (true) {
			if (session.getUser() == null){
				write("Welcome guest");
				guestMenu();
				switch (readInt()){
					case 0:
						return;
					case 1:
						userAction.registration();
						break;
					case 2:
						userAction.authorization();
						break;
				}
			} else {
				write("Welcome " + session.getUser().getName());
				userMenu();
				switch (readInt()){
					case 0:
						userAction.logout();
						break;
					case 1:
						break;
				}
			}

		}
	}

	private void guestMenu() {
		write("0 - Exit");
		write("1 - Registration");
		write("2 - Authorization");
	}

	private void userMenu() {
		write("0 - Logout");
		write("1 - Account");
	}
}
