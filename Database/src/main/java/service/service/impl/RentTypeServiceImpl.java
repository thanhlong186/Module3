package service.service.impl;

import model.RentType;
import repository.service.IRentTypeRepository;
import repository.service.impl.RentTypeRepositoryImpl;
import service.service.IRentTypeService;

import java.util.List;

public class RentTypeServiceImpl implements IRentTypeService {
    private IRentTypeRepository iRentTypeRepository = new RentTypeRepositoryImpl();
    @Override
    public List<RentType> findRentAll() {
        return iRentTypeRepository.findRentAll();
    }
}
