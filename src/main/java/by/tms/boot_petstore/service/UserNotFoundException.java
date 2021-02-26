package by.tms.boot_petstore.service;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String name) {
        super("User with username " + name + " not found");
    }

}
