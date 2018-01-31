package com.sales.admin.service;

import java.util.List;

import javax.ejb.Stateless;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sales.admin.dao.DaoAdmin;
import com.sales.admin.model.AdminFeedBackModel;
import com.sales.admin.model.AgentRegistrationModel;
import com.sales.agent.model.PropertyModel;
import com.sales.home.model.RegistrationModel;

/*@Service("ServiceAdmin")*/
@Stateless
@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
public class ServiceImplementationAdmin implements ServiceAdmin{

	@Autowired
	private DaoAdmin admindao;
	
	@Override
	public List<RegistrationModel> getallusers() {

		return admindao.getallusers();
	}

	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public void deleteusergrid(String s) {
		admindao.deleteusergrid(s);		
	}

	@Override
	public List<AgentRegistrationModel> searchuserusername(String username) {
		return admindao.searchuserusername(username);
	}

	@Override
	public List userGriddateSearch(String from, String t) {
		return admindao.userGriddateSearch(from,t);	}

	@Transactional(propagation=Propagation.SUPPORTS,readOnly=true)
	public void addagentregistration(AgentRegistrationModel agntmdl) {
		admindao.addagentregistration(agntmdl);
		
	}

	@Override
	public void statusagentchange(String unme, String status) {
		admindao.statusagentchange(unme,status);
		
	}

	@Override
	public List<AgentRegistrationModel> getallagents() {
		
		return admindao.getallagents();
	}

	@Override
	public void deleteagentgrid(String s) {
		
		admindao.deleteagentgrid(s);		
		
	}

	@Override
	public List<AgentRegistrationModel> searchagentusername(String username) {
		return admindao.searchagentusername(username);
	}

	@Override
	public List<AgentRegistrationModel> getallagent(String username) {
		return admindao.getallagent(username);
	}

	@Override
	public void updateagentgrid(AgentRegistrationModel am) {
	
		 admindao.updateagentgrid(am);
	}

	@Override
	public List<AgentRegistrationModel> agentGriddateSearch(String from, String t) {
		
		return admindao.agentGriddateSearch(from,t);
	}

	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void updateadminprofile(RegistrationModel rm) {

		admindao.updateadminprofile(rm);
		
	}

	@Override
	public List<RegistrationModel> loginlist(String username,
			String password) {
		
		return admindao.loginlist(username,password);
	}
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void changepassword(String username, String npd, String cnpd) {
		admindao.changepassword(username,npd,cnpd);
	}

	@Override
	public List<AdminFeedBackModel> getAllFeedbacks() {
	
		return admindao.getAllFeedbacks();
	}

	@Override
	public List<AdminFeedBackModel> getallfeedbacks(String id) {

		return admindao.getallfeedbacks(id);
	}

	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void replyupdateadmin(AdminFeedBackModel am) {
		
		admindao.replyupdateadmin(am);
		
	}
	@Override
	public List<AdminFeedBackModel> searchadminfeedback(String username) {
		
		return admindao.searchadminfeedback(username);
	}

	@Override
	public List datefeedbackSearch(String from, String t) {

		return admindao.datefeedbackSearch(from,t);
	}

	@Override
	public List<PropertyModel> getallproperties() {
		return admindao.getallproperties();
	}

	@Override
	public List<PropertyModel> searchpropertyusername(String username) {
		return  admindao.searchpropertyusername(username);
	}

	@Override
	public List adminpropertyGriddateSearch(String from, String t) {
		return admindao.adminpropertyGriddateSearch(from,t);
	}

	@Override
	public void adminchangepassword(String id, String newpassword,
			String confirmnewpwd) {
		admindao.adminchangepassword(id,newpassword,confirmnewpwd);
		
	}

	@Override
	public void logoutAppLog(String username,String logintime, String logouttime) {
		
		admindao.logoutAppLog(username,logintime,logouttime);
	}

	@Override
	public List<AgentRegistrationModel> getidagent(String cname) {
		return admindao.getidagent(cname);
	}

	@Override
	public void addagents(AgentRegistrationModel agent) {
		admindao.addagents(agent);
		
	}

	@Override
	public void statusenable(String unme) {
		admindao.statusenable(unme);
		
	}

	@Override
	public void adminchangepassworduserli(String id, String newpassword) {
		admindao.adminchangepassworduserli(id,newpassword);
		
	}

	
}