package com.ibm.AccountManagementSystem.Controller;

import java.util.List;
import java.util.logging.*;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.AccountManagementSystem.Service.AccountService;
import com.ibm.AccountManagementSystem.entity.Account;


@RestController
public class AccountController {
	@Autowired
	AccountService accountService;
    
	Logger logger
    = Logger.getLogger(AccountController.class.getName());

	private void validateModel(Errors bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new IllegalArgumentException("Something went wrong.Please Retry!!");
		}
	}

	/**
	 * method to create new account of the customer by the employee
	 * @param account
	 * @param bindingResult
	 * @return newly created account object
	 */
	@CrossOrigin
	@PostMapping("/employee")
	@ResponseStatus(code = HttpStatus.CREATED)
	String createAccount(@RequestBody @Valid Account account, BindingResult bindingResult) {
		validateModel(bindingResult);
		logger.log(Level.INFO,account.toString());
//		System.out.println(account);
		return accountService.createAccount(account);
	}

	/**
	 * method to update the specific account
	 * @param account
	 * @param bindingResult
	 * @param accountId
	 */
	@CrossOrigin
	@PutMapping("/employee/{id}")
	void updateStatus(@RequestBody @Valid Account account, BindingResult bindingResult,
			@PathVariable("id") String accountId) {
//		validateModel(bindingResult);
		logger.log(Level.INFO,accountId);
//		System.out.println(accountId);
		account.setId(accountId);
//		Account.setStatus(status);

		accountService.updateStatus(account);
	}

	/**
	 * method to get all the accounts 
	 * @return all the accounts in the database
	 */
	@CrossOrigin
	@GetMapping("/employee")
	List<Account> getAccounts() {
		logger.info("All accounts are listed");
		return accountService.getAccounts();
	}
	
	/**
	 * method to return specific account details
	 * @param accountNumber
	 * @return details of the specific account details
	 */
	@CrossOrigin
	@GetMapping("/employee/{accountNumber}")
	List<Account> getAccount(@PathVariable("accountNumber") String accountNumber) {
		logger.log(Level.INFO,"Details listed for account number "+accountNumber);
		return accountService.getAccountByAccountNumber(accountNumber);
	}
	
	/**
	 * method to update the customer details by the customer
	 * @param account
	 * @param bindingResult
	 * @param accountId
	 */
	@CrossOrigin
	@PutMapping("/customer/{id}")
	void updateDetails(@RequestBody @Valid Account account, BindingResult bindingResult,
			@PathVariable("id") String accountId) {
		//validateModel(bindingResult);
//		System.out.println(accountId);
		logger.log(Level.INFO," Customer details updated");
		account.setId(accountId);
		accountService.updateDetails(account);
	}

	/**
	 * method to get the details of the specific customer account
	 * @param accountNumber
	 * @return details of the account by specifying the account details
	 */
	@CrossOrigin
	@GetMapping("/customer/{accountNumber}")
	List<Account> getAccountDetails(@PathVariable("accountNumber") String accountNumber) {
		logger.info("Details listed for account number "+accountNumber);
		return accountService.getAccountByAccountNumber(accountNumber);
	}

	/**
	 * method to perform the customer withdrawl
	 * @param account
	 * @param accountId
	 */
	@PutMapping("/customer/withdraw/{id}")
	void withdraw(@RequestBody @Valid Account account, @PathVariable("id") String accountId) {
//		if (account.getBalance() < amount) {
//			throw new IllegalArgumentException("Insuffcient balance!");
//		} else {
//			float remainingBalance = account.getBalance() - amount;
//			account.setBalance(remainingBalance);
//		}
		//System.out.println(accountId);
		logger.log(Level.INFO,accountId);
		account.setId(accountId);
		accountService.updateDetails(account);
	}

	/**
	 * method to perform the customer deposit
	 * @param account
	 * @param bindingResult
	 * @param accountId
	 */
	@PutMapping("/customer/deposit/{id}")
	void deposit(@RequestBody @Valid Account account, BindingResult bindingResult, @PathVariable("id") String accountId) {
		// System.out.println(accountId);
		logger.log(Level.INFO,accountId);
		account.setId(accountId);
		accountService.updateDetails(account);
		 
	}

}
