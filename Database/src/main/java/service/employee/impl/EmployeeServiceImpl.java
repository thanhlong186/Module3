package service.employee.impl;

import model.Customer;
import model.Employee;
import repository.employee.IEmployeeRepository;
import repository.employee.impl.EmployeeRepository;
import service.customer.ICustomerService;
import service.employee.IEmployeeService;

import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceImpl implements IEmployeeService {
    private static IEmployeeRepository iEmployeeRepository = new EmployeeRepository();

    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> employeeList = iEmployeeRepository.getAllEmployee();
        if (employeeList.size() == 0) {
            return null;
        }
        return iEmployeeRepository.getAllEmployee();
    }

    @Override
    public Employee findByEmployee(int codeEmployee) {
        return null;
    }

    @Override
    public void updateEmployee(Employee employee) {

    }

    @Override
    public void deleteEmployee(int id) {

    }

    @Override
    public List<Employee> searchEmployee(String name) {
        return null;
    }

    @Override
    public void create(Employee employee) {
        iEmployeeRepository.create(employee);
    }

}
