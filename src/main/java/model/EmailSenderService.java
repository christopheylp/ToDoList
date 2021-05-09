package model;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class EmailSenderService {

    public static void sendEmail(String [] args) {
        String to = "abcd@gmail.com";

        String from = "web@gmail.com";

        String host = "localhost";

        Properties properties = System.getProperties();

        properties.setProperty("mail.smtp.host", host);

        Session session = Session.getDefaultInstance(properties);

        try {
            MimeMessage message = new MimeMessage(session);

            message.setFrom(new InternetAddress(from));

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            message.setSubject("To Do List limit almost reach!");

            message.setText("You already have 8 items in your ToDoList, you can only add 10 items in total");

            // Send message
            Transport.send(message);
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}