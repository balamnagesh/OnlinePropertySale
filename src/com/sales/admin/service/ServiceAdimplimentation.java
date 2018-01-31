package com.sales.admin.service;



import javax.ejb.Stateless;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sales.admin.dao.ServiceDa;




/*@Service("GenericService")*/

@Stateless

@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
public class ServiceAdimplimentation implements ServiceAd<Object> {
	
	@Autowired
	private ServiceDa gsdao;

	@Override
	public void add(Object g) {
		System.out.println("enter into generic service impl.....");
		
		gsdao.add(g);
		
	}

}
