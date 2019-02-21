package com.akudrin.springdemo.service;

import java.util.List;

import com.akudrin.springdemo.entity.Customer;

public interface CustomerService {
	
	public List<Customer> getCustomers();
	
	public void saveCustomer(Customer theCustomer);

}
