package com.sales.admin.dao;

import java.util.List;

import com.sales.admin.model.AdminFeedBackModel;
import com.sales.admin.model.AgentRegistrationModel;
import com.sales.agent.model.PropertyModel;
import com.sales.home.model.RegistrationModel;

public interface DaoAdmin {

	List<RegistrationModel> getallusers();

	void deleteusergrid(String s);

	List<AgentRegistrationModel> searchuserusername(String username);

	List userGriddateSearch(String from, String t);

	void addagentregistration(AgentRegistrationModel agntmdl);

	void statusagentchange(String unme, String status);

	List<AgentRegistrationModel> getallagents();

	void deleteagentgrid(String s);

	List<AgentRegistrationModel> searchagentusername(String username);

	List<AgentRegistrationModel> getallagent(String username);

	void updateagentgrid(AgentRegistrationModel am);

	List<AgentRegistrationModel> agentGriddateSearch(String from, String t);

	void updateadminprofile(RegistrationModel rm);

	List<RegistrationModel> loginlist(String username, String password);

	void changepassword(String username, String npd, String cnpd);

	List<AdminFeedBackModel> getAllFeedbacks();

	List<AdminFeedBackModel> getallfeedbacks(String id);

	void replyupdateadmin(AdminFeedBackModel am);

	List<AdminFeedBackModel> searchadminfeedback(String username);

	

	@SuppressWarnings("rawtypes")
	List datefeedbackSearch(String from, String t);

	List<PropertyModel> getallproperties();

	List<PropertyModel> searchpropertyusername(String username);

	@SuppressWarnings("rawtypes")
	List adminpropertyGriddateSearch(String from, String t);

	void adminchangepassword(String id, String newpassword, String confirmnewpwd);

	void logoutAppLog(String username, String logintime, String logouttime);

	List<AgentRegistrationModel> getidagent(String cname);

	void addagents(AgentRegistrationModel agent);

	void statusenable(String unme);

	void adminchangepassworduserli(String id, String newpassword);

	


}
