package by.tms.petstorejpa.repository;

import by.tms.petstorejpa.entity.Pet;
import by.tms.petstorejpa.entity.PetStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PetRepository extends JpaRepository<Pet, Long> {
    List<Pet> findAllByPetStatus(PetStatus petStatus);
}