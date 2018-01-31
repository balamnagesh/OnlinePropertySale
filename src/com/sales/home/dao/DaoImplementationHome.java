package com.sales.home.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


















import com.sales.admin.model.AgentRegistrationModel;
import com.sales.applicationlog.model.ApplicationLog;
import com.sales.home.model.RegistrationModel;
import com.sales.home.model.UserRole;
import com.sales.home.model.Userslist;


@Repository
public class DaoImplementationHome implements DaoHome {
	

	@Autowired
	private SessionFactory sessionFactory;

	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<RegistrationModel> registrationList() {
		return(List<RegistrationModel>) sessionFactory.getCurrentSession().createQuery("from RegistrationModel").list();	
	}
	


	
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void addRegistration(RegistrationModel mode) {
		System.out.println("daoimpli1111111111111111");
		sessionFactory.getCurrentSession().save(mode) ;	
		System.out.println("success"+mode);
	}




	@Override
	public List<RegistrationModel> loinList(String user, String password) {
		@SuppressWarnings("unchecked")
		List<RegistrationModel> l=sessionFactory.getCurrentSession().createQuery("from RegistrationModel where username='"+user+"' and password='"+password+"'").list();
		System.out.println("agentv registration modeljs"+l);
		return l;
	}




	@SuppressWarnings("unchecked")
	public List<AgentRegistrationModel> loginagentlist(String user, String password) {
	
		List<AgentRegistrationModel> li=sessionFactory.getCurrentSession().createQuery("from AgentRegistrationModel where username='"+user+"' and password='"+password+"'").list();
		System.out.println("agentv registration modeljs"+li);
		return li;
		
	}




	@Override
	public void statushomechange(String unme, String status) {
		String aprove="Active";
		sessionFactory.getCurrentSession().createQuery("update RegistrationModel set status='"+aprove+"' WHERE USERNAME='"+unme+"'").executeUpdate();
	}




	@SuppressWarnings("unchecked")

	public List<RegistrationModel> forgotpasswordlist(String username,String emailid) {
		return(List<RegistrationModel>) sessionFactory.getCurrentSession().createQuery("from RegistrationModel where username='"+username+"' and email='"+emailid+"'").list();

	}




	@SuppressWarnings("unchecked")
	@Override
	public List<RegistrationModel> getuniqueusernamelist(String username) {
		return (List<RegistrationModel>) sessionFactory.getCurrentSession().createCriteria(RegistrationModel.class).list();

	}




	@SuppressWarnings("unchecked")
	@Override
	public List<AgentRegistrationModel> getallagent(String username) {
		return (List<AgentRegistrationModel>) sessionFactory.getCurrentSession().createCriteria(AgentRegistrationModel.class).list();

	}




	@SuppressWarnings("unchecked")
	@Override
	public List<RegistrationModel> emailuniquelist() {
		return (List<RegistrationModel>) sessionFactory.getCurrentSession().createCriteria(RegistrationModel.class).list();

	}




	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void appLog(ApplicationLog almodel) {
		System.out.println("Application log is Running ");
		sessionFactory.getCurrentSession().save(almodel);
	}




	
	public void saveuserslist(Userslist uli) {
		
		sessionFactory.getCurrentSession().save(uli);
	}





	public void saveuserrole(UserRole ur) {
		System.out.println("000000000000000000000000000000000000000000000000000000");
		sessionFactory.getCurrentSession().save(ur);
	}




	@Override
	public void statusenable(String unme) {
		 sessionFactory.getCurrentSession().createQuery("UPDATE Userslist set enabled='1',status='active' where username='"+unme+"' ").executeUpdate();

	}


	
	
	
		
	}


	


