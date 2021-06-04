package by.sokol.home.service;

import by.sokol.home.entity.User;
import by.sokol.home.entity.exception.UserAlreadyExistsException;
import by.sokol.home.storage.InMemoryUserStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private InMemoryUserStorage inMemoryUserStorage;

    public boolean addToStorage(User user) {
        if (!inMemoryUserStorage.contains(user)) {
            inMemoryUserStorage.save(user);
            return true;
        }
        throw new UserAlreadyExistsException("User with this login already exists!");
    }
    public User checkByLogin(String login) {
       return inMemoryUserStorage.getByLogin(login);
    }

    public boolean passwordCheck(User user, String password) {
        return user.getPassword().equals(password);
    }
}
