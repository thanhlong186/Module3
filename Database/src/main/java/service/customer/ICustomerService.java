package service.customer;

import model.Customer;
import model.Employee;
import model.Service;

import java.util.List;

public interface ICustomerService {
    List<Customer> getAllCustomer();

    void createCustomer(Customer customer);

    Customer findByCustomer(int id);

    void updateCustomer(int id, Customer customer);

    void deleteCustomer(int id);

    List<Customer> searchCustomer(String name);
}
