package perriAlessandro.RestaurantReservation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import perriAlessandro.RestaurantReservation.entities.Customer;
import perriAlessandro.RestaurantReservation.entities.Reservation;
import perriAlessandro.RestaurantReservation.entities.Table;

import java.util.List;

public interface ReservationDAO extends JpaRepository<Reservation, Long> {
    boolean existsByTable(Table table);

    List<Reservation> findByCustomer(Customer customer);
}
