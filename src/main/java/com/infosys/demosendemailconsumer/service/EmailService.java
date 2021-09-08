package com.infosys.demosendemailconsumer.service;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
@AllArgsConstructor
public class EmailService {

    private final static Logger LOGGER = LoggerFactory.getLogger(EmailService.class);

    private final JavaMailSender mailSender;


    @Async
    public void send(){
        File file = new File("E:\\krs.pdf");
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
            helper.setText("Testing rabbit mq");
            helper.setTo("test@gmail.com");
            helper.setSubject("Testing send email");
            helper.setFrom("shudulhaq123@gmail.com");
            helper.addAttachment("krs1.pdf", file);
            helper.addAttachment("krs2.pdf", file);
            helper.addAttachment("krs3.pdf", file);
            mailSender.send(mimeMessage);

        }catch (MessagingException e){
            LOGGER.error("failed to send email", e);
            throw new IllegalStateException("failed to send email");
        }
    }
}
