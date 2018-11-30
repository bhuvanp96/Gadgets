package com.niit.Gadgets.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.Gadgets.Dao.CategoryDao;
import com.niit.Gadgets.Model.Category;

@Transactional
@Repository("categoryDao")
public class CategoryDaoImpl implements CategoryDao
{
    @Autowired
    SessionFactory sessionFactory;
    
    public CategoryDaoImpl(SessionFactory sessionFactory)
    {
    	this.sessionFactory=sessionFactory;
    }

	@Override
	public boolean saveorupdate(Category category) {
		sessionFactory.getCurrentSession().saveOrUpdate(category);
		return true;
	}

	@Override
	public boolean delete(Category category) {
		sessionFactory.getCurrentSession().delete(category);
		return true;
	}

	@Override
	public Category getCategory(String CategoryId) {
		String query = "from Category where categoryId='"+CategoryId+ "'";
		Query  w = sessionFactory.getCurrentSession().createQuery(query);
		List<Category> list = (List<Category>)w.list();
		if(list==null || list.isEmpty())
			
return null;
		else
			return list.get(0);
	}
	
		

	@Override
	public List<Category> Categorylist() {
		List<Category> category=(List<Category>)sessionFactory.getCurrentSession()
		.createCriteria(Category.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		
		return category;
	}
    
	

}
