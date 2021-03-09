package by.tms.petstorejpa.service;

import by.tms.petstorejpa.entity.Token;
import by.tms.petstorejpa.entity.User;
import by.tms.petstorejpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenService tokenService;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User findByUsername(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        if (!user.isPresent()) {
            throw new ResourceNotFoundException("User not found with username: " + username);
        } else {
            return user.get();
        }
    }

    public Optional<User> findById (long id) {
        return userRepository.findById(id);
    }

    public User updateUser(String username, User user) {
        Optional<User> userOptional = userRepository.findByUsername(username);
        if (!userOptional.isPresent()) {
            throw new ResourceNotFoundException("User not found with username: " + username);
        } else {
            User existingUser = userOptional.get();
            user.setId(existingUser.getId());
            user.setUsername(username);
            return userRepository.save(user);
        }
    }

    public void deleteUser(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        if (!user.isPresent()) {
            throw new ResourceNotFoundException("User not found with username: " + username);
        } else {
            userRepository.deleteById(user.get().getId());
        }
    }

    public Token authenticate(User user){
        for (User currentUser : userRepository.findAll()) {
            if (user.equals(currentUser)) {
                long id = currentUser.getId();
                Token token = tokenService.retrieveToken(id);
                return token;
            }
        }
        throw new ResourceNotFoundException("User with such username or password not found");
    }
}

