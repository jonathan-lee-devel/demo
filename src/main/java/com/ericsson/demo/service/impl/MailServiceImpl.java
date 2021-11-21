package com.ericsson.demo.service.impl;

import com.ericsson.demo.service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MailServiceImpl implements MailService {

  private final MailSender mailSender;

  @Value("#{environment.SMTP_MAIL_USERNAME}")
  private String addressFrom;

  @Async
  @Override
  public void sendMail(final String addressTo, final String subject, final String text) {
    final SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
    simpleMailMessage.setFrom(this.addressFrom);
    simpleMailMessage.setTo(addressTo);
    simpleMailMessage.setSubject(subject);
    simpleMailMessage.setText(text);

    this.mailSender.send(simpleMailMessage);
  }

}
