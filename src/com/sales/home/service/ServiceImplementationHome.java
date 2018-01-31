package com.sales.home.service;


import java.util.List;

import javax.ejb.Stateless;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;











import com.sales.admin.model.AgentRegistrationModel;
import com.sales.applicationlog.model.ApplicationLog;
import com.sales.home.dao.DaoHome;
import com.sales.home.model.RegistrationModel;
import com.sales.home.model.UserRole;
import com.sales.home.model.Userslist;


/*@Service("ServiceHome")*/
@Stateless
@Transactional(propagation =Propagation.SUPPORTS,readOnly =true)
public class ServiceImplementationHome implements ServiceHome {
	@Autowired
	private DaoHome homedao;

	
	
	@Override
	public List<RegistrationModel> registrationList() {
	
		return homedao.registrationList();
	}

	
	
	@Transactional(propagation =Propagation.SUPPORTS,readOnly =true)
	
	public void addRegistration(RegistrationModel mode) {
		System.out.println("serviceimpli222222");
		homedao.addRegistration(mode);
		
	}



	@Override
	public List<RegistrationModel> loginList(String user, String password) {
		
		return homedao.loinList(user,password);
	}



	@Override
	public List<AgentRegistrationModel> loginagentlist(String user,String password) {
		System.out.println("service agent list");
		return homedao.loginagentlist(user,password);
	}



	@Override
	public void statushomechange(String unme, String status) {
		homedao.statushomechange(unme,status);
	}



	@Override
	public List<RegistrationModel> forgotpasswordlist(String username,
			String emailid) {
		return homedao.forgotpasswordlist(username,emailid);
	}



	@Override
	public List<RegistrationModel> getuniqueusernamelist(String username) {
		return homedao.getuniqueusernamelist(username);
	}



	@Override
	public List<AgentRegistrationModel> getallagent(String username) {
		return homedao.getallagent(username);
	}



	@Override
	public List<RegistrationModel> emailuniquelist() {
		return homedao.emailuniquelist();
	}



	@Transactional(propagation =Propagation.SUPPORTS,readOnly =true)
	public void appLog(ApplicationLog almodel) {
		homedao.appLog(almodel);

		
	}


	@Transactional(propagation =Propagation.SUPPORTS,readOnly =false)
	public void saveuserslist(Userslist uli) {
		
		homedao.saveuserslist(uli);
	}



	@Transactional(propagation =Propagation.SUPPORTS,readOnly =false)
	public void saveuserrole(UserRole ur) {
		System.out.println("user roleeeee 121211111111111111");
		
		homedao.saveuserrole(ur);
	}



	@Override
	public void statusenable(String unme) {
		
		homedao.statusenable(unme);
	}
	
	

	
	

}
