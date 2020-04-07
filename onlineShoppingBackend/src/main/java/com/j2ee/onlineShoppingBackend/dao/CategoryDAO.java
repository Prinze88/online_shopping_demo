package com.j2ee.onlineShoppingBackend.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.j2ee.onlineShoppingBackend.dto.Category;

public interface CategoryDAO {

	List<Category> list();

	Category getCategory(int id);
}
