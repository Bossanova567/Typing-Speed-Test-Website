package com.example.TypingSpeedTestWebsite.services;

import com.example.TypingSpeedTestWebsite.models.Account;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AccountService extends UserDetailsService{
	
	Account findByUsername(String username);
	
	Account findById(int id);
	
	Account save(Account account);
	
}