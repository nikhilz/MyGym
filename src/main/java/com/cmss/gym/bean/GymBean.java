package com.cmss.gym.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ENQUIRY_TBL")
public class GymBean {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	
@Column
 public String username;
@Column 
public String mobile;

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getMobile() {
	return mobile;
}
public void setMobile(String mobile) {
	this.mobile = mobile;
}
}
