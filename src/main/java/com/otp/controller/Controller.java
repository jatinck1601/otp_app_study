package com.otp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.otp.dto.EmailUser;
import com.otp.entity.Email;
import com.otp.exception.InvalidOTPException;
import com.otp.exception.OTPExpireException;

import com.otp.exception.UserIDNotFoundException;
import com.otp.service.MailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api")
public class Controller {
	
	@Autowired
	MailService service;
	private static final Logger LOGGER = LoggerFactory.getLogger(Controller.class);
	
	@PostMapping("/generateOTP")
	public ResponseEntity<Email> generateOTP(@RequestBody EmailUser email)
	{
		LOGGER.info("An INFO Message");
		Email eml = service.generateOTP(email);
		return new ResponseEntity<Email>(eml, HttpStatus.CREATED);
	}
	
	@PostMapping("/validateOTP")
	public String validateOTP(@RequestBody Email email) throws UserIDNotFoundException,InvalidOTPException,OTPExpireException
	{
		return service.validateOTP(email);
		
	}
	@PostMapping("/reGenerateOTP/{userId}")
	public String reGenerateOTP(@PathVariable int userId) throws UserIDNotFoundException
	{
		return service.reGenerateOTP(userId);
		
	}

}
