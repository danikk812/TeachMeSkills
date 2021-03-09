package by.tms.petstorejpa.resource;

import by.tms.petstorejpa.entity.Pet;
import by.tms.petstorejpa.entity.PetStatus;
import by.tms.petstorejpa.service.CategoryService;
import by.tms.petstorejpa.service.PetService;
import by.tms.petstorejpa.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/pet")
public class PetResource {
    @Autowired
    private PetService petService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private TagService tagService;

    @PostMapping
    public ResponseEntity<Pet> createPet(@Valid @RequestBody Pet pet) {
        Pet createdPet = petService.createPet(pet);
        return new ResponseEntity<>(createdPet, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{petId}")
    public ResponseEntity<Pet> updatePet(@Valid @RequestBody Pet pet, @PathVariable("petId") long id) {
        Pet  updatedPet = petService.updatePet(id, pet);
        return new ResponseEntity<>(updatedPet, HttpStatus.OK);
    }

    @GetMapping(path = "/{petId}")
    public ResponseEntity<Pet> findPetById(@PathVariable("petId") long id) {
        Pet byId = petService.findById(id);
        return new ResponseEntity<>(byId, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{petId}")
    public ResponseEntity<HttpStatus> deletePet(@PathVariable("petId") long id) {
        petService.deletePet(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(path = "/findByStatus")
    public ResponseEntity<List<Pet>> findByStatus(PetStatus status) {
        List<Pet> byStatus = petService.findByStatus(status);
        if (byStatus.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(byStatus, HttpStatus.OK);
    }

}
