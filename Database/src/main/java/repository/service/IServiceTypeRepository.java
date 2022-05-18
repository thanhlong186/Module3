package repository.service;

import model.ServiceType;

import java.util.List;

public interface IServiceTypeRepository {
    List<ServiceType> findAll();
}
