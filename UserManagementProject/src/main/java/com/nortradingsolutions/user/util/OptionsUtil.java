/**
 * 
 */
package com.nortradingsolutions.user.util;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import com.nortradingsolutions.user.dao.UserDao;
import com.nortradingsolutions.user.model.Address;
import com.nortradingsolutions.user.model.User;


/**
 * @author Vigil Varghese
 *
 */
public class OptionsUtil {

     public static int MENU = 0;
     public static int SUB_MENU = 0;
     public static  List<String> options = Arrays.asList(
		"1) Add Person",
		"2) Edit Person",
		"3) Delete Person",
		"4) Add Address to Person",
		"5) Edit Address",
		"6) Delete Address",
		"7) Count Number of Person",
		"8) List Persons",
		"9) Exit"
	     );
     public static List<String> subOptions1 = Arrays.asList(
		"1) Edit First Name",
		"2) Edit Last Name",
		"3) Return to Main Menu"
	     );
     
     public static List<String> subOptions2 = Arrays.asList(
		"1) Address ",
		"2) Return to Main Menu"
	     );
     
     public static List<String> subOptions3 = Arrays.asList(
		"1) Street",
		"2) City",
		"3) State",
		"4) Postal Code",
		"5) Return to Main Menu"
	     );
   

    /**
     * 
     * @param options
     * @param menu
     * @param console
     * @param param
     * @return
     */
    public static int displayMenu(List<String> options,int menu, Scanner console, String param) {
	
	System.out.println("\nOptions: \n");
	options.forEach(System.out::println);

	// get user selection
	System.out.println("\n"+param);
	return menu = console.nextInt();
    }
    
    /**
     * 
     * @param user
     * @param userDao
     * @param id
     */
    public static void personRecords(User user,UserDao userDao, long id) {
    user = userDao.getUserById(id);
	System.out.println("-----------------\n");
	System.out.println("Record details of person with id: " + id+"\n");
	personDetails(user);
    }
    
    /**
     * 
     * @param adds
     */
    public static void personAddress(List<Address>adds) {
	    if(!adds.isEmpty()) {
		    int count = 1;
		    for(Address pAddress : adds) {
			
			System.out.println("\nAddress "+count+"\n");
			System.out.println("Address ID: " + pAddress.getId());
			System.out.println("Street: " + pAddress.getStreet());
			System.out.println("City: " + pAddress.getCity());
			System.out.println("State: " + pAddress.getState());
			System.out.println("Postal Code: " + pAddress.getPostalCode()+"\n");
			count++;
		    }
		    
		}else {
		    System.out.println("No Address found for the user");
		}
		System.out.println("-------------------------------\n");
    }
    
    /**
     * 
     * @param user
     */
    public static void personDetails(User user) {
      System.out.println("Id:  "+user.getId());
      System.out.println("First Name:  "+ user.getFirstName());
      System.out.println("Last Name:  "+ user.getLastName());
      System.out.println("-------------------------------\n");
    }
    
   
}