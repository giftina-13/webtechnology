import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/kitchenForm")
public class KitchenAppliancesServlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String applianceType = request.getParameter("appliance_type");
        String userName = request.getParameter("user_name");

        out.println("<html>");
        out.println("<head><title>Kitchen Appliances Information</title>");
        out.println("<style>");
        out.println(
                "body { background-color: #f8f8f8; font-family: Arial, sans-serif; text-align: center; padding: 50px; }");
        out.println("h1 { font-size: 35px; font-weight: bold; color: #333; }");
        out.println("h2 { font-size: 30px; color: #444; }");
        out.println("p { font-size: 18px; color: #555; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Thank You, " + userName + "</h1>");
        out.println("<h2>You've chosen a " + applianceType + "!</h2>");
        out.println("<p>" + getApplianceDescription(applianceType) + "</p>");

        out.println("</body>");
        out.println("</html>");

        out.close();
    }

    private String getApplianceDescription(String applianceType) {
        switch (applianceType) {
            case "Mixer":
                return "A mixer is perfect for blending ingredients to make batters, smoothies, and other mixtures.";
            case "Grinder":
                return "A grinder helps grind spices, coffee beans, and other items into fine powders or pastes.";
            case "Cooker":
                return "A cooker is used for preparing rice, steaming vegetables, and cooking delicious one-pot meals.";
            case "Stove":
                return "A stove is a primary kitchen appliance used for heating and cooking food, powered by gas or electricity.";
            default:
                return "An essential kitchen appliance to make cooking easier!";
        }
    }
}
