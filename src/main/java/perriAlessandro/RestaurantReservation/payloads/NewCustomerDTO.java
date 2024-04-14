package perriAlessandro.RestaurantReservation.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record NewCustomerDTO(@NotEmpty(message = "Il nome è obbligatorio")
                             @Size(min = 3, max = 25, message = "Il nome deve essere compreso tra i 3 e i 25 caratteri")
                             String name,
                             @NotEmpty(message = "L'email è obbligatoria")
                             @Email(message = "L'email inserita non è valida")
                             String email) {
}
