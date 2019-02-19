package com.akudrin.springdemo.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akudrin.springdemo.dao.CustomerDAO;
import com.akudrin.springdemo.entity.Customer;
@Service
public class CustomerServiceImpl implements CustomerService {

	//need to inject customer DAO
	@Autowired
	private CustomerDAO customerDAO;
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return customerDAO.getCustomers();
	}

}
