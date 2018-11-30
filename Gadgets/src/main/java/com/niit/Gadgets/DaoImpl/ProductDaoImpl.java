package com.niit.Gadgets.DaoImpl;

import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.Gadgets.Dao.ProductDao;

import com.niit.Gadgets.Model.Product;

@Transactional
@Repository("productDao")
public class ProductDaoImpl implements ProductDao

{
	@Autowired
    SessionFactory sessionFactory;
    
    public ProductDaoImpl(SessionFactory sessionFactory)
    {
    	this.sessionFactory=sessionFactory;
    }
    
	@Override
	public boolean saveorupdate(Product product) {
		sessionFactory.getCurrentSession().saveOrUpdate(product);
		return true;
	}

	@Override
	public boolean delete(Product product) {
		sessionFactory.getCurrentSession().delete(product);
		return true;
	}

	@Override
	public Product getProduct(String ProductId) {
		String query = "from Product where productId='"+ProductId+ "'";
		Query  w = sessionFactory.getCurrentSession().createQuery(query);
		List<Product> list = (List<Product>)w.list();
		if(list==null || list.isEmpty())
			
return null;
		else
			return list.get(0);
	}

	@Override
	public List<Product> Productlist() {
		List<Product> product=(List<Product>)sessionFactory.getCurrentSession()
				.createCriteria(Product.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
				
				return product;
			}
}
