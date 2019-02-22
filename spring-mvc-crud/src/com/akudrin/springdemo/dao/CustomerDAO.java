package com.akudrin.springdemo.dao;

import java.util.List;

import com.akudrin.springdemo.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();
	
	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);
	
}
