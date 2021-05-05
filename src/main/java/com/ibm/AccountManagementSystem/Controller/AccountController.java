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
	
	@PutMapping("/employee/{accountNumber}")
	void updateBugStatus(@RequestBody @Valid Account Account, BindingResult bindingResult,@PathVariable("accountNumber") String accountNumber ) {
		validateModel(bindingResult);
		System.out.println(accountNumber);
		Account.setId(accountNumber);
		accountService.updateStatus(Account);	
	}
	
	@GetMapping("/employee")
	List<Account> getEmployees() {
		return accountService.getAccounts();
	}
	
	/**
	 * method to get details of specific employee
	 * @param employeeId
	 * @return zero or matching employee 
	 */
	
	@GetMapping("/employee/{accountNumber}")
	Optional<Account> getBug(@PathVariable("accountNumber") String accountNumber) {
		return accountService.getAccount(accountNumber);
	}
	
	
	

}
