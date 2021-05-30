package com.nortradingsolutions.user;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.nortradingsolutions.user.dao.AddressDao;
import com.nortradingsolutions.user.dao.UserDao;
import com.nortradingsolutions.user.daoImpl.AddressDaoImpl;
import com.nortradingsolutions.user.daoImpl.UserDaoImpl;
import com.nortradingsolutions.user.model.Address;
import com.nortradingsolutions.user.model.User;

import com.nortradingsolutions.user.util.OptionsUtil;

/**
 * 
 * @author Vigil Varghese
 *
 */
public class App {
	
    private static int id;
	private static String firstName;
	private static String lastName;
	private static String city;
	private static String state;
	private static String street;
	private static String postalCode;
	
	/**
	 * 
	 * @param args
	 * @throws ExceptionHandle 
	 */
	
	public static void main(String args[]) {
			
		UserDao userDao = new UserDaoImpl();
		User user = new User();
		Address address= new Address();
		AddressDao addressDao = new AddressDaoImpl();
		List<Address>adds= addressDao.getAddressByUserId(3);
		Scanner console = new Scanner(System.in);
		try { 			
		OptionsUtil.MENU = OptionsUtil.displayMenu(OptionsUtil.options, OptionsUtil.MENU, console,"Select an option: ");
		
		while( OptionsUtil.MENU <=OptionsUtil.options.size()) {
        		switch(OptionsUtil.MENU) {
        				
        		case 1:
        			System.out.println("Adding New Person");
        			System.out.println("-----------------");
        			System.out.println("First Name: ");
        			
        			firstName = console.next();
        			System.out.println("last Name: ");
        			
        			lastName = console.next();
        			user = new User(firstName, lastName);
        			
        			userDao.saveUser(user);
        			System.out.println("-------------------------------\n");
        			OptionsUtil.MENU =OptionsUtil.displayMenu(OptionsUtil.options, OptionsUtil.MENU, console,"Select an option: ");
        			break;
        					
        		case 2:
        		    System.out.println("Edit Person");
        			System.out.println("-----------------");
        			System.out.println("Enter ID of the Person to Edit: ");
        			id = console.nextInt();
        						
        			user = userDao.getUserById(id);
        			adds = addressDao.getAddressByUserId(user.getId());
        			OptionsUtil.personRecords(user,userDao,id);
        			OptionsUtil.personAddress(adds);
        					
        			// get user selection
        			OptionsUtil.SUB_MENU = OptionsUtil.displayMenu(OptionsUtil.subOptions1, OptionsUtil.SUB_MENU, console,"Select an option: ");
        			while(OptionsUtil.SUB_MENU <OptionsUtil.subOptions1.size()) {
                			switch(OptionsUtil.SUB_MENU) {
                			case 1:
                				System.out.println("Update First Name: ");
                				
                				firstName = console.next();
                				user.setFirstName(firstName);
                				userDao.updateUser(user);
                				OptionsUtil.SUB_MENU = OptionsUtil.displayMenu(OptionsUtil.subOptions1, OptionsUtil.SUB_MENU, console,"Select an option: ");
                				break;
                			case 2:
                				System.out.println("Update Last Name: ");
                				
                				lastName = console.next();
                				user.setLastName(lastName);
                				userDao.updateUser(user);
                				OptionsUtil.SUB_MENU = OptionsUtil.displayMenu(OptionsUtil.subOptions1, OptionsUtil.SUB_MENU, console,"Select an option: ");
                				break;
                			case 3:
                				System.out.println("Returning to main menu");
                				break;
                				
                			}
        			
        			}
        			OptionsUtil.MENU =OptionsUtil.displayMenu(OptionsUtil.options, OptionsUtil.MENU, console,"Select an option: ");
        			break;
        			
        		case 3:
        		    System.out.println("Delete Person");
        			System.out.println("-----------------");
        			System.out.println("Enter ID of the Person to Delete: ");
        			id = console.nextInt();
        						
        			user = userDao.getUserById(id);
        			OptionsUtil.personRecords(user,userDao,id);
        			System.out.println("Do you confirm to delete the person?(Y/N)");
        			String response = console.next();
        			if(response.equalsIgnoreCase("y")) {
        			    
        			   adds = addressDao.getAddressByUserId(user.getId());
        			   for(Address pAddress: adds) {
        			       addressDao.deleteAddress(pAddress.getId());
        			   }
        			   userDao.deleteUser(user.getId());
        			   System.out.println("Person Record with id: "+ user.getId() + " deleted successfully");
        			}else if(response.equalsIgnoreCase("n")) {
        			    System.out.println("Cancelled");
        			}
        			OptionsUtil.MENU =OptionsUtil.displayMenu(OptionsUtil.options, OptionsUtil.MENU, console,"Select an option: ");
        			break;
        			
        		case 4:
            		System.out.println("Add Address");
        			System.out.println("-----------------");
        			System.out.println("Enter ID of the Person to Add Address: ");
        			id = console.nextInt();
        						
        			user = userDao.getUserById(id);
        			OptionsUtil.personRecords(user,userDao,id);
        			
        			
        			OptionsUtil.SUB_MENU = OptionsUtil.displayMenu(OptionsUtil.subOptions2, OptionsUtil.SUB_MENU, console, "Select an option: ");
        			while(OptionsUtil.SUB_MENU <OptionsUtil.subOptions2.size()) {
                			switch(OptionsUtil.SUB_MENU) {
                			case 1:
                				System.out.println("Add Address");
                				
                				System.out.println("Street: ");
                				street = console.next();
                				System.out.println("City: ");
                				city = console.next();
                				System.out.println("State: ");
                				state = console.next();
                				System.out.println("Postsal Code: ");
                				postalCode = console.next();
                				address = new Address(user.getId(),street,city,state,postalCode);
                				
                				address.setUser(user);
                				addressDao.saveAddress(address);
                				OptionsUtil.SUB_MENU = OptionsUtil.displayMenu(OptionsUtil.subOptions2, OptionsUtil.SUB_MENU, console,"Select an option: ");
                				break;
                			
                			case 2:
                				System.out.println("Returning to main menu");
                				break;
                				
                			}
        			}
        			
        		    OptionsUtil.MENU =OptionsUtil.displayMenu(OptionsUtil.options, OptionsUtil.MENU, console,"Select an option: ");
        			break;
        			
        		case 5:
        		  System.out.println("Edit Address");
                  System.out.println("-----------------");
                  System.out.println("Enter ID of the Person to Select Address: ");
                  id = console.nextInt();
                              
                  user = userDao.getUserById(id);
                  adds = addressDao.getAddressByUserId(user.getId());
                  OptionsUtil.personRecords(user,userDao,id);
                  OptionsUtil.personAddress(adds);
                   
                  System.out.println("Enter Address ID to edit: ");
                  id = console.nextInt();
                  address = addressDao.getAddressById(id);
                  // get user selection
                  OptionsUtil.SUB_MENU = OptionsUtil.displayMenu(OptionsUtil.subOptions3, OptionsUtil.SUB_MENU, console,"Select an option: ");
                  while(OptionsUtil.SUB_MENU <OptionsUtil.subOptions3.size()) {
                          switch(OptionsUtil.SUB_MENU) {
                          case 1:
                              System.out.println("Update street: ");
                              
                              street = console.next();
                              address.setStreet(street);
                              addressDao.updateAddress(address);
                              System.out.println("Street Upated Successfully");
                              OptionsUtil.SUB_MENU = OptionsUtil.displayMenu(OptionsUtil.subOptions3, OptionsUtil.SUB_MENU, console,"Select an option: ");
                              break;
                          case 2:
                              System.out.println("Update City: ");
                              
                              city = console.next();
                              address.setCity(city);
                              addressDao.updateAddress(address);
                              System.out.println("City Upated Successfully");
                              OptionsUtil.SUB_MENU = OptionsUtil.displayMenu(OptionsUtil.subOptions3, OptionsUtil.SUB_MENU, console,"Select an option: ");
                              break;
                          case 3:
                              System.out.println("Update State: ");
                              
                              state = console.next();
                              address.setState(state);
                              addressDao.updateAddress(address);
                              System.out.println("State Upated Successfully");
                              OptionsUtil.SUB_MENU = OptionsUtil.displayMenu(OptionsUtil.subOptions3, OptionsUtil.SUB_MENU, console,"Select an option: ");
                              break;
                          case 4:
                              System.out.println("Update Postal Code: ");
                              
                              postalCode = console.next();
                              address.setPostalCode(postalCode);
                              addressDao.updateAddress(address);
                              System.out.println("Postal Code Upated Successfully");
                              OptionsUtil.SUB_MENU = OptionsUtil.displayMenu(OptionsUtil.subOptions3, OptionsUtil.SUB_MENU, console,"Select an option: ");
                              break;
                          case 5:
                              System.out.println("Returning to main menu");
                              break;
                              
                          }
                  
                  }
                  OptionsUtil.MENU =OptionsUtil.displayMenu(OptionsUtil.options, OptionsUtil.MENU, console,"Select an option: ");
                  break;
        			
        		case 6:
        		    System.out.println("Delete Address");
        			System.out.println("-----------------");
        			System.out.println("Enter ID of the Person to Delete Address: ");
        			id = console.nextInt();
        						
        			user = userDao.getUserById(id);
        			adds = addressDao.getAddressByUserId(user.getId());
        			OptionsUtil.personRecords(user,userDao,id);
        			OptionsUtil.personAddress(adds);
        			
        			System.out.println("Do you confirm to delete the Address?(Y/N)");
        			response = console.next();
        			if(response.equalsIgnoreCase("y")) {
        			    
        			   address = addressDao.getAddressById(id);
        			   
        			   addressDao.deleteAddress(address.getId());
        			   System.out.println("Address Record with id: "+ address.getId() + " deleted successfully");
        			}else if(response.equalsIgnoreCase("n")) {
        			   System.out.println("Cancelled");
        			}
    			
        		    OptionsUtil.MENU =OptionsUtil.displayMenu(OptionsUtil.options, OptionsUtil.MENU, console,"Select an option: ");
        			break;
        			
        		case 7:
        			List<User>users = userDao.getAllUser();
        			System.out.println("Number of Persons: "+users.size());
        			System.out.println("-------------------------------\n");
        			OptionsUtil.MENU =OptionsUtil.displayMenu(OptionsUtil.options, OptionsUtil.MENU, console,"Select an option: ");
        			break;
        			
        		case 8:
        			users = userDao.getAllUser();
        			int count = 1;
        			for(User person :users){
        				System.out.println("Record: " + count +"\n");
        				OptionsUtil.personDetails(person);
        				adds = addressDao.getAddressByUserId(person.getId());
        				OptionsUtil.personAddress(adds);
        				count+=1;
        				
        			}
        			
        			OptionsUtil.MENU =OptionsUtil.displayMenu(OptionsUtil.options, OptionsUtil.MENU, console,"Select an option: ");
        			break;
        			
        		case 9:
        			
        			System.out.println("Exiting Application");
        			System.exit(0);
        		}
		}
	
		}catch(NullPointerException e) {
		  System.out.println("Record does not Exist for given id");
		  
		  
          
		}catch(InputMismatchException e) {
          System.out.println("Invalid input, please check the value entered");
          
          
        }
		System.exit(0);
	}
	
}


