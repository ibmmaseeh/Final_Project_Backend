package com.ibm.AccountManagementSystem.Service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.AccountManagementSystem.Repo.AccountRepository;
import com.ibm.AccountManagementSystem.entity.Account;

@Service
public class AccountService  {
	@Autowired
	AccountRepository accountRepository;

	public String createAccount(@Valid Account account) {
		accountRepository.save(account);
		return account.getId();
	}
}
