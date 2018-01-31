package com.sales.agent.service;

import java.util.List;

import javax.ejb.Stateless;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.sales.admin.model.AdminFeedBackModel;
import com.sales.admin.model.AgentRegistrationModel;
import com.sales.agent.dao.DaoAgent;
import com.sales.home.model.RegistrationModel;
import com.sales.transactionlog.model.TransactionLog;
import com.sales.agent.model.PropertyModel;


/*@Service("ServiceAgent")
*/
@Stateless

@Transactional
public class ServiceImplementationAgent implements ServiceAgent{
	
	@Autowired
	private DaoAgent daoagent;

	
	@Override
	public List<RegistrationModel> getallusers() {

		return daoagent.getallusers();
	}
	
	
	@Override
	public List<RegistrationModel> registrationList() {
	
		return daoagent.registrationList();
	}



	
	public void addRegistration(RegistrationModel mode) {
		System.out.println("serviceimpli222222");
		daoagent.addRegistration(mode);
		
	}

@Override
public void statususerchange(String unme, String status) {
	daoagent.statusagentchange(unme,status);
	
}





@Override
public List<RegistrationModel> getallusers(String username) {
	return daoagent.getallusers(username);
}


@Override
public void updateusertgrid(RegistrationModel am) {
	daoagent.updateusertgrid(am);
}



public void deleteusergrid(String s) {
	daoagent.deleteusergrid(s);		
}



@Override
public List<RegistrationModel> searchuserusername(String username) {
	return daoagent.searchuserusername(username);
}



@Override
public List usersGriddateSearch(String from, String t) {
	
	return daoagent.usersGriddateSearch(from,t);	}


@Override
public List<AgentRegistrationModel> loginlist(String username,
		String password) {
	
	return daoagent.loginlist(username,password);
}

@Override
public void updateagentprofile(AgentRegistrationModel am) {

	daoagent.updateagentprofile(am);
}



public void changepassword(String username, String npd, String cnpd) {
	daoagent.changepassword(username,npd,cnpd);
}




public void addPropertyRegistration(PropertyModel model) {
	daoagent.addPropertyRegistration(model);
}


@Override
public List<PropertyModel> getallpropeties(String username) {
	return daoagent.getallpropeties(username);
	}


@Override
public List<PropertyModel> getallproperties() {
	return daoagent.getallproperties();
}


@Override
public List<PropertyModel> searchagentusername(String username) {
	return daoagent.searchagentusername(username);
}


@Override
public List agentGriddateSearch(String from, String t) {
	return daoagent.agentGriddateSearch(from,t);
}


@Override
public List<AgentRegistrationModel> agentloginlist(String username,
		String password) {
	return daoagent.agentloginlist(username,password);
}


public void deleteagentgrid(String s) {
	daoagent.deleteagentgrid(s);	
	
}



public void updateagentproperty(PropertyModel pm) {
	System.out.println("enter into service impleentation .................................."+pm);
	daoagent.updateagentproperty(pm);
}


@Override
public List<AdminFeedBackModel> getAllFeedbacks() {
	
	return daoagent.getAllFeedbacks();
}


@Override
public List<AdminFeedBackModel> getallfeedbacks(String id) {
	return daoagent.getallfeedbacks(id);
}



public void addagentfeedback(AdminFeedBackModel feedback) {
	daoagent.addagentfeedback(feedback);
}



public void replyUpdateFeedback(AdminFeedBackModel am) {
	daoagent.replyUpdateFeedback(am);
	
}


@Override
public List<AgentRegistrationModel> loginlistagent(String username, String password) {
	return daoagent.loginlistagent(username,password);
}



public void agentupdateproperty(PropertyModel pm) {
	daoagent.agentupdateproperty(pm);
}


@Override
public void agentChangePassword(String username, String npd,
		String cnpd) {
	daoagent.agentChangePassword(username,npd,cnpd);
}


@Override
public List<AgentRegistrationModel> agentpropertyloginlist(String username,
		String username1, String password) {
return daoagent.agentpropertyloginlist(username,username1,password);

}


@Override
public List<PropertyModel> agentpropertyloginlist(String username) {
	return daoagent.agentpropertyloginlist(username);
	

}


@Override
public List<PropertyModel> getallproperties(String username) {
	return daoagent.getallproperties(username);
	
}


@Override
public List<AgentRegistrationModel> viewdepts(String did) {
	
	return daoagent.viewdepts(did);
}


@Override
public void addemp(AgentRegistrationModel dept) {
	daoagent.addemp(dept);
}





@Override
public void addPropertyRegistration(AgentRegistrationModel agent) {
	daoagent.addPropertyRegistration(agent);
	
}


public List<AgentRegistrationModel> viewagents(String id) {
	return daoagent.viewagents(id);
}


@Override
public List<AgentRegistrationModel> viewagents() {
	return daoagent.viewagents();
	}


@Override
public List<PropertyModel> getProperty(String pid) {
	return daoagent.getProperty(pid);
}


@Override
public void logoutAppLog(String username, String logintime, String logouttime) {
	daoagent.logoutAppLog(username,logintime,logouttime);
	
}



@Override
public void Transactionlogdetails(TransactionLog tllog) {
	
	daoagent.Transactionlogdetails(tllog);
}


@Override
public void agentChangePassworduserlis(String username, String npd) {
	daoagent.agentChangePassworduserlis(username,npd);

}








}
