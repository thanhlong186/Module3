package service.service.impl;

import model.Service;
import repository.service.IServiceRepository;
import repository.service.impl.ServiceRepository;
import service.service.IServiceService;

import java.util.List;

public class ServiceServiceImpl implements IServiceService {
    private IServiceRepository iServiceRepository = new ServiceRepository();
    @Override
    public List<Service> getAllService() {
        List<Service> serviceList = iServiceRepository.getAllService();
        if(serviceList == null) {
            return null;
        } else {
            return iServiceRepository.getAllService();
        }
    }

    @Override
    public void createService(Service service) {
        iServiceRepository.createService(service);
    }
}
