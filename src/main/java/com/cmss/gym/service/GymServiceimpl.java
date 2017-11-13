package com.cmss.gym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmss.gym.bean.GymBean;
import com.cmss.gym.dao.gymdao;

@Service
public class GymServiceimpl implements gymservice {
	@Autowired
	gymdao dao;

	boolean res;
	public boolean addenquiry(GymBean bean) {
		res=dao.addEmployee(bean);
		if(res) 
			return true;
		else
			return false;
	}

}
