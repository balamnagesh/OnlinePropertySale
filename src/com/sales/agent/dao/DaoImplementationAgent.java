package com.sales.agent.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.itextpdf.text.log.SysoCounter;
import com.sales.admin.model.AdminFeedBackModel;
import com.sales.admin.model.AgentRegistrationModel;
import com.sales.home.model.RegistrationModel;
import com.sales.transactionlog.model.TransactionLog;
import com.sales.agent.model.PropertyModel;

@Repository("DaoAgent")
public class DaoImplementationAgent implements DaoAgent{
	
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<RegistrationModel> getallusers() {
		String type="ROLE_USER";
		return(List<RegistrationModel>) sessionFactory.getCurrentSession().createQuery("from RegistrationModel where type='"+type+"'").list();	
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<RegistrationModel> registrationList() {
		return(List<RegistrationModel>) sessionFactory.getCurrentSession().createQuery("from RegistrationModel").list();	
	}


	
	public void addRegistration(RegistrationModel mode) {
		
		sessionFactory.getCurrentSession().save(mode) ;	
		
	}

	@Override
	public void statusagentchange(String unme, String status) {
		String aprove="Active";
		sessionFactory.getCurrentSession().createQuery("update RegistrationModel set status='"+aprove+"' WHERE USERNAME='"+unme+"'").executeUpdate();
	}
	

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<RegistrationModel> getallusers(String username) {
		List ldd=sessionFactory.getCurrentSession().createQuery("from RegistrationModel where username='"+username+"'").list();
		return ldd;
	}

	public void updateusertgrid(RegistrationModel am) {
		sessionFactory.getCurrentSession().update(am);
		

	}

	@Override
	public void deleteusergrid(String s) {
		sessionFactory.getCurrentSession().createQuery("delete FROM RegistrationModel WHERE username = '"+s+"'").executeUpdate();

	}


	@SuppressWarnings("unchecked")
	@Override
	public List<RegistrationModel> searchuserusername(String username) {
		String type="ROLE_USER";
		return sessionFactory.getCurrentSession().createQuery("from RegistrationModel where username like'%"+username+"%' and type='"+type+"'").list();
		
	}

	
		
		
	@SuppressWarnings("rawtypes")
	@Override
	public List usersGriddateSearch(String from, String t) {
		String User= "User";
		List li= sessionFactory.getCurrentSession().createQuery("from RegistrationModel WHERE registerdate BETWEEN '"+from+"' AND '"+t+"' AND Type='"+User+"'").list();
		return li;
	}


	@SuppressWarnings("unchecked")
	public List<AgentRegistrationModel> loginlist(String username,String password) {

		return sessionFactory.getCurrentSession().createQuery("from AgentRegistrationModel where username='"+username+"' and password='"+password+"'").list();

	}
	

	public void updateagentgrid(RegistrationModel am) {
		sessionFactory.getCurrentSession().update(am);
		

	}



	public void changepassword(String username, String npd, String cnpd) {
		
		sessionFactory.getCurrentSession().createQuery("update RegistrationModel set password='"+npd+"',conformpassword='"+cnpd+"' where username='"+username+"'").executeUpdate();
		

	}


	
	public void addPropertyRegistration(PropertyModel model) {
		sessionFactory.getCurrentSession().save(model);
		
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<PropertyModel> getallpropeties(String username) {
		String query="From PropertyModel where ID='"+username+"'";
		return (List<PropertyModel>) sessionFactory.getCurrentSession().createQuery(query).list();
		

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PropertyModel> getallproperties() {
		return (List<PropertyModel>) sessionFactory.getCurrentSession().createCriteria(PropertyModel.class).list();

	}


	@SuppressWarnings("unchecked")
	@Override
	public List<PropertyModel> searchagentusername(String username) {
		return sessionFactory.getCurrentSession().createQuery("from PropertyModel where city like'%"+username+"%'").list();

	}


	@Override
	public List agentGriddateSearch(String from, String t) {
		List li= sessionFactory.getCurrentSession().createQuery("from PropertyModel WHERE PROPERTYREGISTERDATE BETWEEN '"+from+"' AND '"+t+"'").list();
		return li;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<AgentRegistrationModel> agentloginlist(String username,
			String password) {
		return sessionFactory.getCurrentSession().createQuery("from AgentRegistrationModel where username='"+username+"' and password='"+password+"'").list();

	}


	@Override
	public void deleteagentgrid(String s) {
	
		sessionFactory.getCurrentSession().createQuery("delete FROM PropertyModel WHERE id = '"+s+"'").executeUpdate();

	}


	
	public void updateagentproperty(PropertyModel pm) {
		System.out.println("enter into dao implementation in daoimplementation.................."+pm);
		sessionFactory.getCurrentSession().update(pm);
		

	}


	@SuppressWarnings("unchecked")
	@Override
	public List<AdminFeedBackModel> getAllFeedbacks() {
		String type="ROLE_USER";
		return sessionFactory.getCurrentSession().createQuery("from AdminFeedBackModel where type='"+type+"'").list();
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<AdminFeedBackModel> getallfeedbacks(String id) {
		return sessionFactory.getCurrentSession().createQuery("from AdminFeedBackModel where id='"+id+"'").list();

	}


	public void addagentfeedback(AdminFeedBackModel feedback) {
		sessionFactory.getCurrentSession().save(feedback);
	}



	public void replyUpdateFeedback(AdminFeedBackModel am) {
		sessionFactory.getCurrentSession().update(am);
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<AgentRegistrationModel> loginlistagent(String username,
			String password) {
		return sessionFactory.getCurrentSession().createQuery("from AgentRegistrationModel where username='"+username+"' and password='"+password+"'").list();

	}


	

	public void updateagentprofile(AgentRegistrationModel am) {
		sessionFactory.getCurrentSession().update(am);
		
	}


	
	public void agentupdateproperty(PropertyModel pm) {
		sessionFactory.getCurrentSession().update(pm);
		
	}


	@Override
	public void agentChangePassword(String username, String npd,
			String cnpd) {
		sessionFactory.getCurrentSession().createQuery("update AgentRegistrationModel set password='"+npd+"',conformpassword='"+cnpd+"' where username='"+username+"'").executeUpdate();

	}


	@SuppressWarnings("unchecked")
	@Override
	public List<AgentRegistrationModel> agentpropertyloginlist(String username,
			String username1, String password) {
		return sessionFactory.getCurrentSession().createQuery("from AgentRegistrationModel where id='"+username+"' and username='"+password+"'").list();

	}


	@SuppressWarnings("unchecked")
	@Override
	public List<PropertyModel> agentpropertyloginlist(String username) {
		return sessionFactory.getCurrentSession().createQuery("from PropertyModel where username='"+username+"'").list();

	}


	@SuppressWarnings("unchecked")
	@Override
	public List<PropertyModel> getallproperties(String username) {
		return sessionFactory.getCurrentSession().createQuery("from PropertyModel where username='"+username+"'").list();

	}


	@SuppressWarnings("unchecked")
	@Override
	public List<AgentRegistrationModel> viewdepts(String did) {
				return sessionFactory.getCurrentSession().createQuery("FROM AgentRegistrationModel WHERE id = '"+did+"'").list();

	}


	@Override
	public void addemp(AgentRegistrationModel dept) {
		sessionFactory.getCurrentSession().save(dept);
		
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<AgentRegistrationModel> viewagents() {
		return(List<AgentRegistrationModel>) sessionFactory.getCurrentSession().createQuery("from AgentRegistrationModel").list();	

	}


	@Override
	public void addPropertyRegistration(AgentRegistrationModel agent) {
		System.out.println("agent registration modell referenceeeee   2222222222"+agent);
		sessionFactory.getCurrentSession().saveOrUpdate(agent);
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<AgentRegistrationModel> viewagents(String id) {
		return sessionFactory.getCurrentSession().createQuery("FROM AgentRegistrationModel WHERE id = '"+id+"'").list();

	}


	@SuppressWarnings("unchecked")
	@Override
	public List<PropertyModel> getProperty(String pid) {
		return sessionFactory.getCurrentSession().createQuery("FROM PropertyModel WHERE id = '"+pid+"'").list();

	}


	@Override
	public void logoutAppLog(String username, String logintime, String logouttime) {
		sessionFactory.getCurrentSession().createQuery("update ApplicationLog set logouttime = '"+logouttime+"' where userame ='"+username+"' and logindate = '"+logintime+"'").executeUpdate();

		
	}


	@Override
	public void Transactionlogdetails(TransactionLog tllog) {
		
		sessionFactory.getCurrentSession().save(tllog);
	}


	@Override
	public void agentChangePassworduserlis(String username, String npd) {
		sessionFactory.getCurrentSession().createQuery("update Userslist set password='"+npd+"' where username='"+username+"'").executeUpdate();
		
	}
	
	

}
