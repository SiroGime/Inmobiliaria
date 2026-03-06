package com.Inmobiliaria.Inmueble.Services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.context.event.EventListener;

@Service
public class EmailNotificationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmailNotificationService.class);

    private final JavaMailSender mailSender;

    @Value("${app.notifications.to}")
    private String notifyTo;

    public EmailNotificationService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Async
    @EventListener
    public void notifyNewLead(LeadCreatedEvent event) {
        var lead = event.lead();
        
        try {
            SimpleMailMessage msg = new SimpleMailMessage();
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
            LOGGER.info("Notificación de lead enviada. leadId={}", lead.getId());
        } catch (Exception ex) {
            LOGGER.error("No se pudo enviar la notificación del lead. leadId={}", lead.getId(), ex);
        }
    }
}