package com.fission.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fission.model.User;
import com.fisson.cont.HomeController;

public class UserDaoImpl implements UserDao {

	private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public boolean checkUser(User u) {
		Session session = this.sessionFactory.getCurrentSession();		
		User u1 = (User) session.load(User.class, u.getUsername());
		if(u.getPassword().equals(u1.getPassword()))
			return true;
		else 
			return false;
		
	}
	
	public List<User> listUsers() {
		Session session = this.sessionFactory.getCurrentSession();
		List<User> usersList = session.createQuery("from User").list();
		
		return usersList;
	}

}
