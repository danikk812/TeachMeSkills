package by.tms.petstorejpa.repository;

import by.tms.petstorejpa.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token, Long> {
    Optional<Token> findByUserId(Long id);
    Optional<Token> findByKey(String key);
}
