import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/kitchencookies")
public class KitchenAppliancesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String applianceType = request.getParameter("appliance_type");
        String userName = request.getParameter("user_name");
        Cookie applianceCookie = new Cookie("appliance_type", applianceType);
        applianceCookie.setMaxAge(60 * 60 * 24); 
        response.addCookie(applianceCookie); 

        out.println("<html>");
        out.println("<head><title>Kitchen Appliances</title>");
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
        out.println("<h2>You've chosen a " + applianceType + " appliance!</h2>");
        out.println(
                "<p>" + getApplianceDescription(applianceType) + "</p>");

        out.println("</body>");
        out.println("</html>");

        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String applianceType = "Not selected";
        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("appliance_type")) {
                    applianceType = cookie.getValue();
                }
            }
        }

        out.println("<html>");
        out.println("<head><title>Kitchen Appliances</title>");
        out.println("<style>");
        out.println(
                "body { background-color: #f8f8f8; font-family: Arial, sans-serif; text-align: center; padding: 50px; }");
        out.println("h1 { font-size: 36px; font-weight: bold; color: #333; }");
        out.println("p { font-size: 20px; color: #555; }");
        out.println("form { margin-top: 30px; }");
        out.println("input[type='text'] { padding: 8px 10px; font-size: 16px; }");
        out.println(
                "button { padding: 10px 15px; background-color: #ff7043; color: white; border: none; cursor: pointer; }");
        out.println("button:hover { background-color: #ff5722; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        if (!applianceType.equals("Not selected")) {
            out.println("<h1>Welcome back! You previously selected a " + applianceType + " appliance.</h1>");
        } else {
            out.println("<h1>Welcome to our Kitchen Appliances Page</h1>");
            out.println("<p>Choose your preferred appliance from the form below.</p>");
        }

        out.println("<form method='post' action='kitchenForm'>");
        out.println("<label for='user_name'>Your Name: </label>");
        out.println("<input type='text' id='user_name' name='user_name' required><br><br>");
        out.println("<label for='appliance_type'>Preferred Appliance: </label>");
        out.println("<select id='appliance_type' name='appliance_type'>");
        out.println("<option value='Mixer'>Mixer</option>");
        out.println("<option value='Grinder'>Grinder</option>");
        out.println("<option value='Cooker'>Cooker</option>");
        out.println("<option value='Stove'>Stove</option>");
        out.println("</select><br><br>");
        out.println("<button type='submit'>Submit</button>");
        out.println("</form>");

        out.println("</body>");
        out.println("</html>");

        out.close();
    }

    private String getApplianceDescription(String applianceType) {
        switch (applianceType) {
            case "Mixer":
                return "A mixer is ideal for blending ingredients to make batters, smoothies, and more.";
            case "Grinder":
                return "A grinder helps you grind spices, coffee beans, and other items into fine powders or pastes.";
            case "Cooker":
                return "A cooker is perfect for cooking rice, steaming vegetables, and preparing one-pot meals.";
            case "Stove":
                return "A stove is a basic appliance used for heating and cooking food, running on gas or electricity.";
            default:
                return "A kitchen appliance that makes your life easier!";
        }
    }
}

