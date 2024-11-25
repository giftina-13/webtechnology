import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/kitchenhttpsession")
public class KitchenAppliancesServlet3 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();
        String message;
        String bodyStyle = "background-color: lightyellow;"; 
        if (session.isNew() || session.getAttribute("visited") == null) {
            message = "Welcome to the Kitchen Appliances Website!";
            bodyStyle = "background-color: lightblue;"; 
            session.setAttribute("visited", true);
        } else {
            message = "Welcome back to the Kitchen Appliances Website!";
        }
        out.println("<html>");
        out.println("<head><title>Kitchen Appliances</title>");
        out.println(
                "<style> .fade-in { animation: fadeIn 2s ease-in-out; } @keyframes fadeIn { 0% { opacity: 0; } 100% { opacity: 1; } } </style>");
        out.println("</head>");
        out.println("<body style='" + bodyStyle + "'>");
        out.println("<h2 style='font-size: 36px; font-weight: bold;' class='fade-in'>" + message + "</h2>");
        out.println("<h2>Kitchen Appliances</h2>");
        out.println(
                "<p>Modern kitchen appliances make cooking more efficient and enjoyable. From mixers to stoves, they are essential for simplifying tasks in the kitchen and enhancing your culinary experience.</p>");
        out.println("<ul>");
        out.println("<li><b>Mixer:</b> Perfect for blending ingredients for batters, smoothies, and sauces.</li>");
        out.println("<li><b>Grinder:</b> Used for grinding spices, coffee beans, and creating pastes.</li>");
        out.println("<li><b>Cooker:</b> Ideal for steaming, cooking rice, and preparing one-pot meals.</li>");
        out.println("<li><b>Stove:</b> A fundamental appliance for cooking and heating food, available in gas and electric models.</li>");
        out.println("</ul>");

        out.println("</body>");
        out.println("</html>");

        out.close();
    }
}

