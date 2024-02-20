package com.app.services;

import com.app.dtos.EmailDetailDTO;

public interface EmailService {

    String sendSimpleMail(EmailDetailDTO details);
    String sendMailWithAttachment(EmailDetailDTO details);
}
