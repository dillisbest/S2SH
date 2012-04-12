package org.edm.action;

import org.edm.pojo.User;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8171929962729970979L;
	private User user;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public String toLogin()
	{
		System.out.println(user.toString());
		if(user.getUsername().equals("dusong") && user.getPassword().equals("dill"))
			return "success";
		else
			return "fail";
	}
}
