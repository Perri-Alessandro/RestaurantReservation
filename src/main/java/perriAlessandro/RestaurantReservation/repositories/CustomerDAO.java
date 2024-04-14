package perriAlessandro.RestaurantReservation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import perriAlessandro.RestaurantReservation.entities.Customer;

import java.util.Optional;

public interface CustomerDAO extends JpaRepository<Customer, Long> {
    boolean existsByEmail(String email);

    Optional<Customer> findByEmail(String email);
}
