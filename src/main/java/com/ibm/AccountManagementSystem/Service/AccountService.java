package com.ibm.AccountManagementSystem.Service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.AccountManagementSystem.Repo.AccountRepository;
import com.ibm.AccountManagementSystem.entity.Account;
import com.ibm.AccountManagementSystem.entity.STATUS;


@Service
public class AccountService  {
	@Autowired
	AccountRepository accountRepository;

	public String createAccount(@Valid Account account) {
		accountRepository.save(account);
		return account.getId();
	}

	
	public void updateStatus(@Valid Account account) {
		accountRepository.save(account);
		}


	public List<Account> getAccountByAccountNumber(String accountNumber) {
		return accountRepository.findByAccountNumber(accountNumber);
	}


	public List<Account> getAccounts() {
		return accountRepository.findAll();
	}


	public void updateDetails(@Valid Account account) {
		STATUS oldstatus= account.getStatus();
		
		accountRepository.save(account);
	
	}


	public void transaction(Account account) { 
		accountRepository.save(account);
		
		
		
		
	}
		
	
}
