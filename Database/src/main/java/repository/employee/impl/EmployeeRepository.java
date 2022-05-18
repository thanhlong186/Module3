package repository.employee.impl;

import model.Employee;
import repository.BaseRepository;
import repository.employee.IEmployeeRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements IEmployeeRepository {
    private BaseRepository baseRepository = new BaseRepository();
    private static  final String INSERT_EMPLOYEE = "insert into employee(employee_name, employee_birthday, employee_id_card, employee_salary, employee_phone, employee_email, employee_address, position_id, education_degree_id, division_id, username) values (?,?,?,?,?,?,?,?,?,?,?);";


    @Override
    public List<Employee> getAllEmployee() {
        Connection connection = BaseRepository.getConnection();
        List<Employee> employeeList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        if(connection != null) {
            try {
                preparedStatement = connection.prepareStatement(
                        "select e.employee_id,\n" +
                                "e.employee_name,\n" +
                                "e.employee_birthday,\n" +
                                "e.employee_id_card,\n" +
                                "e.employee_salary,\n" +
                                "e.employee_phone,\n" +
                                "e.employee_email,\n" +
                                "e.employee_address,\n" +
                                "p.position_name,\n" +
                                "ed.education_degree_name,\n" +
                                "d.division_name,\n" +
                                "e.username \n" +
                                "from employee e\n" +
                                "join position p on e.position_id = p.position_id\n" +
                                "join education_degree ed on e.education_degree_id = ed.education_degree_id\n" +
                                "join division d on e.division_id = d.division_id");
                ResultSet resultSet = preparedStatement.executeQuery();
                Employee employee;
                while (resultSet.next()) {
                    // phần repository lấy dữ liệu từ database nên lấy giống name, phần hiển thị
                    employee = new Employee();
                    employee.setEmployeeId(resultSet.getInt("employee_id"));
                    employee.setEmployeeName(resultSet.getString("employee_name"));
                    employee.setEmployeeBirthday(resultSet.getString("employee_birthday"));
                    employee.setEmployeeIdCard(resultSet.getString("employee_id_card"));
                    employee.setEmployeeSalary(resultSet.getDouble("employee_salary"));
                    employee.setEmployeePhone(resultSet.getString("employee_phone"));
                    employee.setEmployeeEmail(resultSet.getString("employee_email"));
                    employee.setEmployeeAddress(resultSet.getString("employee_address"));
                    // hiển thị id nhưng lấy giá trị name
                    employee.setPositionName(resultSet.getString("position_name"));
                    employee.setEducationDegreeName(resultSet.getString("education_degree_name"));
                    employee.setDivisionName(resultSet.getString("division_name"));
                    employee.setUseName(resultSet.getString("username"));

                    employeeList.add(employee);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                try{
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return employeeList;
    }

    @Override
    public void create(Employee employee) {
        Connection connection = BaseRepository.getConnection();
        PreparedStatement preparedStatement = null;
        if (connection != null) {
            try {
                // lấy giá trị theo thứ tự như trong DB.
                preparedStatement = connection.prepareStatement(INSERT_EMPLOYEE);
                preparedStatement.setString(1, employee.getEmployeeName());
                preparedStatement.setString(2, employee.getEmployeeBirthday());
                preparedStatement.setString(3, employee.getEmployeeIdCard());
                preparedStatement.setDouble(4, employee.getEmployeeSalary());
                preparedStatement.setString(5, employee.getEmployeePhone());
                preparedStatement.setString(6, employee.getEmployeeEmail());
                preparedStatement.setString(7, employee.getEmployeeAddress());
                preparedStatement.setInt(8, employee.getPositionId());
                preparedStatement.setInt(9, employee.getEducationDegreeId());
                preparedStatement.setInt(10, employee.getDivisionId());
                preparedStatement.setString(11, employee.getUserName());


                preparedStatement.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
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


}
