package org.hacker;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

/**
 * User: Hikmat Dhamee
 * Date: 4/18/14
 * Time: 11:47 AM
 * Servlet to send mail anonymously
 */
public class SendHackerMail extends HttpServlet {

    private String message;

    public void init() throws ServletException {
        // Do required initialization
        message = "Hello World";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Sender's email ID needs to be mentioned
        String from = request.getParameter("from_addr").toString();

        // Recipient's email ID needs to be mentioned.
        String to = request.getParameter("to_addr").toString();

        // Assuming you are sending email from localhost
        String host = request.getParameter("smtp_host").toString();

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        // properties.put("mail.smtp.auth", "false");
        // properties.put("mail.smtp.starttls.enable", "false");
        properties.setProperty("mail.smtp.host", host);
        properties.put("mail.debug", "true");
        // properties.setProperty("mail.smtp.port", "21");

        // Get the default Session object.
        Session session = Session.getDefaultInstance(properties);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);
            message.setSentDate(new Date());
            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from, "Hack Done"));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(to, "Hikmat Dhamee"));

            // Set Subject: header field
            message.setSubject(message.toString());

            // Now set the actual message
            message.setText(":-----)\n....:...)");

            // Send message
            Transport.send(message);

            // Set response content type
            response.setContentType("text/html");
            // Actual logic goes here.
            PrintWriter out = response.getWriter();
            out.println("<h1>" + "Sent message successfully...."+ "</h1>");

        } catch (MessagingException mex) {
            mex.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

    public void destroy() {
        // do nothing.
    }


}
