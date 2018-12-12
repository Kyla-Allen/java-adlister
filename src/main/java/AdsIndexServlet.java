import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AdsIndexServlet", urlPatterns = "/ads")
public class AdsIndexServlet extends HttpServlet {

//    DOGET
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        Ads adsDao = DaoFactory.getAdsDao();
        req.setAttribute("ads", adsDao.all());
        req.getRequestDispatcher("ads/index.jsp").forward(req,res);
    }

}
