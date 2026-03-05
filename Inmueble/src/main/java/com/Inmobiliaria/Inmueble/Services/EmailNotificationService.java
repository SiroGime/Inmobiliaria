package com.Inmobiliaria.Inmueble.Services;

import com.Inmobiliaria.Inmueble.Models.Lead;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailNotificationService {

    private final JavaMailSender mailSender;

    @Value("${app.notifications.to}")
    private String notifyTo;

    public EmailNotificationService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void notifyNewLead(Lead lead) {
        System.out.println(">>> ENTRANDO A notifyNewLead");

        SimpleMailMessage msg = new SimpleMailMessage();
        //msg.setFrom("romanolo2000@gmail.com");
        msg.setTo(notifyTo);
        msg.setSubject("Nuevo lead para inmueble #" + lead.getInmuebleId());
        msg.setText(
                "Se recibió una nueva consulta.\n\n" +
                "Nombre: " + lead.getNombre() + "\n" +
                "Email: " + lead.getEmail() + "\n" +
                "Teléfono: " + (lead.getTelefono() == null ? "-" : lead.getTelefono()) + "\n" +
                "Mensaje: " + (lead.getMensaje() == null ? "-" : lead.getMensaje()) + "\n" +
                "Fecha: " + lead.getFechaCreacion()
        );

        mailSender.send(msg);

        System.out.println(">>> EMAIL ENVIADO");
    }
}