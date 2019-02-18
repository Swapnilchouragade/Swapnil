package com.alsis.shoppingcart.dao;

import com.alsis.shoppingcart.domain.Person;
/**
 * Define Person dao
 * @author RAJESH
 *
 */
public interface PersonDao {

	//Find person by username
	Person find(String username); 
	
	//Register person
	boolean register (Person person); 
	
}

