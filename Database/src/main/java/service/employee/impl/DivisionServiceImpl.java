package service.employee.impl;

import model.Division;
import repository.employee.IDivisionRepository;
import repository.employee.impl.DivisionRepository;
import service.employee.IDivisionService;

import java.util.List;

public class DivisionServiceImpl implements IDivisionService {
    private IDivisionRepository iDivisionRepository = new DivisionRepository();
    @Override
    public List<Division> findAllDivision() {
        return iDivisionRepository.findAllDivision();
    }
}
