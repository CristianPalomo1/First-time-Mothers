/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.mothersApp.controller;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
/**
 *
 * @author Jennyfer Nase
 */
public class EmailService {
    private static final String REMITENTE = "jennyfernase10@gmail.com"; 
    private static final String PASSWORD = "jjetmpzrkslpbuhl"; 

    public static void enviarNotificacionRegistro(String correoDestino, String nombreUsuario) {
        Thread hiloEmail = new Thread(() -> {
            try {
                Properties props = new Properties();
                props.put("mail.smtp.host", "smtp.gmail.com");
                props.put("mail.smtp.port", "587");
                props.put("mail.smtp.auth", "true");
                props.put("mail.smtp.starttls.enable", "true");
                props.put("mail.smtp.ssl.protocols", "TLSv1.2");
                props.put("mail.debug", "true"); 

                Session session = Session.getInstance(props, new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(REMITENTE, PASSWORD);
                    }
                });

                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(REMITENTE));
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(correoDestino));
                
                message.setSubject(" ¡Bienvenida a MothersApp, " + nombreUsuario );

                String texto = "¡Hola " + nombreUsuario + "!\n\n"
                    + "¡Nos alegra muchísimo darte la bienvenida a MothersApp!\n\n"
                    + "\"Ser mamá es el comienzo de la aventura más hermosa de tu vida. "
                    + "Queremos acompañarte, apoyarte y cuidar de ti y de tu bebé en cada paso de este camino.\"\n\n"
                    + "Tu registro se ha completado con éxito.\n\n"
                    + "Con todo nuestro cariño,\n"
                    + "El equipo de MothersApp";

               message.setText(texto);

                Transport.send(message);
                System.out.println(" CORREO ENVIADO CORRECTAMENTE A: " + correoDestino);

            } catch (Exception e) {
                System.err.println(" ERROR AL ENVIAR CORREO:");
                e.printStackTrace();
            }
        });
        
        hiloEmail.start();
    }
}