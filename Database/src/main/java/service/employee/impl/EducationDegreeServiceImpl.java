package service.employee.impl;

import model.EducationDegree;
import repository.employee.IDivisionRepository;
import repository.employee.IEducationDegreeRepository;
import repository.employee.impl.EducationDegreeRepository;
import service.employee.IEducationDegreeService;
import service.employee.IEmployeeService;

import java.util.List;

public class EducationDegreeServiceImpl implements IEducationDegreeService {
    private IEducationDegreeRepository iEducationDegreeRepository = new EducationDegreeRepository();
    @Override
    public List<EducationDegree> findAllEducation() {
        return iEducationDegreeRepository.findAllEducation();
    }


}
