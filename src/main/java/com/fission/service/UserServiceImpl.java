package com.fission.service;

import java.util.List;

import javax.transaction.Transactional;

import com.fission.dao.UserDao;
import com.fission.model.User;

public class UserServiceImpl implements UserService {

	private UserDao ud;

	public UserDao getUd() {
		return ud;
	}

	public void setUd(UserDao ud) {
		this.ud = ud;
	}

	@Override
	@Transactional
	public boolean checkUser(User u) {
		return this.ud.checkUser(u);
	}

	

}
