package com.otp.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.otp.entity.Email;

@Repository
public interface MailRepo extends JpaRepository<Email, Integer>{
	

}
