package by.sokol.home.storage;

import by.sokol.home.entity.User;
import by.sokol.home.entity.exception.UserNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InMemoryUserStorage {
    private static int id = 1;
    private List<User> users = new ArrayList<>();

    public void save(User user) {
        user.setId(id++);
        users.add(user);
    }
    public boolean contains(User user) {
        return users.contains(user);
    }

    public User getByLogin(String login) {
        for (User user : users) {
            if (user.getLogin().equals(login)) {
                return user;
            }
        }
        throw new UserNotFoundException("User with this login does not exist!");
    }
}
