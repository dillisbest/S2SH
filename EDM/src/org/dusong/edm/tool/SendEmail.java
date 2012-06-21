package org.dusong.edm.tool;

import org.dusong.edm.pojo.User;


public class SendEmail {
	public static boolean sendEmail(User user){
		System.out.println("send email:"+ user.getEmail());
		return true;
	}
}
