package com.j2ee.onlineShoppingBackend.daoImpl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.j2ee.onlineShoppingBackend.dao.CategoryDAO;
import com.j2ee.onlineShoppingBackend.dto.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO{

	private static List<Category> categories = new ArrayList<Category>();
	
	static {
		Category category = new Category(1, "Television", "This is description for Television", "television.png", true);
		Category category1 = new Category(2, "Mobile", "This is description for Mobile", "mobile.png", true);
		Category category2 = new Category(3, "Laptop", "This is description for Laptop", "laptop.png", true);
		categories.add(category);
		categories.add(category1);
		categories.add(category2);
		
		
	}
	
	public List<Category> list() {
		return categories;
	}

	public Category getCategory(int id) {
		Category category = categories.stream().filter(c-> c.getId()==id)
				.findAny()
				.orElse(null);
		
		return category;
	}

}
