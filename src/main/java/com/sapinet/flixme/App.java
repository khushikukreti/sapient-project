package com.sapinet.flixme;

import java.awt.RenderingHints.Key;

import com.sapient.flixme.entity.Admin;
import com.sapient.flixme.entity.Customer;
import com.sapient.flixme.service.AdminService;
import com.sapient.flixme.service.CustomerService;
import com.sapient.flixme.service.ServiceException;
import com.sapinet.flixme.util.KeyboardUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {

	CustomerService customerService = new CustomerService();
	AdminService adminService = new AdminService();
	Customer loggedInCustoner = null;
	Admin loggedInAdmin = null;

	public void start() {
		System.out.println("Welcome to Flixme review/rating system");
		int choice;
		while ((choice = mainMenu()) != 0) {
			switch (choice) {
				case 1:
					acceptAndLogin();
					break;
				case 2:
					try {
						customerService.selfRegistration();
					} catch (ServiceException e) {
						log.warn("Exeption while calling selfRegistration", e);
					}
					break;
				case 3:
					adminLogin();
					break;
				default:
					System.out.println("Invalid choice. Please retry.");

			}

		}
	}

	void adminLogin() {
		try {
			String email = KeyboardUtil.getString("Enter email: ");
			String password = KeyboardUtil.getString("Enter password: ");

			loggedInAdmin = adminService.login(email, password);
			int choice;

			while ((choice = adminMenu()) != 0) {
				switch (choice) {
					case 1:
					case 2:
					case 3:
					case 4:
					case 5:
					case 6:
					case 7:
					case 8:
						System.out.println("Registration module not ready yet!");
						break;
					default:
						System.out.println("Invalid choice. Please retry.");

				}
			}

		} catch (Exception ex) {
			log.warn("Exception while calling acceptAndLogin", ex);
			System.out.println("Couldn't login");
			System.out.println(ex.getMessage());
		}
	}

	void acceptAndLogin() {
		try {
			String email = KeyboardUtil.getString("Enter email: ");
			String password = KeyboardUtil.getString("Enter password: ");

			loggedInCustoner = customerService.login(email, password);
			int choice;

			while ((choice = customerMenu()) != 0) {
				switch (choice) {
					case 1:
					case 2:
					case 3:
					case 4:
					case 5:
					case 6:
					case 7:
					case 8:
						System.out.println("Registration module not ready yet!");
						break;
					default:
						System.out.println("Invalid choice. Please retry.");

				}
			}

		} catch (Exception ex) {
			log.warn("Exception while calling acceptAndLogin", ex);
			System.out.println("Couldn't login");
			System.out.println(ex.getMessage());
		}

	}

	int mainMenu() {
		try {
			System.out.println("1. Customer login");
			System.out.println("2. Customer self registration");
			System.out.println("3. Admin login");
			System.out.println("0. Exit");

			int choice = KeyboardUtil.getInt("Enter your choice: ");
			return choice;

		} catch (Exception e) {
			log.warn("Error while accepting choice for mainMenu", e);
			return -1;
		}

	}

	int adminMenu() {
		System.out.println("Login succeeded");
		System.out.println("Welcome " + loggedInAdmin.getName());
		try {
			System.out.println("1. View profile");
			System.out.println("2. Edit profile");
			System.out.println("3. Add New Movie");
			System.out.println("4. Update Movie");
			System.out.println("5. Show All Movies");
			System.out.println("6. Show All Customers");
			System.out.println("7. View Reviews");
			System.out.println("8. Delete Reviews");
			System.out.println("0. Exit");

			int choice = KeyboardUtil.getInt("Enter your choice: ");
			return choice;

		} catch (Exception e) {
			log.warn("There was an error while accepting choice for admin menu", e);
			return -1;
		}
	}

	int customerMenu() {
		System.out.println("Login succeeded");
		System.out.println("Welcome " + loggedInCustoner.getName());
		try {
			System.out.println("1. View profile");
			System.out.println("2. Edit profile");
			System.out.println("3. View balance");
			System.out.println("4. Update Balance");
			System.out.println("5. Search movies by title");
			System.out.println("6. Search movies by other parameters");
			System.out.println("7. Write a review");
			System.out.println("8. View my reviews");
			System.out.println("0. Exit");

			int choice = KeyboardUtil.getInt("Enter your choice: ");
			return choice;
		} catch (Exception e) {
			log.warn("There was an error while accepting choice for main menu", e);
			return -1;
		}
	}

	public static void main(String[] args) {

		new App().start();

	}

}
