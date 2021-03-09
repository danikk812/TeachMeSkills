package by.tms.petstorejpa.resource;

import by.tms.petstorejpa.entity.Token;
import by.tms.petstorejpa.entity.User;
import by.tms.petstorejpa.entity.UserDTO;
import by.tms.petstorejpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/user")
public class UserResource {
    @Autowired
    private UserService userService;


    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User createdUser = userService.createUser(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{username}")
    public ResponseEntity<User> updateUser(@Valid @RequestBody User user, @PathVariable("username") String name) {
        User updatedUser = userService.updateUser(name, user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @GetMapping(path = "/{username}")
    public ResponseEntity<User> findByUsername(@PathVariable("username") String name) {
        User byUsername = userService.findByUsername(name);
        return new ResponseEntity<>(byUsername, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{username}")
    public ResponseEntity<Void> deletePet(@PathVariable("username") String name) {
        userService.deleteUser(name);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(path = "/auth")
    public ResponseEntity<String> auth(@Valid @RequestBody UserDTO userDTO){
        User byUsername = userService.findByUsername(userDTO.getUsername());
        Token token = userService.authenticate(byUsername);
        return new ResponseEntity<>(token.getKey(), HttpStatus.OK);
    }
}
