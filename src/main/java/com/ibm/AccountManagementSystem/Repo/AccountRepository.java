package com.ibm.AccountManagementSystem.Repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ibm.AccountManagementSystem.entity.Account;

public interface AccountRepository extends MongoRepository<Account, String> {
	
}
