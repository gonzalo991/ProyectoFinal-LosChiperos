
package Mail;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

public class Mail {
    public static void enviarMail(String asunto, String cuerpo, String email){
        String correoEnvia = "chiperosutn@gmail.com";
        String contrasena = "crtlfuatohxogwwp";
        Properties propiedad = new Properties();

        propiedad.setProperty("mail.smtp.host", "smtp.gmail.com");
        propiedad.put("mail.smtp.ssl.trust", "*");
        propiedad.setProperty("mail.smtp.starttls.enable", "true");
        propiedad.setProperty("mail.smtp.port", "25");
        propiedad.setProperty("mail.smtp.user", correoEnvia);
        propiedad.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");        
        propiedad.setProperty("mail.smtp.auth","true");
        

        
        Session sesion = Session.getDefaultInstance(propiedad);
        
        //String receptor = "";//mail destinatario
        //String asunto = "";//asunto
        //String mensaje="";//cuerpo;
        
        MimeMessage mail = new MimeMessage(sesion);
        try {
            mail.setFrom(new InternetAddress (correoEnvia));
            mail.setRecipient(Message.RecipientType.TO, new InternetAddress (email));
            //mail.addRecipient(Message.RecipientType.TO, new InternetAddress (email));
            mail.setSubject(asunto);
            mail.setText(cuerpo);
            
            Transport transportar = sesion.getTransport("smtp");
            transportar.connect(correoEnvia,contrasena);
            transportar.sendMessage(mail, mail.getRecipients(Message.RecipientType.TO));          
            transportar.close();
            
            JOptionPane.showMessageDialog(null, "Listo, revise su correo");
            
            
        } catch (AddressException ex) {
            System.out.println(ex);
        } catch (MessagingException ex) {
             System.out.println(ex);
        }
        }
}
