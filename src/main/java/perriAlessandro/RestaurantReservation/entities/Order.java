package perriAlessandro.RestaurantReservation.entities;

import jakarta.persistence.Table;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "order")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Customer customer;

    @OneToMany(mappedBy = "order")
    private List<MenuItem> items;

    private LocalDateTime orderTime;

    private OrderState state;

    public double getTotalBill() {
        double total = 0.0;
        if (items != null) {
            for (MenuItem item : items) {
                total += item.getPrice() + 2.5;
            }
        }
        return total;
    }
}
