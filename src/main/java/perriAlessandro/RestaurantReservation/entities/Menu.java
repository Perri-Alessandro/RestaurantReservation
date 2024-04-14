package perriAlessandro.RestaurantReservation.entities;

import jakarta.persistence.Table;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Getter
@Table(name = "menu")
@Setter
@ToString
@NoArgsConstructor
public class Menu {
    @Id
    @GeneratedValue
    protected Long id;
    
    @OneToMany(mappedBy = "menu")
    protected List<MenuItem> dishes;
}
