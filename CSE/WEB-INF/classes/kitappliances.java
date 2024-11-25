import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/kitappliances")
public class kitappliances extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head><title>Kitchen Appliances</title></head>");
        out.println("<body style='background-color: green;'>");
        out.println("<h1>About Kitchen Appliances</h1>");
        out.println("<p>Kitchen appliances are essential tools that make cooking and food preparation more convenient and efficient. These appliances come in a variety of types and are designed to handle specific tasks in the kitchen.</p>");
        out.println("<h2>List of Kitchen Appliances:</h2>");
        out.println("<ul>");
        out.println("<li><b>Mixer:</b> Used for blending ingredients to create batters, smoothies, and other mixtures.</li>");
        out.println("<li><b>Grinder:</b> Ideal for grinding spices, coffee beans, and other ingredients into fine powders or pastes.</li>");
        out.println("<li><b>Cooker:</b> A versatile appliance used for cooking rice, steaming vegetables, and preparing one-pot meals.</li>");
        out.println("<li><b>Stove:</b> A primary appliance for heating and cooking food, typically powered by gas or electricity.</li>");
        out.println("</ul>");
        out.println("<p>With these appliances, your kitchen becomes a more functional and enjoyable space for preparing delicious meals.</p>");
        out.println("</body>");
        out.println("</html>");

        out.close();
    }
}
