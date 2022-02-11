import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CalculatorServlet", urlPatterns = "/calculate")
public class CalculatorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        float firstOperand = Integer.parseInt(request.getParameter("first_operand"));
        float secondOperand = Integer.parseInt(request.getParameter("second_operand"));
        char operator = request.getParameter("operator").charAt(0);
        float result = Calculator.calculate(firstOperand, secondOperand, operator);
        try {
            request.setAttribute("firstOperand", firstOperand);
            request.setAttribute("secondOperand", secondOperand);
            request.setAttribute("operator", operator);
            request.setAttribute("result", result);
            request.getRequestDispatcher("display.jsp").forward(request, response);

        } catch (Exception ex) {
            request.setAttribute("result", ("Error: " + ex.getMessage()));
            request.getRequestDispatcher("display.jsp").forward(request, response);
        }
    }
}
