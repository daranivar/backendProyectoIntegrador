package com.example.BackendProyIntegrador.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {


    @Autowired
    private JavaMailSender javaMailSender;

    public void enviarMailConfirmacion(String to, String confirmationLink, String username, String email){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("Confirmaciòn de Registro");
        message.setText("Gracias por registrarte. \nTu Usuario es:  " + username  + "\nTu dirección de mail es: " + email + " \nPor favor, haz clic en el siguiente enlace para ingresar al sitio: " + confirmationLink);

        javaMailSender.send(message);
    }
}
