package com.alsis.shoppingcart.service;

import com.alsis.shoppingcart.domain.Person;

/**
 * Define store interface
 * @author RAJESH
 *
 */
public interface Store {

	void displayItemsInStore();

	void removeItemFromCart(long itemId, Person person);

	void showItemsCart(Person person);

	boolean register(Person person);

	Person authenticatePerson(String username, String password);

	void addItemToCart(long itemId, Person person);

}
