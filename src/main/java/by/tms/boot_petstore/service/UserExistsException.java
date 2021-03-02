package by.tms.boot_petstore.service;

public class UserExistsException extends RuntimeException {
    public UserExistsException(String username) {
        super("User with username " + username + " already exists");
    }
}
