package com.alsis.shoppingcart.dao;

import java.util.List;

import com.alsis.shoppingcart.domain.Item;
/**
 * Define Item dao
 * @author RAJESH
 *
 */
public interface ItemDao {

	Item findItemById(long id);

	List<Item> findAllItems();

}
