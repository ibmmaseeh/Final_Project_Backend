package com.ibm.AccountManagementSystem.Controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
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

	private void validateModel(Errors bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new IllegalArgumentException("Something went wrong.Please Retry!!");
		}
	}

	@PostMapping("/employee")
	@ResponseStatus(code = HttpStatus.CREATED)
	String createAccount(@RequestBody @Valid Account account, BindingResult bindingResult) {
		validateModel(bindingResult);
		System.out.println(account);
		return accountService.createAccount(account);
	}

	@PutMapping("/employee/{id}")
	void updateStatus(@RequestBody @Valid Account account, BindingResult bindingResult,
			@PathVariable("id") String accountId) {
		validateModel(bindingResult);
		System.out.println(accountId);
		account.setId(accountId);
//		Account.setStatus(status);

		accountService.updateStatus(account);
	}

	@GetMapping("/employee")
	List<Account> getAccounts() {
		return accountService.getAccounts();
	}

	@GetMapping("/employee/{accountNumber}")
	List<Account> getAccount(@PathVariable("accountNumber") String accountNumber) {
		return accountService.getAccountByAccountNumber(accountNumber);
	}

	@PutMapping("/customer/{id}")
	void updateDetails(@RequestBody @Valid Account account, BindingResult bindingResult,
			@PathVariable("id") String accountId) {
		validateModel(bindingResult);
		System.out.println(accountId);
		account.setId(accountId);
		accountService.updateDetails(account);
	}

	@GetMapping("/customer/{accountNumber}")
	List<Account> getAccountDetails(@PathVariable("accountNumber") String accountNumber) {
		return accountService.getAccountByAccountNumber(accountNumber);
	}

	@PutMapping("/customer/transaction/withdraw/{id}/{amount}")
	void withdraw(@RequestBody @Valid Account account, BindingResult bindingResult,
			@PathVariable("id") String accountId, @PathVariable("amount") float amount) {
		account.setId(accountId);
		if (account.getBalance() < amount) {
			throw new IllegalArgumentException("Insuffcient balance!");
		} else {
			float remainingBalance = account.getBalance() - amount;
			account.setBalance(remainingBalance);
		}
		accountService.transaction(account);
	}

	@PutMapping("/customer/transaction/deposit/{id}/{amount}")
	void deposit(@RequestBody @Valid Account account, BindingResult bindingResult, @PathVariable("id") String accountId,
			@PathVariable("amount") float amount) {
		account.setId(accountId);
		float remainingBalance = account.getBalance() + amount;
		account.setBalance(remainingBalance);
		accountService.transaction(account);
	}

}
