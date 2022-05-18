package controller;

import service.contract.IContractService;
import service.contract.impl.ContractServiceImpl;
import service.employee.IEmployeeService;
import service.employee.impl.EmployeeServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

//@WebServlet(name = "ContractServlet", value = "/ContractServlet")
//public class ContractServlet extends HttpServlet {
//
//    private static IContractService iContractService = new ContractServiceImpl();
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }
//}
