package service.customer.impl;

import model.Customer;
import model.Service;
import repository.customer.ICustomerRepository;
import repository.customer.impl.CustomerRepository;
import repository.employee.IEmployeeRepository;
import service.customer.ICustomerService;

import java.util.List;

public class CustomerServiceImpl implements ICustomerService {
    private static ICustomerRepository iCustomerRepository = new CustomerRepository();


    @Override
    public List<Customer> getAllCustomer() {
        List<Customer> customerList = iCustomerRepository.getAllCustomer();
        if (customerList.size() == 0) {
            return null;
        }
        return iCustomerRepository.getAllCustomer();
    }

    @Override
    public void createCustomer(Customer customer) {
        iCustomerRepository.createCustomer(customer);
    }

    @Override
    public Customer findByCustomer(int id) {

        return iCustomerRepository.findByCustomer(id);
    }

    @Override
    public void updateCustomer(int id, Customer customer) {
        iCustomerRepository.updateCustomer(id, customer);

    }

    @Override
    public void deleteCustomer(int id) {
        iCustomerRepository.deleteCustomer(id);
    }

    @Override
    public List<Customer> searchCustomer(String name) {
        return iCustomerRepository.searchCustomer(name);
    }


}
