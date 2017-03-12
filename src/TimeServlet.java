import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * Created by Алёна on 12.03.2017.
 */
@WebServlet(name = "TimeServlet")
public class TimeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        StringBuilder builder = new StringBuilder("<html>");
        Date date = new Date();
        String userAgent = request.getHeader("User-Agent");

        builder.append("<h1>Date and time: <br/></h1><h2><br>" + date + "<br/></h2>");
        builder.append("<h1><br>User-agent: <br/></h1>");
        builder.append("<h2><br>" + userAgent + "<br/></h2>");
        builder.append("</html>");
        out.println(builder);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
        //response.sendRedirect("TimeServletPage.html");
    }
}
