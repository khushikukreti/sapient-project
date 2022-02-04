package com.sapient.flixme.dao;

import com.sapient.flixme.entity.Admin;

public interface AdminDao {
    
    public Admin findByEmail(String email) throws DaoException;

    //More options to be added after movie module
}
