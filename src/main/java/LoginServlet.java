import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

//    DO GET==========================================
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Session Object
        HttpSession ses = request.getSession();

//        Default Value for user
        if(ses.getAttribute("user") == null){
            ses.setAttribute("user", false);
        }

//        Convert to Boolean
        Boolean user = (Boolean) ses.getAttribute("user");


//        Checking to see if I let the user see the login page or toss em
        if(user){
            response.sendRedirect("/profile");
        } else {
            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
    }



//    DO POST============================================
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        Session Object
        HttpSession ses = request.getSession();

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean validAttempt = username.equals("admin") && password.equals("password");

        if (validAttempt) {
            ses.setAttribute("user", true);
            ses.setAttribute("username", username);
            response.sendRedirect("/profile");
        } else {
            response.sendRedirect("/login");
        }
    }
}
