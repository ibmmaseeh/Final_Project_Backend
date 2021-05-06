package com.ibm.AccountManagementSystem.Repo;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.ibm.AccountManagementSystem.entity.Account;

public interface AccountRepository extends MongoRepository<Account, String> {

    @Query("{'accountNumber':?0}")
	List<Account> findByAccountNumber(String accountNumber);

}
