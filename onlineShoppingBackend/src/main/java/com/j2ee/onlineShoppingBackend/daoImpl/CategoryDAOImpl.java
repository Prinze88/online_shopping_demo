package com.j2ee.onlineShoppingBackend.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.j2ee.onlineShoppingBackend.dao.CategoryDAO;
import com.j2ee.onlineShoppingBackend.dto.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO{

	@Autowired
	private SessionFactory sessionFactory;

	public List<Category> list() {
		String activeCategoryFetchQuery ="FROM Category WHERE isActive = :active";
		Query query = sessionFactory.getCurrentSession().createQuery(activeCategoryFetchQuery);
		query.setParameter("active", true);
		return query.getResultList();
	}

	//getting single category based on id 
	public Category getCategory(int id) {
		return sessionFactory.getCurrentSession().get(Category.class,Integer.valueOf(id));
	}

	@Override
	public boolean add(Category category) {

		try {
			// adding category to DB
			sessionFactory.getCurrentSession().persist(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Category category) {
		try {
			// updating category to DB
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Category category) {

		category.setIsActive(false);

		try {
			// updating category to DB
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
