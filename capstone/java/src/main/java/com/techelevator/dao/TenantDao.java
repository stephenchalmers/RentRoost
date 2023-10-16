package com.techelevator.dao;

import com.techelevator.model.Tenant;

public interface TenantDao {

    Tenant getTenant(int tenantId);
    boolean addTenant(String firstname, String lastname, String email, String phone, int userId);

//    MORE STUFF
}

