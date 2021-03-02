package by.tms.boot_petstore.resource;

import by.tms.boot_petstore.model.Category;
import by.tms.boot_petstore.model.Pet;
import by.tms.boot_petstore.model.Tag;
import by.tms.boot_petstore.service.CategoryService;
import by.tms.boot_petstore.service.PetService;
import by.tms.boot_petstore.service.TagService;
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
        petService.createPet(pet);
        return new ResponseEntity<>(pet, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{petId}")
    public ResponseEntity<Pet> updatePet(@Valid @RequestBody Pet pet, @PathVariable("petId") long id) {
        petService.findById(id);
        pet.setId(id);
        petService.updatePet(pet);
        return new ResponseEntity<>(pet, HttpStatus.OK);
    }

    @GetMapping(path = "/findByStatus")
    public ResponseEntity<List<Pet>> findByStatus(String status) {
        List<Pet> byStatus = petService.findByStatus(status);
        if (byStatus.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(byStatus, HttpStatus.OK);
    }

    @GetMapping(path = "/{petId}")
    public ResponseEntity<Pet> findPetById(@PathVariable("petId") long id) {
        Pet byId = petService.findById(id);
        return new ResponseEntity<>(byId, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{petId}")
    public ResponseEntity<Void> deletePet(@PathVariable("petId") long id) {
        petService.deletePet(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // Pet's category and tags methods

    @PostMapping(path = "/tag")
    public ResponseEntity<Tag> createTag(@Valid @RequestBody Tag tag) {
        tagService.createTag(tag);
        return new ResponseEntity<>(tag, HttpStatus.CREATED);
    }

    @GetMapping(path = "/tag/{tagId}")
    public ResponseEntity<Tag> findTagById(@PathVariable("tagId") long id) {
        Tag byId = tagService.findById(id);
        return new ResponseEntity<>(byId, HttpStatus.OK);
    }

    @DeleteMapping(path = "/tag/{tagId}")
    public ResponseEntity<Void> deleteTag(@PathVariable("tagId") long id) {
        tagService.deleteTag(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(path = "/category")
    public ResponseEntity<Category> createCategory(@Valid @RequestBody Category category) {
        categoryService.createCategory(category);
        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }

    @GetMapping(path = "/category/{categoryId}")
    public ResponseEntity<Category> findCategoryById(@PathVariable("categoryId") long id) {
        Category byId = categoryService.findById(id);
        return new ResponseEntity<>(byId, HttpStatus.OK);
    }

    @DeleteMapping(path = "/category/{categoryId}")
    public ResponseEntity<Void> deleteCategory(@PathVariable("categoryId") long id) {
        categoryService.deleteCategory(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
