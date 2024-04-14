package perriAlessandro.RestaurantReservation.payloads;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.time.LocalTime;

public record NewReservationDTO(@NotNull(message = "La data della prenotazione è obblogatoria!")
                                LocalDate date,
                                @NotNull(message = "L'ora della prenotazione è obblogatoria!")
                                LocalTime time,
                                @NotEmpty(message = "Il numero di cliente del cliente è obbligatorio!")
                                @Size(min = 8, max = 13, message = "Il numero di telefono deve essere compreso tra 8 e 13 caratteri")
                                long guestNumber) {

}
