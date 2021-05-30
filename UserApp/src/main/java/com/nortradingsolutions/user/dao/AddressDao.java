/**
 * 
 */
package com.nortradingsolutions.user.dao;

import java.util.List;

import com.nortradingsolutions.user.model.Address;

/**
 * @author Vigil Varghese
 *
 */
public interface AddressDao {

    /**
     * 
     * @param address1
     */
    void saveAddress(Address address1);
    /**
     * 
     * @param address1
     */
    void updateAddress(Address address1);
    /**
     * 
     * @param id
     */
    void deleteAddress(long id);
    /**
     * 
     * @param id
     * @return
     */
    Address getAddressById(long id);
    
    /**
     * 
     * @param userid
     * @return
     */
    List<Address> getAddressByUserId(long userid);
}
