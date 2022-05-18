package controller;

import model.RentType;
import model.Service;
import model.ServiceType;
import service.contract.IContractService;
import service.contract.impl.ContractServiceImpl;
import service.service.IRentTypeService;
import service.service.IServiceService;
import service.service.IServiceType;
import service.service.impl.RentTypeServiceImpl;
import service.service.impl.ServiceServiceImpl;
import service.service.impl.ServiceTypeImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServiceServlet", urlPatterns = "/services")
public class ServiceServlet extends HttpServlet {

    private IServiceService iServiceService = new ServiceServiceImpl();
    private IServiceType iServiceType = new ServiceTypeImpl();
    private IRentTypeService iRentTypeService = new RentTypeServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreate(request, response);
                break;
            default:
                listService(request, response);
                break;
        }

    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) {
        List<ServiceType> serviceTypeList = iServiceType.findAll();
        request.setAttribute("serviceTypeList", serviceTypeList);
        List<RentType> rentTypeList = iRentTypeService.findRentAll();
        request.setAttribute("rentTypeList", rentTypeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("service/create.jsp");
        try{
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listService(HttpServletRequest request, HttpServletResponse response) {
        List<Service> serviceList = iServiceService.getAllService();
        request.setAttribute("services", serviceList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("service/list.jsp");
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
        if(action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createServices(request, response);
                break;
        }
    }

    private void createServices(HttpServletRequest request, HttpServletResponse response) {
        String code = request.getParameter("service_code");
        String name = request.getParameter("service_name");
        int area = Integer.parseInt(request.getParameter("service_area"));
        double cost = Double.parseDouble(request.getParameter("service_cost"));
        int serviceMaxPeople = Integer.parseInt(request.getParameter("service_max_people"));
        int rentTypeId = Integer.parseInt(request.getParameter("rent_type_id"));
        int serviceTypeId = Integer.parseInt(request.getParameter("service_type_id"));
        String standardRoom = request.getParameter("standard_room");
        String descriptionOtherConvenience = request.getParameter("description_other_convenience");
        double poolArea = Double.parseDouble(request.getParameter("pool_area"));
        int numberOfFloor = Integer.parseInt(request.getParameter("number_of_floor"));

        Service service = new Service(code,name, area,cost,serviceMaxPeople,  standardRoom,
                descriptionOtherConvenience, poolArea, numberOfFloor, rentTypeId, serviceTypeId);
        iServiceService.createService(service);
        try{
            response.sendRedirect("/services");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
