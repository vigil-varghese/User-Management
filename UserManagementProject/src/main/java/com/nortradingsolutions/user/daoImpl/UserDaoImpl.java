package com.nortradingsolutions.user.daoImpl;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nortradingsolutions.user.dao.UserDao;
import com.nortradingsolutions.user.model.User;
import com.nortradingsolutions.user.util.HibernateConfig;


public class UserDaoImpl implements UserDao {
	
	private SessionFactory sessionFactory = HibernateConfig.getSessionFactory();

	@Override
	public boolean saveUser(User user) {
		Transaction transaction = null;
		Session session = null;
		boolean result = true;
		
		
		try{
			session = sessionFactory.openSession();
			
			// begin transaction
			transaction = session.beginTransaction();
			session.save(user);
			transaction.commit();
			
			System.out.println("User Added to the records");
			
		}catch(Exception e) {
			result = false;
			if(transaction !=null) {
				transaction.rollback();
			}
		}finally {
			session.close();
		}
		
		return result;
		
	}

	@Override
	public boolean updateUser(User user) {
		Session session= null;
		Transaction transaction = null;
		boolean result = true;
		
		try{
			session = sessionFactory.openSession();
			
			// begin transaction
			transaction = session.beginTransaction();
			session.update(user);
			transaction.commit();
			
			
		}catch(Exception e) {
			result = false;
			if(transaction !=null) {
			  transaction.rollback();
			}
		}finally {
			session.close();
		}
		
		return result;
	}

	@Override
	public boolean deleteUser(long id) {
		Transaction transaction = null;
		Session session = null;
		User user = null;
		boolean result = true;
		
		
		try{
			session = sessionFactory.openSession();
			
			// begin transaction
			transaction = session.beginTransaction();
			user = session.get(User.class, id);
			session.delete(user);
			transaction.commit();
			
		}catch(Exception e) {
			result = false;
			if(transaction !=null) {
				transaction.rollback();
			}
		}finally {
			session.close();
		}
		
		return result;
	}

	@Override
	public User getUserById(long id) {
		Transaction transaction = null;
		Session session = null;
		User user = null;
		
		
		try{
			session = sessionFactory.openSession();
	
			// begin transaction
			transaction = session.beginTransaction();
			user = session.get(User.class,id);
			transaction.commit();
		
		}catch(Exception e) {
			if(transaction !=null) {
				transaction.rollback();
			}
		}
		
		return user;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<User> getAllUser() {
		Session session= null;
		Transaction transaction = null;
        List <User> users = null;
        try {
        	session = sessionFactory.openSession();
            // start the transaction
            transaction = session.beginTransaction();
            // get users
            users = session.createQuery("from User").getResultList();
            // commit the transaction
            transaction.commit();
        } catch (Exception e) {
            users = null;
            if(transaction !=null) {
				transaction.rollback();
			}
        }finally {
        	session.close();
        }
        return users;
	}

}
