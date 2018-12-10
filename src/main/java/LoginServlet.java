import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {


//    DoGet
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        req.setAttribute("title", "Login");
        req.getRequestDispatcher("login.jsp").forward(req, res);

    }

//    DoPost
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException{
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if(username.equals("admin") && password.equals("password")){
            res.sendRedirect("/profile");
        } else {
            res.sendRedirect("/login");
        }
    }
}
