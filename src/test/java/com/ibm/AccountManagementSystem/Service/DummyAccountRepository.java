package com.ibm.AccountManagementSystem.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.ibm.AccountManagementSystem.Repo.AccountRepository;
import com.ibm.AccountManagementSystem.entity.Account;


public class DummyAccountRepository implements AccountRepository {

	@Override
	public List<Account> findAll() {
		List<Account> accounts = new ArrayList<Account>();
		Account account = new Account();
		Account account1 = new Account();
		account.setId("234fdserg34");
		accounts.add(account);
		account1.setId("24398t84gb32oi");
		accounts.add(account1);
		return accounts ;
	}

	@Override
	public List<Account> findAll(Sort arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Account> List<S> findAll(Example<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Account> List<S> findAll(Example<S> arg0, Sort arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Account> S insert(S arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Account> List<S> insert(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Account> List<S> saveAll(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Account> findAll(Pageable arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(Account arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll(Iterable<? extends Account> arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(String arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean existsById(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Account> findAllById(Iterable<String> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Account> findById(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account  save(Account account ) {
		account.setId("234fdserg34");
		account.setAccountNumber("11223344");
		return account;
	}

	@Override
	public <S extends Account> long count(Example<S> arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Account> boolean exists(Example<S> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <S extends Account> Page<S> findAll(Example<S> arg0, Pageable arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Account> Optional<S> findOne(Example<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Account> findByAccountNumber(String accountNumber) {
		List<Account> accounts = new ArrayList<Account>();
		Account account = new Account();
		Account account1 = new Account();
		account.setId("234fdserg34");
		account.setAccountNumber("1122334455");
		accounts.add(account);
		account.setId("23456fdgfdg");
		account1.setAccountNumber("2244668800");;
		accounts.add(account1);
		return accounts ;
	}

}
