package com.sapient.flixme.service;

import com.sapient.flixme.dao.CustomerDao;
import com.sapient.flixme.dao.CustomerDaoHashMapImpl;
import com.sapient.flixme.dao.DaoException;
import com.sapient.flixme.entity.Customer;
import com.sapinet.flixme.util.KeyboardUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomerService {

	private CustomerDao dao = new CustomerDaoHashMapImpl();

	public Customer login(String email, String password) throws ServiceException {
		try {
			Customer c = dao.findByEmail(email);
			if (c == null) {
				throw new ServiceException("Invalid email/password");
			}
			if (c.getPassword().equals(password)) {
				return c;
			} else {
				throw new ServiceException("Invalid email/password");
			}

		} catch (DaoException e) {
			log.warn("Exception while calling login", e);
			throw new ServiceException(e);
		}
	}

	public void selfRegistration() throws ServiceException {
//		   Integer id;
		Customer c = new Customer();
		String name = KeyboardUtil.getString("Enter full name: ");
		if(!(name.isEmpty())) {
			c.setName(name);
		}
		
		String email = KeyboardUtil.getString("Enter email: ");
		if(!(email.isEmpty())) {
			
		}
		c.setEmail(email);
		String password = KeyboardUtil.getString("Enter password: ");
		if(!(password.isEmpty())) {
			
		}
		c.setPassword(password);
		String street = KeyboardUtil.getString("Enter street: ");
		if(!(street.isEmpty())) {
			
		}
		c.setStreet(street);
		String city = KeyboardUtil.getString("Enter city: ");
		if(!(city.isEmpty())) {
			
		}
		c.setCity(city);
		String state = KeyboardUtil.getString("Enter state: ");
		if(!(state.isEmpty())) {
			
		}
		c.setState(state);
		String pincode = KeyboardUtil.getString("Enter pincode: ");
		if(!(pincode.isEmpty())) {
			
		}
		c.setPincode(pincode);
		String country = KeyboardUtil.getString("Enter country: ");
		if(!country.isEmpty()) {
			
		}
		c.setCountry(country);
		double balance = KeyboardUtil.getDouble("Enter balance: ");
	
		c.setBalance(balance);
		try {
			dao.addNewCustomer(c);
		} catch (DaoException e) {
			log.warn("Exception while creating customer",e);
			throw new ServiceException();
		}

	}

}
