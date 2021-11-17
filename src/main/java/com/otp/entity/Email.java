package com.otp.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Email {
	@Id
	private int userId;
	private String orderId;
	private int otp;
	private String email;
	public Email(int userId, String orderId, String email) {
		super();
		this.userId = userId;
		this.orderId = orderId;
		this.email = email;
	}	
}
