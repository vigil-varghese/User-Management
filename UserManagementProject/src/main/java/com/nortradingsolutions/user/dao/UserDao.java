package com.nortradingsolutions.user.dao;

import java.util.List;

import com.nortradingsolutions.user.model.User;
/**
 * 
 * @author Vigil Varghese
 *
 */
public interface UserDao {
	/**
	 * 
	 * @param user
	 */
	public boolean saveUser(User user);
	/**
	 * 
	 * @param user
	 */
	public boolean updateUser(User user);
	/** 
	 * 
	 * @param id
	 */
	public boolean deleteUser(long id);
	/**
	 * 
	 * @param id
	 * @return
	 */
	public User getUserById(long id);
	/**
	 * 
	 * @return
	 */
	public List<User> getAllUser();
	

}
