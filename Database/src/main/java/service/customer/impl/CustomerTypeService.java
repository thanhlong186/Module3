package service.customer.impl;

import model.CustomerType;
import repository.customer.impl.CustomerTypeRepository;
import service.customer.ICustomerService;
import service.customer.ICustomerTypeService;

import java.util.List;

public class CustomerTypeService implements ICustomerTypeService {
    private CustomerTypeRepository customerTypeRepository = new CustomerTypeRepository();
    @Override
    public List<CustomerType> findAll() {
        return customerTypeRepository.findAll();
    }
}
