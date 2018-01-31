package com.sales.admin.dao;



import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("Genericdao")
public class DaoimplimentationAdmin implements ServiceDa<Object> {
	

@Autowired
private SessionFactory sessionFactory;

@Override
public void add(Object g) {
	System.out.println("enter into generic dao impl.....");
	System.out.println(".................."+g);
	sessionFactory.getCurrentSession().save(g);
	
}
	

}
