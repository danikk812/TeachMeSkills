package by.tms.boot_petstore.repository;

import by.tms.boot_petstore.model.Order;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class OrderRepository {
    private final List<Order> orders = new ArrayList<>();
    private static final AtomicLong idGenerator = new AtomicLong();

    public void save(Order order) {
        order.setId(idGenerator.incrementAndGet());
        order.setShipDate(LocalDateTime.now());
        orders.add(order);
    }

    public Order findById(long id) {
        for (Order order : orders) {
            if (order.getId() == id) {
                return order;
            }
        }
        return null;
    }

    public void delete(long id) {
        Order order = findById(id);
        orders.remove(order);
    }

    public boolean contains(long id) {
        return findById(id) != null;
    }
}
