package by.tms.boot_petstore.service;

public class CategoryNotFoundException extends RuntimeException {
    public CategoryNotFoundException(String message) {
        super(message);
    }

    public CategoryNotFoundException(long id) {
        super("Category with id " + " not found");
    }


}
