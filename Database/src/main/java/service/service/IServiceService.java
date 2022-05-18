package service.service;

import model.Customer;
import model.Service;

import java.util.List;

public interface IServiceService {
    List<Service> getAllService();

    void createService(Service service);

}
