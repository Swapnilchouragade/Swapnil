package com.alsis.shoppingcart.dao;

import java.util.List;

import com.alsis.shoppingcart.domain.Item;
import com.alsis.shoppingcart.domain.Person;
/**
 * Define PersonItem dao
 * @author RAJESH
 *
 */
public interface PersonItemDao {
		
		List<Item> findAllItemsByPersonId(Person person);

		boolean removeItemFromCart(long itemId, Person person);

		boolean addItemtoCart(long itemId, Person person);
	
}
