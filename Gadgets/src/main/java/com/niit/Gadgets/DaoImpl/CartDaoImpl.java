package com.niit.Gadgets.DaoImpl;

import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.Gadgets.Dao.CartDao;
import com.niit.Gadgets.Model.Cart;


@Transactional
@Repository("cartDao")

public class CartDaoImpl implements CartDao
{

	 @Autowired
	    SessionFactory sessionFactory;
	    
	    public CartDaoImpl(SessionFactory sessionFactory)
	    {
	    	this.sessionFactory=sessionFactory;
	    }

		@Override
		public boolean saveorupdate(Cart cart) {
			sessionFactory.getCurrentSession().saveOrUpdate(cart);
			return true;
		}

		@Override
		public boolean delete(Cart cart) {
			sessionFactory.getCurrentSession().delete(cart);
			return true;
		}

		@Override
		public Cart getCart(String Cart_Id) {
			String query = "from Cart where Cart_Id='"+Cart_Id+ "'";
			Query  w = sessionFactory.getCurrentSession().createQuery(query);
			List<Cart> list = (List<Cart>)w.list();
			if(list==null || list.isEmpty())
				
	return null;
			else
				return list.get(0);
		}
		
			

		@Override
		public List<Cart> Cartlist() {
			List<Cart> cart=(List<Cart>)sessionFactory.getCurrentSession()
			.createCriteria(Cart.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
			
			return cart;
		}
	    

	
	
}
