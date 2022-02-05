package com.sapient.flixme.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.sapient.flixme.entity.Customer;

public class CustomerDaoHashMapImpl implements CustomerDao {
	private Map<Integer, Customer> data = new HashMap<>();
	private static final int ID_COUNTER = 2;
	public CustomerDaoHashMapImpl() {
		Customer c1=new Customer();
		c1.setId(1);
		c1.setName("Harshita");
		c1.setEmail("harshita@harshita.com");
		c1.setPassword("password");
		data.put(1, c1);
		
		c1=new Customer();
		c1.setId(2);
		c1.setName("Khushi");
		c1.setEmail("khushi@khushi.com");
		c1.setPassword("password1");
		data.put(2, c1);
		
	}

	@Override
	public void addNewCustomer(Customer customer) throws DaoException {
		customer.setId(ID_COUNTER + 1);
		data.put(customer.getId(), customer);
	}

	@Override
	public Customer findById(Integer id) throws DaoException {
		return data.get(id);
	}

	@Override
	public void updateCustomer(Customer customer) throws DaoException {
		if (data.containsKey(customer.getId())) {
			data.put(customer.getId(), customer);
		} else {
			throw new DaoException("No data found" + customer.getId());
		}
	}

	@Override
	public Customer findByEmail(String email) throws DaoException {
		Collection<Customer> customers = data.values();
		Iterator<Customer> it = customers.iterator();
		while(it.hasNext()) {
			Customer c=it.next();
			if(c.getEmail().equals(email)) {
				return c;
			}
		}
		return null;
	}

	@Override
	public List<Customer> findAll() throws DaoException {
		// for (Map.Entry m : data.entrySet()) {
		// 	System.out.println(m.getKey() + " "
		// 			+ m.getValue());
		// }
		 List<Customer> list = new ArrayList<Customer>(data.values());
		 return list;
	}

	@Override
	public List<Customer> findByCity(String city) throws DaoException {

		return null;
	}

}
