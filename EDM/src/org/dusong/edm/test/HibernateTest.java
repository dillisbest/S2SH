package org.dusong.edm.test;

import java.util.Iterator;
import java.util.List;

import org.dusong.edm.pojo.Department;
import org.dusong.edm.pojo.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
            SessionFactory sf = new Configuration().configure().buildSessionFactory();
            Session session = sf.openSession();
            Transaction tx = session.beginTransaction();
            User user = new User();
            //Department dp = new Department();
            //user.setEmail("hibernate@hiber.com");
            //user.setUsername("Hibernate");
            //user.setPassword("Fra22");
            //session.save(user);
            //dp = (Department)session.get(Department.class, 1);
            //user.setDepartment(dp);
            user = (User)session.get(User.class,7);
            System.out.println(user.toString());
            //session.delete(user);
            tx.commit();
            session.close();
        } catch (HibernateException e) {
            e.printStackTrace();
        }

	}

}
