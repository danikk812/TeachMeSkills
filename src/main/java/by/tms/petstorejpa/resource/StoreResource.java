package by.tms.petstorejpa.resource;

import by.tms.petstorejpa.entity.Order;
import by.tms.petstorejpa.entity.PetStatus;
import by.tms.petstorejpa.service.OrderService;
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
    private OrderService orderService;

    @PostMapping(path = "/order")
    public ResponseEntity<Order> createOrder(@Valid @RequestBody Order order) {
        Order createdOrder = orderService.createOrder(order);
        return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
    }

    @GetMapping(path = "/order/{orderId}")
    public ResponseEntity<Order> findById(@PathVariable("orderId") long id) {
        Order byId = orderService.findById(id);
        return new ResponseEntity<>(byId, HttpStatus.OK);
    }

    @DeleteMapping(path = "/order/{orderId}")
    public ResponseEntity<HttpStatus> deletePet(@PathVariable("orderId") long id) {
        orderService.deleteOrder(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(path = "/inventory")
    public ResponseEntity<Map<PetStatus, Integer>> inventoryPetsByStatus() {
        Map<PetStatus, Integer> petsByStatus = orderService.inventoryPetsByStatus();
        if (petsByStatus.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(petsByStatus, HttpStatus.OK);
    }

}
