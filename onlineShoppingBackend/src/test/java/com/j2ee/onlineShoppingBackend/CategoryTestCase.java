package com.j2ee.onlineShoppingBackend;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.j2ee.onlineShoppingBackend.dao.CategoryDAO;
import com.j2ee.onlineShoppingBackend.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;
	private static CategoryDAO categoryDAO;
	
	private Category category;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.j2ee.onlineShoppingBackend");
		context.refresh();
		categoryDAO = (CategoryDAO)context.getBean("categoryDAO");
		
	}
	
	
//	@Test
//	public void testAddCategory() {
//		category = new Category("LCD", "This is description for LCD", "lcd.png", true);
//		assertEquals("Successfully added in table", true,categoryDAO.add(category));
//		
//	}
	
	
	
//	@Test
//	public void testGetCategoryBasedOnId() {
//		category = categoryDAO.getCategory(2);
//		assertEquals("Successfully fetched category from DB ", "LCD", category.getName());
//	}

	
//	@Test
//	public void testUpdateCategory() {
//		category = categoryDAO.getCategory(2);
//		category.setName("Television");
//		category.setDescription("This is description for Television");
//		category.setImageUrl("television.png");
//		assertEquals("Successfully updated category from DB ", true, categoryDAO.update(category));
//		category = categoryDAO.getCategory(2);
//		assertEquals("Checking the updated value ", "Television", category.getName());
//	}

//	@Test
//	public void testDeleteCategory() {
//		category = categoryDAO.getCategory(2);
//		assertEquals("Successfully deleted category from DB ", true, categoryDAO.delete(category));
//	}
	
	@Test
	public void testFetchActiveCategory() {
		assertEquals("Successfully Fetched all Active category from DB ", 1, categoryDAO.list().size());
	}
}
