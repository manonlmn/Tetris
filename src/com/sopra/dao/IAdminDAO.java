package com.sopra.dao;

import com.sopra.model.Admin;

public interface IAdminDAO extends IDAO<Admin> {
	public Admin searchbyUNandPWd(String username, String password);
}
