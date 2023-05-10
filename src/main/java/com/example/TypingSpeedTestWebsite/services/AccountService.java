package com.example.TypingSpeedTestWebsite.services;

import org.springframework.security.core.userdetails.UserDetailsService;
import com.example.TypingSpeedTestWebsite.models.Account;

import java.util.List;

public interface AccountService extends UserDetailsService{
	
	public Account findByUsername(String username);
	
	public Account findById(int id);
	
	public Account save(Account account);
	
}