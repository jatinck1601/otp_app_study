package com.otp.unit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.otp.dto.EmailUser;
import com.otp.repository.MailRepo;
import com.otp.service.MailServiceImpl;

public class EmailTest {
	
	public MailServiceImpl mail=new MailServiceImpl();

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
		boolean expected = true;
		boolean actual = service.checkEmail("xyz@.com");
		assertEquals(expected, actual);
	}

	@Test
	void testSendOTP() {
		EmailUser otp=new EmailUser(1,"5464645","jatinck16@gmail.com");
		String actual=mail.sendOTP(otp);
		String expected="Successfully Sent";
		assertEquals(expected,actual);
	}


}
