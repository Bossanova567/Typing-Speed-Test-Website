package com.example.TypingSpeedTestWebsite.services;

import com.example.TypingSpeedTestWebsite.models.Account;
import com.example.TypingSpeedTestWebsite.repositories.AccountRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service("accountService")
@Transactional
public class AccountServicesImpl implements AccountService{
	
	@Autowired
	private AccountRepository accountRepository;

	@Operation(summary = "Load user by username", description = "Loads user by username.")
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account account = accountRepository.findByUsername(username);
		if (account == null) {
			throw new UsernameNotFoundException("Username not found for " + username);
		}
		List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
		grantedAuthorities.add(new SimpleGrantedAuthority(account.getRoleByRole().getName()));
		return new User(account.getUsername(), account.getPassword(), grantedAuthorities);
	}

	@Operation(operationId = "Find by username", summary = "Find By Username Implementation", description = "Returns account with matched username using AccountRepository.")
	@Override
	public Account findByUsername(@Parameter(description = "Username to find by.", required = true) String username) {
		return accountRepository.findByUsername(username);
	}

	@Operation(summary = "Save account", description = "Is used to save an account, returns saved account using CrudRepository.")
	@Override
	public Account save(@Parameter(description = "Account to be saved.", required = true) Account account) {
		return accountRepository.save(account);
	}

	@Operation(summary = "Find account by id", description = "Returns account with matched id using AccountRepository.")
	@Override
	public Account findById(@Parameter(description = "Id to find by.", required = true) int id) {
		return accountRepository.findById(id).get();
	}

}
