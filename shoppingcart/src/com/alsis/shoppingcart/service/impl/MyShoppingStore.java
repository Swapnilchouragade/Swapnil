package com.alsis.shoppingcart.service.impl;

import java.util.List;

import com.alsis.shoppingcart.dao.ItemDao;
import com.alsis.shoppingcart.dao.PersonDao;
import com.alsis.shoppingcart.dao.PersonItemDao;
import com.alsis.shoppingcart.dao.impl.ItemDaoImpl;
import com.alsis.shoppingcart.dao.impl.PersonDaoImpl;
import com.alsis.shoppingcart.dao.impl.PersonItemDaoImpl;
import com.alsis.shoppingcart.domain.Item;
import com.alsis.shoppingcart.domain.Person;
import com.alsis.shoppingcart.service.Store;

public class MyShoppingStore implements Store{
	private ItemDao iDao = new ItemDaoImpl();
	private PersonDao pDao = new PersonDaoImpl();
	private PersonItemDao piDoa = new PersonItemDaoImpl();
	
	@Override
	public void displayItemsInStore() {
		
		List<Item> items = iDao.findAllItems();
		
		System.out.println("\nItems in the store : ");
		for(Item i : items){
			System.out.println(i);
		}
		
	}

	@Override
	public void addItemToCart(long itemId, Person person) {
		piDoa.addItemtoCart(itemId, person);
		System.out.println("\nItem "+ itemId +" was added !");
		
	}

	@Override
	public void removeItemFromCart(long itemId, Person person) {
		piDoa.removeItemFromCart(itemId, person);
		System.out.println("\nItem " +itemId+ " was removed !");
		
	}

	@Override
	public void showItemsCart(Person person) {
		List<Item> items = piDoa.findAllItemsByPersonId(person);
		if(items!=null){
			System.out.println("\nYour cart "+ person.getUsername()+"   :");
			for(Item i : items){
				System.out.println(i);
			}
		}else{
			System.out.println("\nYour cart "+ person.getUsername()+" is empty ");
		}
		
	}

	@Override
	public boolean register(Person person) {
		 boolean b= pDao.register(person);
		 if(!b){
			 System.out.println(person.getUsername() + " could not be registered");
		 }else{
			 System.out.println(person.getUsername() + " was registered");
		 }
		 return b;
	}

	@Override
	public Person authenticatePerson(String username, String password) {

		Person person = pDao.find(username);
		if(person==null)
			return null;
		else{
			if(person.getPassword()!=null&&person.getPassword().equals(password)){
				return person;
			}
			else{
				return null; 
			}
		}
	}


	

}
