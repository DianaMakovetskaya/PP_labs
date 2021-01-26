package laba_4.MailPackage;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendMail {

    final String username = "diana.makovetska.knm.2019@lpnu.ua";
    final String password = "18.12.2001";
    private Properties props;

    public SendMail() {
        props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
    }


    public void send(String msg){

        try {
            Session session = Session.getInstance(props,
                    new javax.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(username, password);
                        }
                    });

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("diana.makovetska.knm.2019@lpnu.ua"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("kateryna-mariia.hazhula.knm.2019@lpnu.ua"));
            message.setSubject("Testing Subject");
            message.setText("Dear Receiver,"
                    + "\n\n You have a problem: "+msg);

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

}
