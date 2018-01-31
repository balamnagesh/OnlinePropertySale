package com.sales.home.dao;



import java.util.List;

import com.sales.home.bean.LoginBean;
import com.sales.home.bean.Registration;
import com.sales.home.model.UserRole;
import com.sales.home.model.Userslist;



public interface SecurityDao {

	@SuppressWarnings("rawtypes")
	public List getSearchDetails(Registration login);
	
	public Userslist findByUserName(String username);
	
	public List<UserRole> loadUserRoleByUsername(String username);
	
	@SuppressWarnings("rawtypes")
	public List searchUser(Registration login);
	
}
