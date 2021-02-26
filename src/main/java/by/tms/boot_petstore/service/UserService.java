package by.tms.boot_petstore.service;

import by.tms.boot_petstore.model.User;
import by.tms.boot_petstore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void createUser(User user) {
        userRepository.save(user);
    }

    public void createUserWithArray(User[] users) {
        for (User user : users) {
            userRepository.save(user);
        }
    }

    public User findByUsername(String username) {
        if (userRepository.contains(username)) {
            return userRepository.findByUsername(username);
        } else {
            throw new UserNotFoundException(username);
        }
    }

    public void updateUser(User user) {
        if (userRepository.contains(user.getUsername())) {
            userRepository.updateByUsername(user);
        } else {
            throw new UserNotFoundException(user.getUsername());
        }
    }

    public void deleteUser(String username) {
        if (userRepository.contains(username)) {
            userRepository.delete(username);
        } else {
            throw new UserNotFoundException(username);
        }
    }


}
