package com.otp.service;

import org.springframework.stereotype.Service;

import com.otp.dto.EmailUser;
import com.otp.entity.Email;
import com.otp.exception.InvalidOTPException;
import com.otp.exception.OTPExpireException;
import com.otp.exception.UserIDNotFoundException;




@Service
public interface MailService {
	public Email generateOTP(EmailUser eml);
	public String reGenerateOTP(int userId) throws UserIDNotFoundException;
	public String validateOTP(Email email) throws UserIDNotFoundException,InvalidOTPException,OTPExpireException;

}
