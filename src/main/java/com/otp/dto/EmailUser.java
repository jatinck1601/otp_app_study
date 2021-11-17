package com.otp.dto;

import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailUser {
	@Id
	private int userID;
	private String userOrderId;
	private String userEmail;
	
}
