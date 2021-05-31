/**
 * 
 */
package com.nortradingsolutions.user.daoImpl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nortradingsolutions.user.dao.AddressDao;
import com.nortradingsolutions.user.model.Address;
import com.nortradingsolutions.user.util.HibernateConfig;


/**
 * @author Vigil Varghese
 *
 */
public class AddressDaoImpl implements AddressDao {

    private SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
    
    @Override
    public void saveAddress(Address address) {
	Transaction transaction = null;
	Session session = null;
	try {
	    	session = sessionFactory.openSession();
	    	
	    	//begin transaction
	    	transaction = session.beginTransaction();
	    	session.save(address);
	    	transaction.commit();
	    	System.out.println("Address1 added to the Person");
	    	
	}catch(Exception e) {
	    if(transaction !=null) {
		transaction.rollback();
	    }
	}finally {
	    session.close();
	}
	
    }

    @Override
    public void updateAddress(Address address) {
	Session session= null;
	Transaction transaction = null;
	
	try{
		session = sessionFactory.openSession();
		// begin transaction
		
		transaction = session.beginTransaction();
		
		session.update(address);
		transaction.commit();
		
		
	}catch(Exception e) {
		if(transaction !=null) {
		    transaction.rollback();
		}
	}finally {
		session.close();
	}
	
    }

    @Override
    public void deleteAddress(long id) {
	Transaction transaction = null;
	Session session = null;
	Address address1 = null;
	
	try{
		session = sessionFactory.openSession();
		// begin transaction
		
		transaction = session.beginTransaction();
		
		address1 = session.get(Address.class, id);
		session.delete(address1);
		transaction.commit();
		
		
	}catch(Exception e) {
	    
	     
		if(transaction !=null) {
		    transaction.rollback();
		}
	}finally {
		session.close();
	}
	
    }
    
    @Override
    public Address getAddressById(long id) {
	Transaction transaction = null;
	Session session = null;
	Address address1 = null;
		
	try{
		session = sessionFactory.openSession();
		// begin transaction
			
		transaction = session.beginTransaction();
			
		address1 = session.get(Address.class,id);
		transaction.commit();
			
			
	}catch(Exception e) {
		if(transaction !=null) {
		    transaction.rollback();
		}
	}
		
		return address1;
	}

    @SuppressWarnings("unchecked")
    @Override
    public List<Address> getAddressByUserId(long userid) {
	Transaction transaction = null;
	Session session = null;
	List<Address> address = null;
		
	try{
		session = sessionFactory.openSession();
		// begin transaction
			
		transaction = session.beginTransaction();
		Query query = session.createQuery("from Address where userid= :userid");	
		query.setParameter("userid", userid);
		address = query.getResultList();
		transaction.commit();
			
			
	}catch(Exception e) {
		if(transaction !=null) {
		    transaction.rollback();
		}
	}
		
		return address;
    }

}
