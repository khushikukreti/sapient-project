package com.sapient.flixme.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.sapient.flixme.entity.Admin;

public class AdminDaoHashMapImpl implements AdminDao{

    private Map<Integer, Admin> data = new HashMap<>();

    public AdminDaoHashMapImpl() {
        Admin a = new Admin();
        a.setId(1);
        a.setName("admin");
        a.setEmail("admin@admin.com");
        a.setPassword("password");
        data.put(1, a);
    }

    @Override
    public Admin findByEmail(String email) throws DaoException {
        Collection<Admin> admin = data.values();
		Iterator<Admin> it = admin.iterator();
		while(it.hasNext()) {
			Admin a=it.next();
			if(a.getEmail().equals(email)) {
				return a;
			}
		}
		return null;
    }
    
}
