package by.tms.boot_petstore.service;

public class InvalidStatusException extends RuntimeException {
    public InvalidStatusException(String status) {
        super("Invalid status value: " + status);
    }
}
