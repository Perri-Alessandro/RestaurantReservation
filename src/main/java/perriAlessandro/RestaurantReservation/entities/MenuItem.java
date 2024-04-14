package perriAlessandro.RestaurantReservation.entities;

import jakarta.persistence.Table;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Table(name = "menuItem")
@Setter
@ToString
@NoArgsConstructor
public class MenuItem {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String description;
    private double price;
    private String image;
    
    @ManyToOne
    private Menu menu;
}
