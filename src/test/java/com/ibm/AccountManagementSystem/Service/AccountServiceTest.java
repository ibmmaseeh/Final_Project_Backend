package com.ibm.AccountManagementSystem.Service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ibm.AccountManagementSystem.Repo.AccountRepository;
import com.ibm.AccountManagementSystem.entity.Account;


class AccountServiceTest {
	AccountService accountService;
	AccountRepository dummyRepo;
	Account account ;
	
	@BeforeEach
	void init(){
		accountService = new AccountService();
		dummyRepo = new DummyAccountRepository();
		accountService.setAccountRepository(dummyRepo);
		account = new Account();
	}
	
	/*
	 * method to test the createAccount method
	 */

	@Test
	void testCreateAccount() {
		String accountId = accountService.createAccount(account);
		assertNotNull(accountId);
	}
	
	/*
	 * method to test getAccountByAccountNumber
	 */

	@Test
	void testGetAccountByAccountNumber() {
		List<Account> accountList = accountService.getAccounts();  
		assertNotNull(accountList);
	}
	
	/*
	 * method to test getAccounts method
	 */
	
	@Test
	void testGetAccounts() {
		List<Account> accountList = accountService.getAccounts();  
		assertNotNull(accountList);
 		assertEquals("234fdserg34", accountList.get(0).getId());
	}

}
