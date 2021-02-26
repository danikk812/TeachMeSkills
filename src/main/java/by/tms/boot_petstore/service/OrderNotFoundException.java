package by.tms.boot_petstore.service;

public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(long id) {
        super("Order with id " + id +  " not found");
    }
}
