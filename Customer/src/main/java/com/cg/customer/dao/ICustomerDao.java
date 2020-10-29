package com.cg.customer.dao;

import com.cg.customer.entities.Customer;

public interface ICustomerDao {
	Customer add(Customer customer);
	
	Customer update(long id,String name);

}
