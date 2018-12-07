import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "HelloWorldServlet", urlPatterns = "/hello-world")
public class HelloWorldServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) {

        res.setContentType("text/html");
        PrintWriter out = null;
        try {
            out = res.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        out.println("<h1> Hello, World! </h1>");
    }
}
