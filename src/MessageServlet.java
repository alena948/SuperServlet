import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import javax.mail.*;

/**
 * Created by Алёна on 12.03.2017.
 */
@WebServlet(name = "MessageServlet")
public class MessageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        StringBuilder builder = new StringBuilder("<html>");
        String to = request.getParameter("email");// sender? email
        String text = request.getParameter("text");

        final String from = "alenabaranova948@gmail.com";// receiver? email
        String host = "127.0.0.1";// mail server host
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);

        Session session = Session.getDefaultInstance(properties); // default session

        try {
            MimeMessage message = new MimeMessage(session); // email message
            message.setFrom(new InternetAddress(from)); // setting header fields
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("Test Mail from Java Program"); // subject line
            // actual mail body
            message.setText(text);
            // Send message
            Transport.send(message);
            builder.append("<h1>Email Sent successfully...<br/></h1>");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
        builder.append("</html>");
        out.println(builder);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
