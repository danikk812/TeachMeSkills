package by.tms.boot_petstore.resource;

import by.tms.boot_petstore.model.Pet;
import by.tms.boot_petstore.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/pet")
public class PetResource {
    @Autowired
    private PetService petService;

    @PostMapping
    public ResponseEntity<Pet> createPet(@RequestBody Pet pet) {
        petService.createPet(pet);
        return new ResponseEntity<>(pet, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Pet> updatePet(@RequestBody Pet pet) {
        petService.updatePet(pet);
        return new ResponseEntity<>(pet, HttpStatus.OK);
    }

    @GetMapping(path = "/findByStatus")
    public ResponseEntity<List<Pet>> findByStatus(String status) {
        List<Pet> byStatus = petService.findByStatus(status);
        return new ResponseEntity<>(byStatus, HttpStatus.OK);
    }

    @GetMapping(path = "/{petId}")
    public ResponseEntity<Pet> findById(@PathVariable(name = "petId") long id) {
        Pet byId = petService.findById(id);
        return new ResponseEntity<>(byId, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{petId}")
    public ResponseEntity<Void> deletePet(@PathVariable(name = "petId") long id) {
        petService.deletePet(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
