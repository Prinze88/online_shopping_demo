package com.j2ee.onlineShoppingBackend;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.j2ee.onlineShoppingBackend.dao.ProductDAO;
import com.j2ee.onlineShoppingBackend.dto.Product;

public class ProductTestCase {

	private static AnnotationConfigApplicationContext context;
	private static ProductDAO productDAO;
	
	private Product product;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.j2ee.onlineShoppingBackend");
		context.refresh();
		productDAO = (ProductDAO)context.getBean("productDAO");
		
	}
	
	
	@Test
	public void testCRUDProduct() {
		
		//test to add a product
		product = new Product("PRCODE7777LP", "MacBook", "Apple","Thin version of Mac", 120000, 5, true, 3, 3, 1, 10);
		assertEquals("Error while adding product to DB", true,productDAO.add(product));
		
		Product lastUpdateProduct = productDAO.list().get(productDAO.list().size()-1);
		
		
		//test get category based on id
		product = productDAO.get(lastUpdateProduct.getId());
		assertEquals("Error while fetching product from DB ", "MacBook", product.getName());
		
		//test update category
		product = productDAO.get(5);
		product.setName("Vostro15");
		product.setDescription("Upgraded to Vostro15");
		assertEquals("Error while updating the category in DB ", true, productDAO.update(product));
		
		product = productDAO.get(5);
		assertEquals("Error in data update ", "Vostro15", product.getName());
		
		//test delete category
		product = productDAO.get(lastUpdateProduct.getId());
		assertEquals("Error in deleting category in DB ", true, productDAO.delete(product));
		
		//test fetch active category
		assertEquals("Error in fetching active category from DB ", 7, productDAO.list().size());
		
		
		product = productDAO.get(6);
		product.setActive(false);
		assertEquals("Error while updating product status", true,productDAO.update(product));
		
		assertEquals("Error while fetching active product list ", 5,productDAO.listActiveProducts().size());
		
		assertEquals("Error while fetching active product list ", 1,productDAO.listActiveProductsByCategory(3).size());
		
		System.out.println(productDAO.getLatestActiveProducts(3));
		
		
		
	}
}
