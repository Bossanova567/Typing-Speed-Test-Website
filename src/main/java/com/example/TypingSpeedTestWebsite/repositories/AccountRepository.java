package com.example.TypingSpeedTestWebsite.repositories;


import com.example.TypingSpeedTestWebsite.models.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("accountRepository")
public interface AccountRepository extends CrudRepository<Account, Integer>{

	Account findByUsername(String username);
	
}
