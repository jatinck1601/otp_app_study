package com.otp.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.otp.dto.EmailUser;
import com.otp.emailservice.EmailSenderService;
import com.otp.entity.Email;
import com.otp.exception.InvalidOTPException;
import com.otp.exception.OTPExpireException;

import com.otp.exception.UserIDNotFoundException;
import com.otp.repository.MailRepo;

import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class MailServiceImpl implements MailService{
	@Value("${t}")
	public int time;
	@Autowired
	MailRepo repo;
	
	@Autowired
	EmailSenderService emailService;
	
	public boolean checkEmail(String email) {
	        String regex = "^\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w{2,}([-.]\\w+)*$";
	        Pattern pattern = Pattern.compile(regex);
	            Matcher matcher = pattern.matcher(email);
	            return matcher.matches();      
	        }

	@Override
	public Email generateOTP(EmailUser eml){
		// TODO Auto-generated method stub
		int otp=100000+(new Random().nextInt(900000));
		Email em=new Email(eml.getUserID(), eml.getUserOrderId(), eml.getUserEmail());
		em.setOtp(otp);
		repo.save(em);
		Email otpFind=repo.findById(eml.getUserID()).get();
		emailService.sendOtpMail(eml.getUserEmail(),"Your OTP is", em.getOtp());
		Timer t = new Timer();  
		TimerTask tt = new TimerTask()  {  
		    @Override  
		    public void run() { 
		        otpFind.setOtp(0);
		        repo.save(otpFind);
		    };  
		};  
		t.schedule(tt, time); 			
		return em;
		
	}


	@Override
	public String reGenerateOTP(int userId) throws UserIDNotFoundException {
		// TODO Auto-generated method stub
		Email otpFind=repo.findById(userId).orElseThrow(() -> new UserIDNotFoundException("Invalid UserId : " + userId));	
		int otp=100000+(new Random().nextInt(900000));
		otpFind.setOtp(otp);
		repo.save(otpFind);
		emailService.sendOtpMail(otpFind.getEmail(),"Your New OTP is", otpFind.getOtp());
		Timer t = new Timer();  
		TimerTask tt = new TimerTask()  {  
		    @Override  
		    public void run() { 
		        otpFind.setOtp(0);
		        repo.save(otpFind);
		    };  
		};  
		t.schedule(tt, time); 
		return "OTP Sent";
	}

	@Override
	public String validateOTP(Email email) throws UserIDNotFoundException, InvalidOTPException, OTPExpireException {
		// TODO Auto-generated method stub
		Email otpFind=repo.findById(email.getUserId()).orElseThrow(() -> new UserIDNotFoundException("Invalid UserId : " + email.getUserId()));
		if(otpFind.getOrderId().equals(email.getOrderId()) && otpFind.getOtp()==email.getOtp())
		{
		emailService.sendSuccessMail(otpFind.getEmail(),"Response","OTP Verified");
		return "OTP Verified";			
		}
		else if(otpFind.getOtp()==0)
		{	
			emailService.sendSuccessMail(otpFind.getEmail(),"Response","Your OTP Expired!! Please generate New OTP");
	        throw new OTPExpireException("OTP Expired!! Please generate New OTP");	        
		}
		else		
		{
			emailService.sendSuccessMail(otpFind.getEmail(),"Response","Invalid OTP");
			throw new InvalidOTPException("Invalid OTP");
		}
	}
	public int createOtp()
	{
		return (100000+(new Random().nextInt(900000)));
		
	}
	
	








}
