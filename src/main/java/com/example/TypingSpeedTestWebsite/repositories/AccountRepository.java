package com.example.TypingSpeedTestWebsite.repositories;


import com.example.TypingSpeedTestWebsite.models.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("accountRepository")
public interface AccountRepository extends CrudRepository<Account, Integer>{
	
	public Account findByUsername(String username);
	
	@Query("from Account where roleByRole.id = :roleId")
	public List<Account> findAllCustomer(@Param("roleId") int roleId);
	
	@Query("select count(id) from Account where roleByRole.id = 2")
	public Long countCustomer();
	
}
