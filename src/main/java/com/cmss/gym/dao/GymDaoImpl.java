package com.cmss.gym.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.cmss.gym.bean.GymBean;
import com.cmss.gym.bean.RegistrationBean;
import com.cmss.gym.service.gymservice;

@Repository
@EnableTransactionManagement
public class GymDaoImpl implements gymdao
{
	@Autowired
	SessionFactory sessionFactory;
	 
			Session currentSession;
/*
	public void addEmployee(String username, String mobile) {
		System.out.println(username);
		System.out.println("------dao-----------");
		sessionFactory.getCurrentSession().saveOrUpdate(username,mobile);
		
	}*/
	@Transactional
	public boolean addEmployee(GymBean bean) {
		try {
			currentSession = sessionFactory.getCurrentSession(); 

		System.out.println("------dao-----------");
		//currentSession.saveOrUpdate(bean); 
		currentSession.saveOrUpdate(bean);
		return true;
		} catch (Exception e) {
			//System.out.println(" "+e);
			e.printStackTrace();
			return false;
		
		}
		
		
	}
	public boolean addreg(RegistrationBean bean) {
		try {
			currentSession = sessionFactory.getCurrentSession(); 

		System.out.println("------dao---addreg-------");
		//currentSession.saveOrUpdate(bean); 
		currentSession.saveOrUpdate(bean);
		return true;
		} catch (Exception e) {
			//System.out.println(" "+e);
			e.printStackTrace();
			return false;
		
		}
		
	}

}
