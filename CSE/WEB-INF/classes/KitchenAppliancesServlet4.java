import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/kitchenurl")
public class KitchenAppliancesServlet4 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        HttpSession session = request.getSession();
        String message;
        String bodyStyle = "background-color: #fce4ec; font-family: 'Verdana', sans-serif;"; 
        if (session.isNew() || session.getAttribute("visited") == null) {
            message = "Welcome to the Kitchen Appliances Website!";
            bodyStyle = "background-color: #f8bbd0; font-family: 'Verdana', sans-serif;";
            session.setAttribute("visited", true);  
        } else {
            message = "Welcome back to the Kitchen Appliances Website!";
        }
        String rewrittenURL = response.encodeURL("kitchenDescription");
        out.println("<html>");
        out.println("<head><title>Kitchen Appliances Description</title>");
        out.println("<style> .fade-in { animation: fadeIn 2s ease-in-out; } @keyframes fadeIn { 0% { opacity: 0; } 100% { opacity: 1; } } </style>");
        out.println("</head>");
        out.println("<body style='" + bodyStyle + "'>");
        out.println("<h1 style='font-size: 40px; font-weight: bold; text-align: center;'>" + message + "</h1>");
        out.println("<h2 style='text-align: center;'>Kitchen Appliances</h2>");
        out.println("<p style='text-align: center;'>Modern kitchen appliances are designed to make your cooking experience easier and more enjoyable. From blending ingredients to cooking meals efficiently, these appliances are essential for every household.</p>");
        out.println("<ul style='text-align: center; list-style-type: none; padding: 0;'>");
        out.println("<li><b>Mixer:</b> Perfect for blending ingredients for batters, smoothies, and sauces.</li>");
        out.println("<li><b>Grinder:</b> Ideal for grinding spices, coffee beans, and creating pastes.</li>");
        out.println("<li><b>Cooker:</b> Great for steaming, cooking rice, and preparing one-pot meals.</li>");
        out.println("<li><b>Stove:</b> A basic appliance for cooking and heating food, available in gas and electric models.</li>");
        out.println("</ul>");
        out.println("<p style='text-align: center;'>Click the link below to revisit this page with the session ID:</p>");
        out.println("<a href='" + rewrittenURL + "' style='font-size: 18px; text-decoration: none; color: darkblue;'>Revisit Kitchen Appliances Information</a>");
        
        out.println("</body>");
        out.println("</html>");
        
        out.close();
    }
}
