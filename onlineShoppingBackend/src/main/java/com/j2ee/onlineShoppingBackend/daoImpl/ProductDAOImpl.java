package com.j2ee.onlineShoppingBackend.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.j2ee.onlineShoppingBackend.dao.ProductDAO;
import com.j2ee.onlineShoppingBackend.dto.Product;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Product> list() {
		String productFetchQuery ="FROM Product";
		Query query = sessionFactory.getCurrentSession().createQuery(productFetchQuery,Product.class);
		return query.getResultList();
	}

	@Override
	public Product get(int productId) {
		
		try {
			return sessionFactory.getCurrentSession().get(Product.class, productId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean add(Product product) {
		
		try {
			sessionFactory.getCurrentSession().persist(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		
	}

	@Override
	public boolean update(Product product) {
		
		try {
			// updating product to DB
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Product product) {
		
		product.setActive(false);

		try {
			// updating category to DB
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Product> listActiveProducts() {
		String activeProductFetchQuery = "FROM Product where active = :active";
		return sessionFactory.getCurrentSession().createQuery(activeProductFetchQuery,Product.class)
				.setParameter("active", true).getResultList();
	}

	@Override
	public List<Product> listActiveProductsByCategory(int categoryId) {
		String activeProductByCategoryFetchQuery = "FROM Product where active = :active AND categoryId = :categoryId";
		return sessionFactory.getCurrentSession().createQuery(activeProductByCategoryFetchQuery,Product.class)
				.setParameter("active", true)
				.setParameter("categoryId", categoryId)
				.getResultList();
	}

	@Override
	public List<Product> getLatestActiveProducts(int count) {
		
		String latestActiveProductsQuery = "FROM Product where active = :active ORDER BY id";
		return sessionFactory.getCurrentSession()
				.createQuery(latestActiveProductsQuery,Product.class)
				.setParameter("active", true)
				.setFirstResult(0).setMaxResults(count)
				.getResultList();
	}

}
