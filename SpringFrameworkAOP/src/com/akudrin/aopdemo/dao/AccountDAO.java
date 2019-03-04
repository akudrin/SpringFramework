package com.akudrin.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.akudrin.aopdemo.Account;

@Component
public class AccountDAO {

	public void addAccount(Account theAccount, boolean vip) {
		
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
		
	}
}
