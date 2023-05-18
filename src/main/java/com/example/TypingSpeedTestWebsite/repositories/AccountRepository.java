package com.example.TypingSpeedTestWebsite.repositories;


import com.example.TypingSpeedTestWebsite.models.Account;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("accountRepository")
public interface AccountRepository extends CrudRepository<Account, Integer>{

	@Operation(summary = "Find account by username", description = "Returns account with matched username.")
	public Account findByUsername(@Parameter(description = "Username to find by.", required = true) String username);
	
}
