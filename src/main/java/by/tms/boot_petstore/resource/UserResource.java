package by.tms.boot_petstore.resource;

import by.tms.boot_petstore.model.User;
import by.tms.boot_petstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/user")
public class UserResource {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        userService.createUser(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PostMapping(path = "/createWithArray")
    public ResponseEntity<User[]> createUserWithArray(@RequestBody User[] users) {
        userService.createUserWithArray(users);
        return new ResponseEntity<>(users, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<User> updatePet(@RequestBody User user) {
        userService.updateUser(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping(path = "/{username}")
    public ResponseEntity<User> findByUsername(@PathVariable(name = "username") String name) {
        User byUsername = userService.findByUsername(name);
        return new ResponseEntity<>(byUsername, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{username}")
    public ResponseEntity<Void> deletePet(@PathVariable(name = "username") String name) {
        userService.deleteUser(name);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
