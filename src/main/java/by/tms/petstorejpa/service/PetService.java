package by.tms.petstorejpa.service;

import by.tms.petstorejpa.entity.Pet;
import by.tms.petstorejpa.entity.PetStatus;
import by.tms.petstorejpa.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {
    @Autowired
    private PetRepository petRepository;

    public Pet createPet(Pet pet) {
        return petRepository.save(pet);
    }

    public Pet findById(long id) {
        Optional<Pet> pet = petRepository.findById(id);
        if (!pet.isPresent()) {
            throw new ResourceNotFoundException("Pet not found with id: " + id);
        } else {
            return pet.get();
        }
    }

    public Pet updatePet(long id, Pet pet) {
        Optional<Pet> petOptional = petRepository.findById(id);
        if (!petOptional.isPresent()) {
            throw new ResourceNotFoundException("Pet not found with id: " + id);
        } else {
            pet.setId(id);
            return petRepository.save(pet);
        }
    }

    public void deletePet(long id) {
        Optional<Pet> pet = petRepository.findById(id);
        if (!pet.isPresent()) {
            throw new ResourceNotFoundException("Pet not found with id: " + id);
        } else {
            petRepository.deleteById(id);
        }
    }

    public List<Pet> findByStatus(PetStatus petStatus) {
        return petRepository.findAllByPetStatus(petStatus);
    }
}
