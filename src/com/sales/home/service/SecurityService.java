package com.sales.home.service;



import java.util.List;



import javax.ejb.Local;

import org.springframework.security.core.userdetails.UserDetails;

import com.sales.home.bean.LoginBean;
import com.sales.home.bean.Registration;
import com.sales.home.model.UserRole;
import com.sales.home.model.Userslist;



@Local
public interface SecurityService {

	
	@SuppressWarnings("rawtypes")
	public List getSearchDetails(Registration login);
	
	public UserDetails loadUserByUsername(final String username);
	
	Userslist getUserDetails(String id);
	
	public List<UserRole> loadUserRoleByUsername(String username);
	
	@SuppressWarnings("rawtypes")
	public List searchUser(Registration login);
}
