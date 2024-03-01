package by.javaguru.git.mergeexperience;

import java.io.*;

import by.javaguru.git.mergeexperience.topics.Module1Topics;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/module1")
public class Module1Servlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Модуль 1";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");

        out.println("<table>");
        for (Module1Topics value : Module1Topics.values()) {
            out.println("<tr><td>"
                    + value.getOrder() + "</td><td>"
                    + value.getTopic() + "</td><td>"
                    + "<span id='description-" + value.getOrder() + "' style='display: none;'>"
                    + value.getDesc()
                    + "</span></td><td><a href='#' onclick='showDescription(" + value.getOrder() + ")'>Подробнее</a>"
                    + "</td></tr>");
        }

        out.println("</table>");
        out.println(" <button>\n" +
                "   <img src=\"left.png\">\n" +
                "  </button>\n" +
                "  <button>\n" +
                "    <img src=\"right.png\"" +
                "  </button>");

        out.println("<script>");
        out.println("function showDescription(order) {");
        out.println("    var description = document.getElementById('description-' + order);");
        out.println("    if (description.style.display === 'none') {");
        out.println("        description.style.display = 'block';");
        out.println("    } else {");
        out.println("        description.style.display = 'none';");
        out.println("    }");
        out.println("}");
        out.println("</script>");

        out.println("</body></html>");
    }

    public void destroy() {
    }
}