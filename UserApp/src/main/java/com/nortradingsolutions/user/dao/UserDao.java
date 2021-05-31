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
	boolean saveUser(User user);
	/**
	 * 
	 * @param user
	 */
	boolean updateUser(User user);
	/**
	 * 
	 * @param id
	 */
	boolean deleteUser(long id);
	/**
	 * 
	 * @param id
	 * @return
	 */
	User getUserById(long id);
	/**
	 * 
	 * @return
	 */
	List<User> getAllUser();
	

}
