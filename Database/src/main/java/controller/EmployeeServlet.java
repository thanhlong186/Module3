package controller;

import model.Division;
import model.EducationDegree;
import model.Employee;
import model.Position;
import service.employee.IDivisionService;
import service.employee.IEducationDegreeService;
import service.employee.IEmployeeService;
import service.employee.IPositionService;
import service.employee.impl.DivisionServiceImpl;
import service.employee.impl.EducationDegreeServiceImpl;
import service.employee.impl.EmployeeServiceImpl;
import service.employee.impl.PositionServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "EmployeeServlet", value = "/employees")
public class EmployeeServlet extends HttpServlet {
    private IEmployeeService iEmployeeService = new EmployeeServiceImpl();
    private IPositionService iPositionService = new PositionServiceImpl();
    private IEducationDegreeService iEducationDegreeService = new EducationDegreeServiceImpl();
    private IDivisionService iDivisionService = new DivisionServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String action = request.getParameter("action");
            if (action == null){
                action = "";
            }
            switch (action) {
                case "create":
                    showCreate(request, response);
                    break;
                default:
                    listEmployee(request, response);
                    break;
            }
    }

    private void listEmployee(HttpServletRequest request, HttpServletResponse response) {
        List<Employee> employees = iEmployeeService.getAllEmployee();
        request.setAttribute("employees", employees); // name sẽ là item bên list.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/list.jsp");
        try{
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) {
        List<Position> positionList = iPositionService.findAllPosition();
        request.setAttribute("positionList", positionList);
        List<EducationDegree> educationDegreeList = iEducationDegreeService.findAllEducation();
        request.setAttribute("educationDegreeList", educationDegreeList);
        List<Division> divisionList = iDivisionService.findAllDivision();
        request.setAttribute("divisionList", divisionList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/create.jsp");
        try{
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action) {
            case "create":
                createEmployee(request, response);
                break;
            default:
                break;
        }
    }

    private void createEmployee(HttpServletRequest request, HttpServletResponse response) {
        // phần này hiển thị nhưng name phải trùng với database
        String name = request.getParameter("employee_name");
        String birthday = request.getParameter("employee_birthday");
        String idCard = request.getParameter("employee_id_card");
        double salary = Double.parseDouble(request.getParameter("employee_salary"));
        String phone = request.getParameter("employee_phone");
        String email = request.getParameter("employee_email");
        String address = request.getParameter("employee_address");
        int positionId = Integer.parseInt(request.getParameter("position_id"));
        int educationDegreeId = Integer.parseInt(request.getParameter("education_degree_id"));
        int divisionId = Integer.parseInt(request.getParameter("division_id"));
        String username = request.getParameter("username");

        Employee employee = new Employee(name, birthday, idCard, salary, phone,
                email, address,positionId,educationDegreeId,divisionId,username);
        this.iEmployeeService.create(employee);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/create.jsp");
        request.setAttribute("message", "New employee was created");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
