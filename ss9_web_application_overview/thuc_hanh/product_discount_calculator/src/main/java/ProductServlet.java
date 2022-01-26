import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ProductServlet", urlPatterns = "/product")
public class ProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String listPrice = request.getParameter("listPrice");
        String discountPercent = request.getParameter("discountPercent");

        double discountAmount = Double.parseDouble(listPrice) * Double.parseDouble(discountPercent) * 0.01;
        double discountPrice =  Double.parseDouble(listPrice) - discountAmount;

        request.setAttribute("discountAmount", discountAmount);
        request.setAttribute("discountPrice", discountPrice);
        request.getRequestDispatcher("discount.jsp").forward(request, response);


//        String productDescription = request.getParameter("productDescription");
//        double listPrice = Double.parseDouble(request.getParameter("listPrice"));
//        double discountPercent = Double.parseDouble(request.getParameter("discountPercent"));
//
//        double discountAmount = listPrice * discountPercent * 0.01;
//        double discountPrice = listPrice - discountAmount;
//
//
//        PrintWriter writer = response.getWriter();
//        writer.println("<html>");
//        writer.println("<h1>Product Description: " + productDescription + "</h1>");
//        writer.println("<h1>List Price: " + listPrice + "</h1>");
//        writer.println("<h1>Discount Percent: " + discountPercent + "</h1>");
//        writer.println("<h1>Discount Amount: " + discountAmount + "</h1>");
//        writer.println("<h1>Discount Price: " + discountPrice + "</h1>");
//        writer.println("</html>");
    }
}
