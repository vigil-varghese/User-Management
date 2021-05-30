/**
 * 
 */
package com.nortradingsolutions.user.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



/**
 * @author Vigil Varghese
 *
 */
@Entity
@Table(name = "address")
public class Address {
    
    @Column(name="id")   
    private long id;
   
    @Column(name="userid")
    private long userId;
    @Column(name = "street")
    private String street;
    
    @Column(name = "city")
    private String city;
    
    @Column(name = "state")
    private String state;
    
    @Column(name = "postalcode")
    private String postalCode;
    
    private User user;
    
     public Address() {
	super();
	
    }
    
    public Address(long userId,String street, String city, String state, String postalCode) {
	super();
	
	this.userId = userId;
	this.street = street;
	this.city = city;
	this.state = state;
	this.postalCode = postalCode;
    }
    
    
   
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    
   public long getuserId() {
        return userId;
    }

    public void setuserId(long userId) {
        this.userId = userId;
    }

    public String getStreet() {
        return street;
    }
    
    public void setStreet(String street) {
        this.street = street;
    }
    
    public String getCity() {
        return city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    
    public String getState() {
        return state;
    }
    
    public void setState(String state) {
        this.state = state;
    }
    
    public String getPostalCode() {
        return postalCode;
    }
    
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    
    @ManyToOne
    @JoinColumn(name="userid",updatable=false,insertable=false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    

    
    
    
}
