package com.sales.admin.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sales.admin.model.AdminFeedBackModel;
import com.sales.admin.model.AgentRegistrationModel;
import com.sales.agent.model.PropertyModel;
import com.sales.home.model.RegistrationModel;

@Repository
public class DaoImplementationAdmin implements DaoAdmin{
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<RegistrationModel> getallusers() {
		String type="ROLE_USER";
		return(List<RegistrationModel>) sessionFactory.getCurrentSession().createQuery("from RegistrationModel where type='"+type+"'").list();	
	}

	@Override
	public void deleteusergrid(String s) {
		sessionFactory.getCurrentSession().createQuery("delete FROM RegistrationModel WHERE username = '"+s+"'").executeUpdate();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AgentRegistrationModel> searchuserusername(String username) {
		String type="ROLE_USER";
		return sessionFactory.getCurrentSession().createQuery("from RegistrationModel where username like'%"+username+"%' and type='"+type+"'").list();
		
		
	}

	@Override
	public List userGriddateSearch(String from, String t) {
		
	
		
		String User= "ROLE_USER";
		List li= sessionFactory.getCurrentSession().createQuery("from RegistrationModel WHERE registerdate BETWEEN '"+from+"' AND '"+t+"' AND Type='"+User+"'").list();
		return li;
	}

	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void addagentregistration(AgentRegistrationModel agntmdl) {
		sessionFactory.getCurrentSession().saveOrUpdate(agntmdl) ;	

		
	}

	@Override
	public void statusagentchange(String unme, String status) {
		String aprove="Active";
		sessionFactory.getCurrentSession().createQuery("update AgentRegistrationModel set status='"+aprove+"' WHERE USERNAME='"+unme+"'").executeUpdate();
	}

	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<AgentRegistrationModel> getallagents() {
		return (List<AgentRegistrationModel>) sessionFactory.getCurrentSession().createCriteria(AgentRegistrationModel.class).list();

	}

	@Override
	public void deleteagentgrid(String s) {
		
		sessionFactory.getCurrentSession().createQuery("delete FROM AgentRegistrationModel WHERE username = '"+s+"'").executeUpdate();	
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AgentRegistrationModel> searchagentusername(String username) {
		String type="ROLE_AGENT";
		return sessionFactory.getCurrentSession().createQuery("from AgentRegistrationModel where username like'%"+username+"%' and type='"+type+"'").list();
		
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<AgentRegistrationModel> getallagent(String username) {
		
		List ldd=sessionFactory.getCurrentSession().createQuery("from AgentRegistrationModel where username='"+username+"'").list();
		return ldd;
	}

	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void updateagentgrid(AgentRegistrationModel am) {
		sessionFactory.getCurrentSession().update(am);
		

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<AgentRegistrationModel> agentGriddateSearch(String from, String t) {
		
		List ldd=sessionFactory.getCurrentSession().createQuery("from AgentRegistrationModel where dateofjoining between '"+from+"' and '"+t+"'").list();
		return ldd;
	}

	@Override
	public void updateadminprofile(RegistrationModel rm) {
		
		sessionFactory.getCurrentSession().saveOrUpdate(rm);
		
	}
	@SuppressWarnings("unchecked")
	public List<RegistrationModel> loginlist(String username,String password) {

		return sessionFactory.getCurrentSession().createQuery("from RegistrationModel where username='"+username+"' and password='"+password+"'").list();

	}

	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void changepassword(String username, String npd, String cnpd) {
		
		sessionFactory.getCurrentSession().createQuery("update RegistrationModel set password='"+npd+"',conformpassword='"+cnpd+"' where username='"+username+"'").executeUpdate();
		
	}

	@SuppressWarnings("unchecked")
	public List<AdminFeedBackModel> getAllFeedbacks() {

		return sessionFactory.getCurrentSession().createCriteria(AdminFeedBackModel.class).list();
	}

	@SuppressWarnings("unchecked")
	public List<AdminFeedBackModel> getallfeedbacks(String id) {
		
		return sessionFactory.getCurrentSession().createQuery("from AdminFeedBackModel where id='"+id+"'").list();

	}

	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void replyupdateadmin(AdminFeedBackModel am) {
		
		sessionFactory.getCurrentSession().update(am);

	}

	@SuppressWarnings("unchecked")
	public List<AdminFeedBackModel> searchadminfeedback(String username) {
		
		return sessionFactory.getCurrentSession().createQuery("From AdminFeedBackModel where status like '%"+username+"%' or type like '%"+username+"%'").list();

	}

	@SuppressWarnings("rawtypes")
	public List datefeedbackSearch(String from, String t) {

		List ldd=sessionFactory.getCurrentSession().createQuery("from AdminFeedBackModel where FEEDBACKDATE between '"+from+"' and '"+t+"'").list();
		return ldd;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PropertyModel> getallproperties() {
		return (List<PropertyModel>) sessionFactory.getCurrentSession().createCriteria(PropertyModel.class).list();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PropertyModel> searchpropertyusername(String username) {
		return sessionFactory.getCurrentSession().createQuery("from PropertyModel where city like'%"+username+"%'").list();

	}
	@SuppressWarnings("unchecked")
	@Override
	public List adminpropertyGriddateSearch(String from, String t) {
	
		List<PropertyModel> li= sessionFactory.getCurrentSession().createQuery("from PropertyModel WHERE PROPERTYREGISTERDATE BETWEEN '"+from+"' AND '"+t+"'").list();
		return li;

	}

	@Override
	public void adminchangepassword(String id, String newpassword,
			String confirmnewpwd) {
		sessionFactory.getCurrentSession().createQuery("update RegistrationModel set password='"+newpassword+"',conformpassword='"+confirmnewpwd+"' where username='"+id+"'").executeUpdate();

		
	}

	
	
	@Override
	public void logoutAppLog(String username,String logintime, String logouttime) {
		
		sessionFactory.getCurrentSession().createQuery("update ApplicationLog set logouttime = '"+logouttime+"' where userame ='"+username+"' and logindate = '"+logintime+"'").executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AgentRegistrationModel> getidagent(String cname) {
		return (List<AgentRegistrationModel>) sessionFactory.getCurrentSession().get(AgentRegistrationModel.class,cname);
	}

	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void addagents(AgentRegistrationModel agent) {
		System.out.println("enter into agents in daoimpl");
		sessionFactory.getCurrentSession().save(agent);
	}

	@Override
	public void statusenable(String unme) {
		 sessionFactory.getCurrentSession().createQuery("UPDATE Userslist set enabled='1',status='active' where username='"+unme+"' ").executeUpdate();

		
	}

	@Override
	public void adminchangepassworduserli(String id, String newpassword) {
		sessionFactory.getCurrentSession().createQuery("update Userslist set password='"+newpassword+"' where username='"+id+"'").executeUpdate();
		
	}
}
