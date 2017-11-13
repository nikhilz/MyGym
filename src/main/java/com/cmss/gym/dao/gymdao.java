package com.cmss.gym.dao;

import com.cmss.gym.bean.GymBean;
import com.cmss.gym.bean.RegistrationBean;

public interface gymdao
{
	public boolean addEmployee(GymBean bean);
	public boolean addreg(RegistrationBean bean);
}
