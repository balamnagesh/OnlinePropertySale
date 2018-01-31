package com.sales.agent.dao;

import java.util.List;

import com.sales.admin.model.AdminFeedBackModel;
import com.sales.admin.model.AgentRegistrationModel;
import com.sales.home.model.RegistrationModel;
import com.sales.transactionlog.model.TransactionLog;
import com.sales.agent.model.PropertyModel;

public interface DaoAgent {

	List<RegistrationModel> getallusers();

	List<RegistrationModel> registrationList();

	void addRegistration(RegistrationModel mode);

	void statusagentchange(String unme, String status);

	List<RegistrationModel> getallusers(String username);

	void updateusertgrid(RegistrationModel am);

	void deleteusergrid(String s);

	List<RegistrationModel> searchuserusername(String username);

	

	

	List usersGriddateSearch(String from, String t);

	List<AgentRegistrationModel> loginlist(String username, String password);

	void updateagentgrid(RegistrationModel am);

	void changepassword(String username, String npd, String cnpd);

	void addPropertyRegistration(PropertyModel model);

	List<PropertyModel> getallpropeties(String username);

	List<PropertyModel> getallproperties();

	List<PropertyModel> searchagentusername(String username);

	List agentGriddateSearch(String from, String t);

	List<AgentRegistrationModel> agentloginlist(String username, String password);

	void deleteagentgrid(String s);

	void updateagentproperty(PropertyModel pm);

	List<AdminFeedBackModel> getAllFeedbacks();

	List<AdminFeedBackModel> getallfeedbacks(String id);

	void addagentfeedback(AdminFeedBackModel feedback);

	void replyUpdateFeedback(AdminFeedBackModel am);

	List<AgentRegistrationModel> loginlistagent(String username, String password);

	void updateagentprofile(AgentRegistrationModel am);

	void agentupdateproperty(PropertyModel pm);

	void agentChangePassword(String username, String npd, String cnpd);

	List<AgentRegistrationModel> agentpropertyloginlist(String username, String username1,
			String password);

	List<PropertyModel> agentpropertyloginlist(String username);

	List<PropertyModel> getallproperties(String username);

	List<AgentRegistrationModel> viewdepts(String did);

	void addemp(AgentRegistrationModel dept);

	List<AgentRegistrationModel> viewagents();

	void addPropertyRegistration(AgentRegistrationModel agent);

	List<AgentRegistrationModel> viewagents(String id);

	List<PropertyModel> getProperty(String pid);

	void logoutAppLog(String username, String logintime, String logouttime);

	void Transactionlogdetails(TransactionLog tllog);

	void agentChangePassworduserlis(String username, String npd);

}
