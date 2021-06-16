package springbootserver.model;

public class EmailSenderService {

    public static boolean sendEmail() {
        String to = "abcd@gmail.com";

        String from = "web@gmail.com";

        String host = "localhost";
        /*
        Properties properties = System.getProperties();
        Session session = Session.getDefaultInstance(properties);
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("To Do List limit almost reach!");
            message.setText("You already have 8 items in your ToDoList, you can only add 10 items in total");
            Transport.send(message);
            return true;
        } catch (MessagingException mex) {
            mex.printStackTrace();
            return false;
        }*/
        return true;
    }


}