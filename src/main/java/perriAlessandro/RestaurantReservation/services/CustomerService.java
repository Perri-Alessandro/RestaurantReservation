package perriAlessandro.RestaurantReservation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import perriAlessandro.RestaurantReservation.entities.Customer;
import perriAlessandro.RestaurantReservation.exceptions.BadRequestException;
import perriAlessandro.RestaurantReservation.exceptions.NotFoundException;
import perriAlessandro.RestaurantReservation.payloads.NewCustomerDTO;
import perriAlessandro.RestaurantReservation.repositories.CustomerDAO;
import perriAlessandro.RestaurantReservation.repositories.ReservationDAO;

@Service
public class CustomerService {
    @Autowired
    private CustomerDAO customerDAO;

    @Autowired
    private ReservationDAO reservationDAO;

    public Page<Customer> getCustomersList(int page, int size, String sortBy) {
        if (size > 100) size = 100;
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return this.customerDAO.findAll(pageable);
    }

    public Customer save(NewCustomerDTO body) {
        if (customerDAO.findByEmail(body.email()).isPresent()) {
            throw new BadRequestException("L'email " + body.email() + " è già in uso!");
        }
        Customer newUser = new Customer(body.name(), body.email());

        return customerDAO.save(newUser);
    }

    public Customer findById(long id) {
        return this.customerDAO.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public Customer findByIdAndUpdate(long id, Customer updateCustomer) {
        Customer found = this.findById(id);
        found.setName(updateCustomer.getName());
        found.setEmail(updateCustomer.getEmail());
        return customerDAO.save(found);
    }

    public void findByIdAndDelete(long id) {
        Customer found = this.findById(id);
        customerDAO.delete(found);
    }
}
