import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


//@WebServlet(name = "HelloWorldServlet", urlPatterns = "/hello-world")
@WebServlet(name="HelloWorldServlet", urlPatterns = "/count")
public class HelloWorldServlet extends HttpServlet {

    private int hitCount;

    public void init(){
        int hitCount = 0;
    }


    protected void doGet(HttpServletRequest req, HttpServletResponse res) {
//
        res.setContentType("text/htmml");
        hitCount ++;
        PrintWriter out = null;
        try {
            out = res.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String html = "Current Count: " + hitCount;
        out.printf( html );


//        res.setContentType("text/html");
//        PrintWriter out = null;
//        try {
//            out = res.getWriter();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        out.println("<h1> Hello, World! </h1>");



    }
}
