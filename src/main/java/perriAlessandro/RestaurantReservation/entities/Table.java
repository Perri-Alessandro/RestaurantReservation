package perriAlessandro.RestaurantReservation.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@jakarta.persistence.Table(name = "table")
@ToString
@NoArgsConstructor
public class Table {
    @Id
    @GeneratedValue
    private Long id;
    private int number;
    private int maximumCapacity;
}
