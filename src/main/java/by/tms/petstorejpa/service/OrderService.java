package by.tms.petstorejpa.service;

import by.tms.petstorejpa.entity.Order;
import by.tms.petstorejpa.entity.Pet;
import by.tms.petstorejpa.entity.PetStatus;
import by.tms.petstorejpa.repository.OrderRepository;
import by.tms.petstorejpa.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private PetRepository petRepository;

    public Order createOrder(Order order) {
        order.setShipDate(LocalDateTime.now());
        return orderRepository.save(order);
    }

    public Order findById(long id) {
        Optional<Order> order = orderRepository.findById(id);
        if (!order.isPresent()) {
            throw new ResourceNotFoundException("Order not found with id: " + id);
        } else {
            return order.get();
        }
    }

    public void deleteOrder(long id) {
        Optional<Order> order = orderRepository.findById(id);
        if (!order.isPresent()) {
            throw new ResourceNotFoundException("Order not found with id: " + id);
        } else {
            orderRepository.deleteById(id);
        }
    }

    public Map<PetStatus, Integer> inventoryPetsByStatus() {
        Map<PetStatus, Integer> petsByStatus = new HashMap<>();
        for (Pet pet : petRepository.findAll()) {
            PetStatus petStatus = pet.getPetStatus();
            petsByStatus.put(petStatus, petsByStatus.getOrDefault(petStatus, 0) + 1);
        }
        return petsByStatus;
    }
}
