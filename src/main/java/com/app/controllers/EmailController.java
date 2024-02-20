package com.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dtos.EmailDetailDTO;
import com.app.services.EmailService;

@RestController
public class EmailController {
		 
	    @Autowired 
	    private EmailService emailService;
	    @PostMapping("/sendMail")
	    public String sendMail(@RequestBody EmailDetailDTO details)
	    {
	        String status
	            = emailService.sendSimpleMail(details);
	        return status;
	    }
}
