package by.tms.boot_petstore.repository;

import by.tms.boot_petstore.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class UserRepository {
    private List<User> users = new ArrayList<>();
    private static final AtomicLong idGenerator = new AtomicLong();

    public void save(User user) {
        user.setId(idGenerator.incrementAndGet());
        users.add(user);
    }

    public User findById(long id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public User findByUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public void updateById(User user) {
        for (User user1 : users) {
            if (user1.getId() == user.getId()) {
                int index = users.indexOf(user1);
                users.set(index, user);
            }
        }
    }

    public void updateByUsername(User user) {
        for (User currentUser : users) {
            if (currentUser.getUsername().equals(user.getUsername())) {
                int index = users.indexOf(currentUser);
                users.set(index, user);
            }
        }
    }

    public void delete(long id) {
        User user = findById(id);
        users.remove(user);
    }

    public void delete(String username) {
        User user = findByUsername(username);
        users.remove(user);
    }

    public boolean contains(long id) {
        return findById(id) != null;
    }

    public boolean contains(String username) {
        return findByUsername(username) != null;
    }
}
