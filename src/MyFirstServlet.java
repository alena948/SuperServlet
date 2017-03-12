import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Алёна on 08.03.2017.
 */
@WebServlet(name = "MyFirstServlet")
public class MyFirstServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        final String truePassword = "password";
        String inputPassword = req.getParameter("password");
        PrintWriter out = resp.getWriter();
        StringBuilder builder = new StringBuilder("<html>");

        if (inputPassword.compareTo(truePassword) == 0) {
            builder.append("<h2>Hello, " + login + "!" + "<br/>");
            builder.append("<br>Your password ->" + inputPassword + "</h2>");
        } else
            builder.append("<h2>Incorrect password! :(<br/>");
        builder.append("</html>");
        out.println(builder);
    }
}
