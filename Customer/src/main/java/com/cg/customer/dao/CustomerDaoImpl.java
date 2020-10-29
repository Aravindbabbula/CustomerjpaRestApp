package com.cg.customer.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.cg.customer.entities.Customer;
import com.cg.customer.exceptions.*;

import java.util.*;

@Repository
public class CustomerDaoImpl implements ICustomerDao {

	private Map<Long, Customer> store = new HashMap<>();

	private long generatedId;

	long generateId() {
		++generatedId;
		return generatedId;
	}

	@Override
	public Customer add(Customer customer) {
		long id = generateId();
		customer.setId(id);
		store.put(id, customer);
		return customer;
	}
	
	@Override
	public Customer update(long id,String name) {
		Customer customer=store.get(id);
		customer.setName(name);
		store.put(id, customer);
		return customer;
	}
	
}
