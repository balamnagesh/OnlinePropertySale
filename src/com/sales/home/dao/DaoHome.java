package com.sales.home.dao;



import java.util.List;

import com.sales.admin.model.AgentRegistrationModel;
import com.sales.applicationlog.model.ApplicationLog;
import com.sales.home.model.RegistrationModel;
import com.sales.home.model.UserRole;
import com.sales.home.model.Userslist;

public interface DaoHome {

	void addRegistration(RegistrationModel mode);

	List<RegistrationModel> registrationList();

	List<RegistrationModel> loinList(String user, String password);

	List<AgentRegistrationModel> loginagentlist(String user, String password);

	void statushomechange(String unme, String status);

	List<RegistrationModel> forgotpasswordlist(String username, String emailid);

	List<RegistrationModel> getuniqueusernamelist(String username);

	List<AgentRegistrationModel> getallagent(String username);

	List<RegistrationModel> emailuniquelist();

	void appLog(ApplicationLog almodel);

	void saveuserslist(Userslist uli);

	void saveuserrole(UserRole ur);

	void statusenable(String unme);

	


	

}
