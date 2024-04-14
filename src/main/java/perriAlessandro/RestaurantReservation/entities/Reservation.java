package perriAlessandro.RestaurantReservation.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@jakarta.persistence.Table(name = "reservation")
@ToString
@NoArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue
    private Long id;
    private LocalDate date;
    private LocalTime time;
    private long guestNumber;
    private String state;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private Table table;
}
