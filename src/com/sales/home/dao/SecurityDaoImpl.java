package com.sales.home.dao;



import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sales.home.bean.LoginBean;
import com.sales.home.bean.Registration;
import com.sales.home.model.UserRole;
import com.sales.home.model.Userslist;



@Repository("SecurityDao")
public class SecurityDaoImpl implements SecurityDao{

	@Autowired
	private SessionFactory sf;
	
	
	@Override
	
	public List getSearchDetails(Registration login){
		System.out.println("getSearchDetails in daaaaaaaaaooooooooo implllllllllllllllll");
		String us=login.getUsername();
		String pa=login.getPassword();
		
		List userslist=sf.getCurrentSession().createQuery("from Userslist where username='"+us+"' and password='"+pa+"'").list();
		return userslist;
		
		
	}
	
	public List<?> searchUser(Registration login){
		System.out.println("searchuser in daaaaaaaaaaaaaooooooooooo    implllllllllllllllll");
		return sf.getCurrentSession().createQuery("from Userslist where username='"+login.getUsername()+"'").list();
	}
	
	
	@SuppressWarnings("unchecked")
	public Userslist findByUserName(String username){
		System.out.println("findByUserName in daaaaaaaaoooooooo implllllllllllllllllllll");
		//Userslist userslist=new Userslist();
		List<Userslist> li=new ArrayList<Userslist>();
		li=sf.getCurrentSession().createQuery("from Userslist where username=?").setParameter(0,username).list();
		if(li.size()>0){
			
			System.out.println("enter into if of security daaaooooooooo implllllllll");
			
			return li.get(0);
			
		}
		return null;		
	}

	@SuppressWarnings("unchecked")
	public List<UserRole> loadUserRoleByUsername(String username){
		System.out.println("List<UserRole> in daaoooooooooooo impllllllllllllllllll");
		return (List<UserRole>) sf.getCurrentSession().createQuery("from UserRole where username=?").setParameter(0,username).list();
	}

}
