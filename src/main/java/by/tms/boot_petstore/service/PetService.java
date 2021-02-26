package by.tms.boot_petstore.service;

import by.tms.boot_petstore.model.Pet;
import by.tms.boot_petstore.model.PetStatus;
import by.tms.boot_petstore.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PetService {
    @Autowired
    private PetRepository petRepository;

    public void createPet(Pet pet) {
        petRepository.save(pet);
    }

    public Pet findById(long id) {
        if (petRepository.contains(id)) {
            return petRepository.findById(id);
        } else {
            throw new PetNotFoundException(id);
        }
    }

    public void updatePet(Pet pet) {
        if (petRepository.contains(pet.getId())) {
            petRepository.update(pet);
        } else {
            throw new PetNotFoundException(pet.getId());
        }
    }

    public void deletePet(long id) {
        if (petRepository.contains(id)) {
            petRepository.delete(id);
        } else {
            throw new PetNotFoundException(id);
        }
    }

    public List<Pet> findByStatus(String status) {
        if (status.equalsIgnoreCase(PetStatus.AVAILABLE.name()) || status.equalsIgnoreCase(PetStatus.PENDING.name()) ||
                status.equalsIgnoreCase(PetStatus.SOLD.name())) {
            List<Pet> byStatus = new ArrayList<>();
            for (Pet pet : petRepository.getPets()) {
                if (pet.getPetStatus().name().equalsIgnoreCase(status)) {
                    byStatus.add(pet);
                }
            }
            return byStatus;
        } else {
            throw new InvalidStatusException(status);
        }
    }
}
