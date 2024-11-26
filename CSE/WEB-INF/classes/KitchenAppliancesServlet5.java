import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({"/KitchenAppliancesServlet5"})
public class KitchenAppliancesServlet5 extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String DB_URL = "jdbc:mysql://localhost:3306/kitchen_appliances";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    public KitchenAppliancesServlet5() {}

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String contact = request.getParameter("contact");
        String appliance = request.getParameter("appliance");
        String issue = request.getParameter("issue");
        String details = request.getParameter("details");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            try {
                String insertQuery = "INSERT INTO feedback (name, contact, appliance, issue, details) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement insertStatement = connection.prepareStatement(insertQuery);

                try {
                    insertStatement.setString(1, name);
                    insertStatement.setString(2, contact);
                    insertStatement.setString(3, appliance);
                    insertStatement.setString(4, issue);
                    insertStatement.setString(5, details);

                    int rowsInserted = insertStatement.executeUpdate();
                    if (rowsInserted > 0) {
                        String selectQuery = "SELECT * FROM feedback WHERE contact = ? ORDER BY id DESC LIMIT 1";
                        PreparedStatement selectStatement = connection.prepareStatement(selectQuery);

                        try {
                            selectStatement.setString(1, contact);
                            ResultSet resultSet = selectStatement.executeQuery();
                            if (resultSet.next()) {
                                out.println("<!DOCTYPE html>");
                                out.println("<html lang='en'>");
                                out.println("<head>");
                                out.println("<meta charset='UTF-8'>");
                                out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
                                out.println("<title>Feedback Submitted</title>");
                                out.println("<style>");
                                out.println("body { font-family: Arial, sans-serif; background-color: #f9f9f9; padding: 20px; }");
                                out.println(".container { background-color: #ffffff; padding: 20px; border-radius: 5px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); }");
                                out.println("h1 { font-size: 24px; color: #333; }");
                                out.println("ul { list-style-type: none; padding: 0; }");
                                out.println("li { margin: 10px 0; }");
                                out.println("</style>");
                                out.println("</head>");
                                out.println("<body>");
                                out.println("<div class='container'>");
                                out.println("<h1>Feedback Submitted</h1>");
                                out.println("<p>Thank you, <strong>" + name + "</strong>, for providing your feedback. Here are the details:</p>");
                                out.println("<ul>");
                                out.println("<li><strong>Contact:</strong> " + resultSet.getString("contact") + "</li>");
                                out.println("<li><strong>Appliance:</strong> " + resultSet.getString("appliance") + "</li>");
                                out.println("<li><strong>Issue:</strong> " + resultSet.getString("issue") + "</li>");
                                String feedbackDetails = resultSet.getString("details").isEmpty() ? "No additional details provided" : resultSet.getString("details");
                                out.println("<li><strong>Details:</strong> " + feedbackDetails + "</li>");
                                out.println("</ul>");
                                out.println("<p>Our support team will get in touch with you shortly.</p>");
                                out.println("</div>");
                                out.println("</body>");
                                out.println("</html>");
                            } else {
                                out.println("<p>Error: No data found after submission. Please try again later.</p>");
                            }
                        } finally {
                            if (selectStatement != null) {
                                selectStatement.close();
                            }
                        }
                    } else {
                        out.println("<p>Error: No rows inserted. Please try again later.</p>");
                    }
                } finally {
                    if (insertStatement != null) {
                        insertStatement.close();
                    }
                }
            } finally {
                if (connection != null) {
                    connection.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            out.println("<p>Error processing your request: " + e.getMessage() + "</p>");
        }
    }
}

