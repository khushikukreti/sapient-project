package com.sapient.flixme.service;

import java.util.List;

import com.sapient.flixme.dao.CustomerDao;
import com.sapient.flixme.dao.CustomerDaoHashMapImpl;
import com.sapient.flixme.dao.DaoException;
import com.sapient.flixme.entity.Customer;
import com.sapient.flixme.util.KeyboardUtil;

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
		// Integer id;
		Customer c = new Customer();
		String name = KeyboardUtil.getString("Enter full name: ");
		if (!(name.isEmpty())) {
			c.setName(name);
		}

		String email = KeyboardUtil.getString("Enter email: ");
		if (!(email.isEmpty())) {

		}
		c.setEmail(email);
		String password = KeyboardUtil.getPassword("Enter password: ");
		if(!(password.isEmpty())) {
			
		}
		c.setPassword(password);
		String street = KeyboardUtil.getString("Enter street: ");
		if (!(street.isEmpty())) {

		}
		c.setStreet(street);
		String city = KeyboardUtil.getString("Enter city: ");
		if (!(city.isEmpty())) {

		}
		c.setCity(city);
		String state = KeyboardUtil.getString("Enter state: ");
		if (!(state.isEmpty())) {

		}
		c.setState(state);
		String pincode = KeyboardUtil.getString("Enter pincode: ");
		if (!(pincode.isEmpty())) {

		}
		c.setPincode(pincode);
		String country = KeyboardUtil.getString("Enter country: ");
		if (!country.isEmpty()) {

		}
		c.setCountry(country);
		double balance = KeyboardUtil.getDouble("Enter balance: ");

		c.setBalance(balance);
		try {
			dao.addNewCustomer(c);
		} catch (DaoException e) {
			log.warn("Exception while creating customer", e);
			throw new ServiceException();
		}

	}

	public void myProfile(Customer customer) {
		// System.out.println("hi"+ customer);
		System.out.println("\n\n**** PROFILE ****");
		System.out.println("ID: " + customer.getId());
		System.out.println("Name: " + customer.getName());
		System.out.println("Balance: " + customer.getBalance());
		System.out.println("Email: " + customer.getEmail());
		System.out.println("Address: " + customer.getStreet() + " " + customer.getState() + " " + customer.getCity()
				+ " " + customer.getPincode() + " " + customer.getCountry());


	}

	public void editProfile(Customer loggedInCustoner) {

		myProfile(loggedInCustoner);
		int choice;
		while ((choice = editProfileMenu()) != 0) {
			switch (choice) {
				case 1:
					editName(loggedInCustoner);
					break;
				case 2:
					changePassword(loggedInCustoner);
					break;
				case 3:
					updateBalance(loggedInCustoner);
					break;
				case 4:
					System.out.println("not ready yet");
				default:
					System.out.println("Invalid choice. Please retry.");
			}

		}
	}

	private void updateBalance(Customer loggedInCustoner) {
		System.out.println("Current Balance: " + loggedInCustoner.getBalance());

	}

	private void changePassword(Customer loggedInCustoner) {

		String oldPassword = KeyboardUtil.getString("Enter old password: ");
		if (oldPassword.equals(loggedInCustoner.getPassword())) {
			String newPassword = KeyboardUtil.getString("Enter new password");
			String newPassword2 = KeyboardUtil.getString("Confirm new password ");
			if (newPassword.equals(newPassword2)) {
				loggedInCustoner.setPassword(newPassword);
				System.out.println("Password changed successfully");
			} else {
				System.out.println("Password does not match");
			}
		} else {
			System.out.println("Wrong password !! Enter right password to reset ");
		}
	}

	private void editName(Customer loggedInCustoner) {
		String newName = KeyboardUtil.getString("Enter your name: ");
		System.out.println("Are you sure you want want to change your name from "
				+ loggedInCustoner.getName() + " to " + newName);
		int ans = KeyboardUtil.getInt("Press 1 to save and 0 to exit ");
		try {
			while (ans != 0) {
				switch (ans) {
					case 1:
						loggedInCustoner.setName(newName);
						System.out.println("Hello " + loggedInCustoner.getName());
						break;
					default:
						System.out.println("Invalid choice !c");
				}
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public int editProfileMenu() {
		try {
			System.out.println("1. Edit name");
			System.out.println("2. Change password");
			System.out.println("3. Update balance");
			System.out.println("4. Change address");
			System.out.println("0. Exit");

			int choice = KeyboardUtil.getInt("Enter your choice: ");
			return choice;
		} catch (Exception e) {
			log.warn("There was an error while accepting choice for main menu", e);
			return -1;
		}
	}

}
