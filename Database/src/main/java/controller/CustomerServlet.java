package controller;

import model.Customer;
import model.CustomerType;
import repository.customer.ICustomerRepository;
import repository.customer.impl.CustomerRepository;
import service.customer.ICustomerService;
import service.customer.ICustomerTypeService;
import service.customer.impl.CustomerServiceImpl;
import service.customer.impl.CustomerTypeService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DataBaseServlet", urlPatterns = "/customers")
    public class CustomerServlet extends HttpServlet {
    private ICustomerService iCustomerService = new CustomerServiceImpl();
    private ICustomerTypeService iCustomerTypeService = new CustomerTypeService();



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            request.setCharacterEncoding("UTF-8");
            String action = request.getParameter("action");
                if(action == null) {
                    action = "";
                }
            switch (action) {
                case "create":
                    showCreate(request, response);
                    break;
                case "edit":
                    showEdit(request, response);
                    break;
                case "view":
                    showView(request, response);
                    break;
                default:
                    listCustomer(request, response);
                    break;
            }
    }

    private void showView(HttpServletRequest request, HttpServletResponse response) {
        List<CustomerType> customerTypeList = iCustomerTypeService.findAll();
        request.setAttribute("customerTypeList", customerTypeList);
        int customerID = Integer.parseInt(request.getParameter("customerID"));
        Customer customer = iCustomerService.findByCustomer(customerID);
        RequestDispatcher dispatcher;
        if(customer == null){
            dispatcher = request.getRequestDispatcher("error.404.jsp");
        } else {
            request.setAttribute("customer", customer);
            dispatcher = request.getRequestDispatcher("customer/view.jsp");
        }
        try{
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEdit(HttpServletRequest request, HttpServletResponse response) {
        List<CustomerType> customerTypeList = iCustomerTypeService.findAll();
        request.setAttribute("customerTypeList", customerTypeList);
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = iCustomerService.findByCustomer(id);
        RequestDispatcher dispatcher;
        if (customer == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("customer", customer);
            dispatcher = request.getRequestDispatcher("customer/edit.jsp");
        }
        try{
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void listCustomer(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> customers = iCustomerService.getAllCustomer();
        // name: customers phải trùng với items bên list.jsp
        request.setAttribute("customers", customers);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        private void showCreate(HttpServletRequest request, HttpServletResponse response) {
        List<CustomerType> customerTypeList = iCustomerTypeService.findAll();
        request.setAttribute("customerTypeList", customerTypeList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("customer/create.jsp");
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
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if(action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createCustomer(request, response);
                break;
            case "edit":
                updateCustomer(request, response);
                break;
            case "search":
                searchCustomer(request, response);
                break;
            case "delete":
                deleteCustomer(request, response);
                break;
        }
    }

    private void searchCustomer(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        List<Customer> customerList = iCustomerService.searchCustomer(name);
        request.setAttribute("customers", customerList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) {
        //ko update id. phần hiển thị update
        int id = Integer.parseInt(request.getParameter("customer_id"));
        String code = request.getParameter("customer_code");
        String name = request.getParameter("customer_name");
        String birthday = request.getParameter("customer_birthday");
        boolean gender = Boolean.parseBoolean(request.getParameter("customer_gender"));
        String idCard = request.getParameter("customer_id_card");
        String phone = request.getParameter("customer_phone");
        String email = request.getParameter("customer_email");
        String address = request.getParameter("customer_address");
        int cusTypeId = Integer.parseInt(request.getParameter("customer_type_id"));

        Customer customer = new Customer(name, code, birthday, gender, idCard, phone, email, address, cusTypeId);
        iCustomerService.updateCustomer(id, customer);
        RequestDispatcher dispatcher;
        dispatcher = request.getRequestDispatcher("customer/list.jsp");

        if(customer == null){
            dispatcher = request.getRequestDispatcher("error-404");
        } else {
//            customer.setCustomerName(name);
//            customer.setCustomerCode(code);
//            customer.setCustomerBirthday(birthday);
//            customer.setCustomerGender(gender);
//            customer.setCustomerIdCard(idCard);
//            customer.setCustomerPhone(phone);
//            customer.setCustomerEmail(email);
//            customer.setCustomerAddress(address);
//            customer.setCustomerTypeId(cusTypeId);
//            this.iCustomerService.updateCustomer(id);
            request.setAttribute("customer", customer);
            request.setAttribute("message","Customer information was updated");
            dispatcher = request.getRequestDispatcher("customer/list.jsp");
        }
        try{

//            dispatcher.forward(request,response);
            response.sendRedirect("/customers");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        iCustomerService.deleteCustomer(id);
        try{
            response.sendRedirect("/customers");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createCustomer(HttpServletRequest request, HttpServletResponse response) {
        //phần hiển thị từng dòng để nhập dữ liệu
        String code = request.getParameter("customer_code");
            String name = request.getParameter("customer_name");
            String birthday = request.getParameter("customer_birthday");
            boolean gender = Boolean.parseBoolean(request.getParameter("customer_gender"));
            String idCard = request.getParameter("customer_id_card");
            String phone = request.getParameter("customer_phone");
            String email = request.getParameter("customer_email");
            String address = request.getParameter("customer_address");
            int cusTypeId = Integer.parseInt(request.getParameter("customer_type_id"));

            Customer customer = new Customer(code, name, birthday, gender, idCard, phone, email, address, cusTypeId);
            iCustomerService.createCustomer(customer);
            RequestDispatcher dispatcher = request.getRequestDispatcher("customer/create.jsp");
            request.setAttribute("message", "New customer was created");
            try {
                response.sendRedirect("/customers");
//                dispatcher.forward(request, response);
            } catch (IOException e) {
                e.printStackTrace();
            }

    }

}
