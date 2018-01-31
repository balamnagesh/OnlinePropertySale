package com.sales.user.dao;

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


@Repository("DaoUser")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class DaoImplementationUser implements DaoUser{

	@Autowired
	private SessionFactory sessionFactory;
	@SuppressWarnings("unchecked")
	public List<RegistrationModel> loginlist(String username,String password) {

		return sessionFactory.getCurrentSession().createQuery("from RegistrationModel where username='"+username+"' and password='"+password+"'").list();

	}
	
	@Override
	public void updateuserprofile(RegistrationModel rm) {
		
		sessionFactory.getCurrentSession().saveOrUpdate(rm);
		
	}

	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void changepassword(String username, String npd, String cnpd) {
		
		sessionFactory.getCurrentSession().createQuery("update RegistrationModel set password='"+npd+"',conformpassword='"+cnpd+"' where username='"+username+"'").executeUpdate();
		
		
	}


	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void adduserfeedback(AdminFeedBackModel feedback) {
		
		sessionFactory.getCurrentSession().save(feedback);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PropertyModel> getallproperties() {
		return (List<PropertyModel>) sessionFactory.getCurrentSession().createCriteria(PropertyModel.class).list();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PropertyModel> searchagentusername(String username) {
		System.out.println("username  4554"+username);
		return sessionFactory.getCurrentSession().createQuery("from PropertyModel where city like'%"+username+"%'").list();

	}
	@SuppressWarnings("unchecked")
	@Override
	public List<PropertyModel> agentGriddateSearch(String from, String t) {
		
		List<PropertyModel> li= sessionFactory.getCurrentSession().createQuery("from PropertyModel WHERE PROPERTYREGISTERDATE BETWEEN '"+from+"' AND '"+t+"'").list();
		return li;

	}


	public void userChangePassword(String id, String newpassword,
			String confirmnewpwd) {
		sessionFactory.getCurrentSession().createQuery("update RegistrationModel set password='"+newpassword+"',conformpassword='"+confirmnewpwd+"' where username='"+id+"'").executeUpdate();


	}

	@Override
	public void logoutAppLog(String username, String logintime, String logouttime) {
		sessionFactory.getCurrentSession().createQuery("update ApplicationLog set logouttime = '"+logouttime+"' where userame ='"+username+"' and logindate = '"+logintime+"'").executeUpdate();

		
	}

	@Override
	public void userChangePassworduserli(String id, String newpassword) {
		sessionFactory.getCurrentSession().createQuery("update Userslist set password='"+newpassword+"' where username='"+id+"'").executeUpdate();
		
	}

	/*@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void addPropertyRegistration(PropertyModel model) {
		sessionFactory.getCurrentSession().save(model);
		
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public List<PropertyModel> getallproperties() {
		return (List<PropertyModel>) sessionFactory.getCurrentSession().createCriteria(PropertyModel.class).list();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PropertyModel> searchuserusername(String username) {
		String type="User";
		String Agent="Agent";
		return sessionFactory.getCurrentSession().createQuery("from PropertyModel where username like'%"+username+"%' and type='"+type+"'").list();
		
		
	}

	@Override
	public List userGriddateSearch(String from, String t) {
		String User= "User";
		String Agent="Agent";
		List li= sessionFactory.getCurrentSession().createQuery("from PropertyModel WHERE PROPERTYREGISTERDATE BETWEEN '"+from+"' AND '"+t+"' and type='"+User+"'").list();
		return li;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PropertyModel> getallpropeties(String username) {
		return (List<PropertyModel>) sessionFactory.getCurrentSession().createCriteria(PropertyModel.class).list();

	}
	*/
		
		

	
}
