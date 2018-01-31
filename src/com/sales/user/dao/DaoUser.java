package com.sales.user.dao;

import java.util.List;

import com.sales.admin.model.AdminFeedBackModel;
import com.sales.agent.model.PropertyModel;
import com.sales.home.model.RegistrationModel;


public interface DaoUser {

	List<RegistrationModel> loginlist(String username, String password);

	void updateuserprofile(RegistrationModel rm);

	void changepassword(String username, String npd, String cnpd);

	void adduserfeedback(AdminFeedBackModel feedback);

	List<PropertyModel> getallproperties();

	List<PropertyModel> searchagentusername(String username);

	List agentGriddateSearch(String from, String t);

	void userChangePassword(String id, String newpassword, String confirmnewpwd);

	void logoutAppLog(String username, String logintime, String logouttime);

	void userChangePassworduserli(String id, String newpassword);

	/*void addPropertyRegistration(PropertyModel model);

	List<PropertyModel> getallproperties();

	List<PropertyModel> searchuserusername(String username);

	List userGriddateSearch(String from, String t);

	List<PropertyModel> getallpropeties(String username);

	*/

}
