package com.ibm.AccountManagementSystem.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.AccountManagementSystem.Service.AccountService;
import com.ibm.AccountManagementSystem.entity.Account;

@RestController
public class AccountController {
	@Autowired
	AccountService accountService;
	
	@PostMapping("/account")
	@ResponseStatus(code = HttpStatus.CREATED)
	String createBug(@RequestBody @Valid Account account, BindingResult bindingResult) {
		validateModel(bindingResult);
		System.out.println(account);
		return accountService.createAccount(account);
	}
	
	private void validateModel(Errors bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new IllegalArgumentException("Something went wrong.Please Retry!!");
		}
	}

}
