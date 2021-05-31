package com.nortradingsolutions.user.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * @author Vigil Varghese
 *
 */

@Entity
@Table(name = "user")
public class User {
	
    @Column(name = "id")
	private long id;
    
    @Column(name = "firstName")
    private String firstName;
    
    @Column(name = "lastName")
	private String lastName;
	
    private List <Address> address;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public User() {
		super();
		
	}
	public User(long id,String firstName, String lastName) {
		
		this(firstName,lastName);
		this.id = id;
		
		
      
  }
	public User(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
      
  }
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="id")
	public List<Address> getAddress() {
	    return address;
	}

	public void setAddress(List<Address> address) {
	    this.address = address;
	}
	

}
