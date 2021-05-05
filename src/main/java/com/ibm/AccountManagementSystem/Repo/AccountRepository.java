package com.ibm.AccountManagementSystem.Repo;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.ibm.AccountManagementSystem.entity.Account;

public interface AccountRepository extends MongoRepository<Account, String> {

	@Query("{'accountNumber':?0}")
	Optional<Account> findByAccountNumber(String accountNumber);
	
}
