package repository.service;

import model.Customer;
import model.Service;

import java.util.List;

public interface IServiceRepository {
    List<Service> getAllService();

    void createService(Service service);
}