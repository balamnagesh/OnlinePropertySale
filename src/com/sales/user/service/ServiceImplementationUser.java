package com.sales.user.service;

import java.util.List;

import javax.ejb.Stateless;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sales.admin.model.AdminFeedBackModel;
import com.sales.admin.model.AgentRegistrationModel;
import com.sales.agent.model.PropertyModel;
import com.sales.home.model.RegistrationModel;
import com.sales.user.dao.DaoUser;





/*@Service("ServiceUser")*/
@Stateless
@Transactional
public class ServiceImplementationUser implements ServiceUser{

	@Autowired
	private DaoUser daouser;

	@Override
	public List<RegistrationModel> loginlist(String username, String password) {
		
		return daouser.loginlist(username,password);
	}

	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void updateuserprofile(RegistrationModel rm) {
		 daouser.updateuserprofile(rm);
		
		 	 
	}

	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void changepassword(String username, String npd, String cnpd) {
		daouser.changepassword(username,npd,cnpd);
	}

	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public void adduserfeedback(AdminFeedBackModel feedback) {
		daouser.adduserfeedback(feedback);
		
	}

	@Override
	public List<PropertyModel> getallproperties() {
		return daouser.getallproperties();
	}

	@Override
	public List<PropertyModel> searchagentusername(String username) {
		
		return  daouser.searchagentusername(username);
	}

	@Override
	public List agentGriddateSearch(String from, String t) {
		return daouser.agentGriddateSearch(from,t);
	}

	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void userChangePassword(String id, String newpassword,
			String confirmnewpwd) {
		daouser.userChangePassword(id,newpassword,confirmnewpwd);
		
	}

	@Override
	public void logoutAppLog(String username, String logintime, String logouttime) {
		daouser.logoutAppLog(username,logintime,logouttime);
		
	}

	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void userChangePassworduserli(String id, String newpassword) {
		daouser.userChangePassworduserli(id,newpassword);

		
	}

	/*@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)

	public void addPropertyRegistration(PropertyModel model) {
		daouser.addPropertyRegistration(model);
	}

	@Override
	public List<PropertyModel> getallproperties() {
		return daouser.getallproperties();
	}
	@Override
	public List<PropertyModel> searchuserusername(String username) {
		return daouser.searchuserusername(username);
	}

	@Override
	public List userGriddateSearch(String from, String t) {
		return daouser.userGriddateSearch(from,t);	}

	@Override
	public List<PropertyModel> getallpropeties(String username) {
		return daouser.getallpropeties(username);
		}
	*/
	
}