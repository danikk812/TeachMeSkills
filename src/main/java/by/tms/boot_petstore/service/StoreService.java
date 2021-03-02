package by.tms.boot_petstore.service;

import by.tms.boot_petstore.model.Order;
import by.tms.boot_petstore.model.Pet;
import by.tms.boot_petstore.model.PetStatus;
import by.tms.boot_petstore.repository.OrderRepository;
import by.tms.boot_petstore.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public Map<PetStatus, Integer> inventoryPetsByStatus(List<Pet> pets) {
        Map<PetStatus, Integer> petsByStatus = new HashMap<>();
        for (Pet pet : pets) {
            PetStatus petStatus = pet.getPetStatus();
            switch (petStatus) {
                case AVAILABLE:
                case PENDING:
                case SOLD:
                    petsByStatus.put(petStatus, petsByStatus.getOrDefault(petStatus, 0) + 1);
                    break;
                default:
                    throw new InvalidStatusException(petStatus.name());
            }
        }
        return petsByStatus;
    }

}
