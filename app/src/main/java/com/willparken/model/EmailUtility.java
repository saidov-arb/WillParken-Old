package com.willparken.model;


import android.os.StrictMode;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailUtility {

    private int port;

    private String password;

    private String senderEmail;

    public EmailUtility() {

        port = 587;
        //Generated Password for willparken@gmail.com
        //Bitte nicht misshandeln (nicht in Schleife Mails senden), wäre Ehrenlos
        password = "sqixurmjzdaumjik";
        senderEmail = "willparken@gmail.com";
    }

    //Konstruktor falls es eine andere E-Mail gibt, mit der wir die Daten absenden wollen.
    public EmailUtility(int port, String password, String senderEmail) {

        this.port = port;

        this.password = password;

        this.senderEmail = senderEmail;
    }


    public void sendMail(String to, String subject, String content) {

        //In Case the Network Configurations restrict sending an E-Mail, this Code permits all
        StrictMode.ThreadPolicy gfgPolicy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(gfgPolicy);

        //Just some properties needed to create a session
        Properties props = new Properties();

        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", port);

        //Authenticate with the Mail Server and save the Instance in session
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(senderEmail, password);
                    }
                });

        try {

            //MimeMessage helps creating an E-Mail on a session
            MimeMessage message = new MimeMessage(session);

            message.setFrom(new InternetAddress(senderEmail));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(subject);
            message.setText(content);

            //Transport sends the Message via the session to the smtp Server
            Transport.send(message);

        } catch (MessagingException exc) {
            exc.printStackTrace();
            throw new RuntimeException(exc);
        }
    }
}