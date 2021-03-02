package by.tms.boot_petstore.repository;

import by.tms.boot_petstore.model.Pet;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Repository
@Data
public class PetRepository {
    private List<Pet> pets = new ArrayList<>();
    private static final AtomicLong idGenerator = new AtomicLong();

    public void save(Pet pet) {
        pet.setId(idGenerator.incrementAndGet());
        pets.add(pet);
    }

    public Pet findById(long id) {
        for (Pet pet : pets) {
            if (pet.getId() == id) {
                return pet;
            }
        }
        return null;
    }

    public void update(Pet pet) {
        for (Pet currentPet : pets) {
            if (currentPet.getId() == pet.getId()) {
                int index = pets.indexOf(currentPet);
                pets.set(index, pet);
            }
        }
    }

    public void delete(long id) {
        Pet pet = findById(id);
        pets.remove(pet);
    }

    public boolean contains(long id) {
        return findById(id) != null;
    }

}
