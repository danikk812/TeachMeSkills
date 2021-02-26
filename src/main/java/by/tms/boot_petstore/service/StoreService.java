package by.tms.boot_petstore.service;

import by.tms.boot_petstore.model.Order;
import by.tms.boot_petstore.repository.OrderRepository;
import by.tms.boot_petstore.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private PetRepository petRepository;

    public void createOrder(Order order) {
        if (petRepository.contains(order.getPetId())) {
            orderRepository.save(order);
        } else {
            throw new PetNotFoundException(order.getPetId());
        }
    }

    public Order findById(long id) {
        if (orderRepository.contains(id)) {
            return orderRepository.findById(id);
        } else {
            throw new OrderNotFoundException(id);
        }
    }

    public void deleteOrder(long id) {
        if (orderRepository.contains(id)) {
            orderRepository.delete(id);
        } else {
            throw new OrderNotFoundException(id);
        }
    }

}
