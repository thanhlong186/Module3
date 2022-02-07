package controller;

import model.Customer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList = new ArrayList<>();

        customerList.add(new Customer("Mai Văn Hoàn", "1983-08-20", "Hà Nội", "https://pdp.edu.vn/wp-content/uploads/2021/01/hinh-anh-cute-de-thuong.jpg"));
        customerList.add(new Customer("Nguyễn Văn Nam", "1983-08-21", "Bắc Giang","https://img.websosanh.vn/v2/users/review/images/4wvuq0i4ozs1q.jpg?compress=85"));
        customerList.add(new Customer("Nguyễn Thái Hòa", "1983-08-22", " Nam Định", "https://dothanhspyb.com/wp-content/uploads/2021/01/05.jpg"));
        customerList.add(new Customer("Trần Đăng Khoa", "1983-08-17", " Hà Tây", "https://camerabox.vn/uploads/news/2018_06/den-gan-chu-the.jpg"));
        customerList.add(new Customer("Nguyễn Đình Thi", "1983-08-19", " Hà Nội", "https://www.paratime.vn/wp-content/uploads/2020/02/TIME-Studio-headshot-3-elements.jpg"));

        request.setAttribute("list", customerList);
        request.getRequestDispatcher("/customer/customer_list.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
