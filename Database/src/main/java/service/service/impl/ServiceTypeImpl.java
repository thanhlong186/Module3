package service.service.impl;

import model.ServiceType;
import repository.service.IServiceRepository;
import repository.service.IServiceTypeRepository;
import repository.service.impl.ServiceRepository;
import repository.service.impl.ServiceTypeRepository;
import service.service.IServiceType;

import java.util.List;

public class ServiceTypeImpl implements IServiceType {
    private IServiceTypeRepository iServiceTypeRepository = new ServiceTypeRepository();
    @Override
    public List<ServiceType> findAll() {
        return iServiceTypeRepository.findAll();
    }
}
