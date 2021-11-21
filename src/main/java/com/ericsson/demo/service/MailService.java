package com.ericsson.demo.service;

public interface MailService {

  void sendMail(final String addressTo, final String subject, final String text);

}
