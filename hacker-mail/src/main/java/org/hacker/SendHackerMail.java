package org.hacker;

import java.io.UnsupportedEncodingException;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

/**
 * User: hdhamee
 * Date: 4/1/14
 * Time: 4:33 PM
 */
// File Name SendEmail.java

public class SendHackerMail
{
    /**
     * Send mail
     * @param args
     */
    public static void main(String [] args)      {

        if(args.length<3){
            System.out.println("USAGE: java -jar target/hacker-mail-1.0 from-addr to-addr smtp-host");
            System.exit(1);
        }
        // Sender's email ID needs to be mentioned
        String from = args[0];

        // Recipient's email ID needs to be mentioned.
        String to = args[1];

        // Assuming you are sending email from localhost
        String host = args[2];

        // Get system properties
        Properties properties = System.getProperties();

       // Setup mail server
       // properties.put("mail.smtp.auth", "false");
       // properties.put("mail.smtp.starttls.enable", "false");
        properties.setProperty("mail.smtp.host", host);
        properties.put("mail.debug", "false");
       // properties.setProperty("mail.smtp.port", "21");

       // Get the default Session object.
        Session session = Session.getDefaultInstance(properties);

        try{
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);
            message.setSentDate(new Date());
            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from,"Chem Jong"));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(to,"You"));

            // Set Subject: header field
            message.setSubject("Hey, How are your. Please contact me");

            // Now set the actual message
            message.setText(":-----)\n....:...)");

            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        }catch (MessagingException mex) {
            mex.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}