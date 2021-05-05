package com.ibm.AccountManagementSystem.Controller;

import java.util.List;
import java.util.Optional;

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
import com.ibm.AccountManagementSystem.entity.STATUS;


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
	String createBug(@RequestBody @Valid Account account, BindingResult bindingResult) {
		validateModel(bindingResult);
		System.out.println(account);
		return accountService.createAccount(account);
	}
	
	@PutMapping("/employee/{id}")
	void updateBugStatus(@RequestBody @Valid Account Account, BindingResult bindingResult,@PathVariable("id") String accountId ) {
		validateModel(bindingResult);
		System.out.println(accountId);
		Account.setId(accountId);
		accountService.updateStatus(Account);	
	}
	
	@GetMapping("/employee")
	List<Account> getAccounts() {
		return accountService.getAccounts();
	}
	
	
	@GetMapping("/employee/{accountNumber}")
	Optional<Account> getAccount(@PathVariable("accountNumber") String accountNumber) {
		return accountService.getAccountByAccountNumber(accountNumber);
	}
	
	
	

}
