package com.j2ee.onlineShoppingBackend.dao;

import java.util.List;

import com.j2ee.onlineShoppingBackend.dto.Product;

public interface ProductDAO {

	List<Product> list();
	
	Product get(int productId);
	
	boolean add(Product category);
	
	boolean update(Product category);
	
	boolean delete(Product category);
	
	
	//business methods
	List<Product> listActiveProducts();
	List<Product> listActiveProductsByCategory(int categoryId);
	List<Product> getLatestActiveProducts(int count);
}
