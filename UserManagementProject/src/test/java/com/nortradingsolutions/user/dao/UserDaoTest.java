package com.nortradingsolutions.user.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.nortradingsolutions.user.daoImpl.UserDaoImpl;
import com.nortradingsolutions.user.model.User;

class UserDaoTest {

	private UserDao userDao;
	private boolean success = false;
	
	@Test
	void testSaveUser() {
		
		
		userDao = new UserDaoImpl();
		User user = new User("Manu","George");
		
		success = userDao.saveUser(user);
		assertTrue(success);
		if(!success) {
			fail("failed to add user");
		}
		
	}

	@Test
	void testUpdateUser() {
		userDao = new UserDaoImpl();
		User user = new User(1,"Robin","Russel");
			
		success = userDao.updateUser(user);
		 assertTrue(success);
		 
		if(!success) {
			fail("failed to update user");
		}
	}

	@Test
	void testDeleteUser() {
		userDao = new UserDaoImpl();
		User user = new User(1,"Robin","Russel");
			
		success = userDao.deleteUser(user.getId());
		assertTrue(success);
		
		
		if(!success) {
			fail("failed to delete user");
		}
	}
	
	@Test
	void testGetAllUser() {
		userDao = new UserDaoImpl();
		List<User> user = userDao.getAllUser();
			
		assertTrue(user.size()>0);
		
		if(user.size()<=0) {
			fail("failed to user list");
		}
	}
	
	@Test
	void testGetUserByUserId() {
		userDao = new UserDaoImpl();
		User user = userDao.getUserById(1);
		assertTrue(user!=null);
		
		if(user==null)
			fail("failed to get user by id");
	}

}
