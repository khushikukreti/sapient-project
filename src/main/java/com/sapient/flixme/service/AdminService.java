package com.sapient.flixme.service;

import com.sapient.flixme.dao.AdminDao;
import com.sapient.flixme.dao.AdminDaoHashMapImpl;
import com.sapient.flixme.dao.DaoException;
import com.sapient.flixme.entity.Admin;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AdminService {

    private AdminDao dao = new AdminDaoHashMapImpl();

    public Admin login(String email, String password) throws ServiceException {
		try {
			Admin a = dao.findByEmail(email);
			if (a == null) {
				throw new ServiceException("Invalid email/password");
			}
			if (a.getPassword().equals(password)) {
				return a;
			} else {
				throw new ServiceException("Invalid email/password");
			}

		} catch (DaoException e) {
			log.warn("Exception while calling login", e);
			throw new ServiceException(e);
		}
	}
    
}
