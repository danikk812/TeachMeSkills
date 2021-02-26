package by.tms.boot_petstore.resource;

import by.tms.boot_petstore.model.Order;
import by.tms.boot_petstore.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/store/order")
public class StoreResource {
    @Autowired
    private StoreService storeService;

    @PostMapping
    public ResponseEntity<Order> createPet(@RequestBody Order order) {
        storeService.createOrder(order);
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }

    @GetMapping(path = "/{orderId}")
    public ResponseEntity<Order> findById(@PathVariable(name = "orderId") long id) {
        Order byId = storeService.findById(id);
        return new ResponseEntity<>(byId, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{petId}")
    public ResponseEntity<Void> deletePet(@PathVariable(name = "petId") long id) {
        storeService.deleteOrder(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
