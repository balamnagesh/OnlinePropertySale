package com.sales.home.bean;

import com.sales.home.model.Userlist;

public class UserRoleBean {
	
	private String userroleid;
	private String role;
	private Userlist usersListModel;
	
	
	public String getUserroleid() {
		return userroleid;
	}
	public void setUserroleid(String userroleid) {
		this.userroleid = userroleid;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Userlist getUsersListModel() {
		return usersListModel;
	}
	public void setUsersListModel(Userlist usersListModel) {
		this.usersListModel = usersListModel;
	}
	

}
