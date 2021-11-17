package com.otp.unit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.otp.repository.MailRepo;
import com.otp.service.MailServiceImpl;

@SpringBootTest
public class EmailTest {
	
	@Autowired
	public MailServiceImpl mail;

	@MockBean
	public MailRepo repo;

	@Test
	@DisplayName("Validate Email-1")
	void testCheckEmail1() {
		// fail("Not yet implemented");
		MailServiceImpl service = new MailServiceImpl();
		boolean expected = true;
		boolean actual = service.checkEmail("xyz@gmail.com");
		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("Validate Email-2")
	void testCheckEmail2() {
		// fail("Not yet implemented");
		MailServiceImpl service = new MailServiceImpl();
		boolean expected = false;
		boolean actual = service.checkEmail("xyz@.com");
		assertEquals(expected, actual);
	}

	@Test
	@DisplayName("OTP Length")
	public void generateOTP1() {
	String expected = "";
	expected = String.valueOf(mail.createOtp());
	assertTrue(expected.length() == 6);
	}

	@Test
	@DisplayName("OTP Format")
	public void generateOTP2(){
	String expected = "";
	expected = String.valueOf(mail.createOtp());
	assertTrue(expected.matches("[0-9]+"));
	}



}
