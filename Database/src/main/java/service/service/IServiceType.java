package service.service;

import model.CustomerType;
import model.Service;
import model.ServiceType;

import java.util.List;

public interface IServiceType {
    List<ServiceType> findAll();
}
