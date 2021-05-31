package com.nortradingsolutions.user.dao;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import com.nortradingsolutions.user.model.User;

import com.nortradingsolutions.user.daoImpl.UserDaoImpl;

class UserDaoTest {
	
	private UserDao userDao;
	@Test
	void testSaveUser() {
		
		
		userDao = new UserDaoImpl();
		User user = new User("Manu","George");
		
		boolean success = userDao.saveUser(user);
		assertTrue(success);
		
		if(!success) {
			fail("failed to add user");
		}
		
	}

	@Test
	void testUpdateUser() {
		userDao = new UserDaoImpl();
		User user = new User(16,"Robin","Russel");
			
		boolean success = userDao.updateUser(user);
		assertTrue(success);
		
		if(!success) {
			fail("failed to update user");
		}
	}

	@Test
	void testDeleteUser() {
		userDao = new UserDaoImpl();
		User user = new User(16,"Robin","Russel");
			
		boolean success = userDao.deleteUser(user.getId());
		assertTrue(success);
		
		if(!success) {
			fail("failed to delete user");
		}
	}
	
	@Test
	void testGetAllUser() {
		userDao = new UserDaoImpl();
		int size = userDao.getAllUser().size();
			
		
		assertTrue(size>0);
		
		if(size<=0) {
			fail("failed to user list");
		}
	}
	
	@Test
	void testGetUserByUserId() {
		userDao = new UserDaoImpl();
		User user = userDao.getUserById(16);
			
		
		assertTrue(user!=null);
		
		if(user==null) {
			fail("failed to get user by id");
		}
	}

}
