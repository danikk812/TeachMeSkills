package by.tms.petstorejpa.service;

import by.tms.petstorejpa.entity.Role;
import by.tms.petstorejpa.entity.Token;
import by.tms.petstorejpa.entity.User;
import by.tms.petstorejpa.repository.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class TokenService {
    @Autowired
    private TokenRepository tokenRepository;

    @Autowired
    private UserService userService;

    public Token retrieveToken(long userId) {
        Optional<Token> byUserId = tokenRepository.findByUserId(userId);
        if (!byUserId.isPresent()) {
            UUID uuid = UUID.randomUUID();
            Token token = new Token();
            token.setUserId(userId);
            token.setKey(uuid.toString());
            return tokenRepository.save(token);
        }
        return byUserId.get();
    }

    public boolean isUser(String key) {
        Optional<Token> byKey = tokenRepository.findByKey(key);
        return byKey.isPresent();
    }

    public boolean isAdmin(String key) {
        Optional<Token> tokenByKey = tokenRepository.findByKey(key);
        if (!tokenByKey.isPresent()) {
            return false;
        } else {
            Optional<User> userById = userService.findById(tokenByKey.get().getUserId());
            return userById.map(user -> user.getRole().equals(Role.ADMIN)).orElse(false);
        }
    }
}