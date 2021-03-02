package by.tms.boot_petstore.resource;

import by.tms.boot_petstore.model.Order;
import by.tms.boot_petstore.model.PetStatus;
import by.tms.boot_petstore.repository.PetRepository;
import by.tms.boot_petstore.service.PetService;
import by.tms.boot_petstore.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping(path = "/store")
public class StoreResource {
    @Autowired
    private StoreService storeService;

    @Autowired
    private PetRepository petRepository;


    @PostMapping(path = "/order")
    public ResponseEntity<Order> createOrder(@Valid @RequestBody Order order) {
        storeService.createOrder(order);
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }

    @GetMapping(path = "/order/{orderId}")
    public ResponseEntity<Order> findById(@PathVariable("orderId") long id) {
        Order byId = storeService.findById(id);
        return new ResponseEntity<>(byId, HttpStatus.OK);
    }

    @DeleteMapping(path = "/order/{orderId}")
    public ResponseEntity<Void> deletePet(@PathVariable("orderId") long id) {
        storeService.deleteOrder(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(path = "/inventory")
    public ResponseEntity<Map<PetStatus, Integer>> inventoryPetsByStatus() {
        Map<PetStatus, Integer> petsByStatus = storeService.inventoryPetsByStatus(petRepository.getPets());
        if (petsByStatus.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(petsByStatus, HttpStatus.OK);
    }
}
