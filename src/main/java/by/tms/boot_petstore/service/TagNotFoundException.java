package by.tms.boot_petstore.service;

public class TagNotFoundException extends RuntimeException {
    public TagNotFoundException(String message) {
        super(message);
    }

    public TagNotFoundException(long id) {
        super("Tag with id" + id + " not found");
    }
}
