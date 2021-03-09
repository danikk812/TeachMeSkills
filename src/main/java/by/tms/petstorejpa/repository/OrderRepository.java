package by.tms.petstorejpa.repository;

import by.tms.petstorejpa.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
