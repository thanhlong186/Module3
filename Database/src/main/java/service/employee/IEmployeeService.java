package service.employee;

import model.Customer;
import model.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> getAllEmployee();


    Employee findByEmployee(int codeEmployee);

    void updateEmployee(Employee employee);

    void deleteEmployee(int id);

    List<Employee> searchEmployee(String name);

    void create(Employee employee);
}
