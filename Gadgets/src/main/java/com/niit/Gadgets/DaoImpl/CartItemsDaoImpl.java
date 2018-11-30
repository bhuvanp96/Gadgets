package com.niit.Gadgets.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.Gadgets.Dao.CartItemsDao;
import com.niit.Gadgets.Model.CartItems;

@Transactional
@Repository("cartItemsDao")
public class CartItemsDaoImpl implements CartItemsDao 
{
	@Autowired
    SessionFactory sessionFactory;
    
    public CartItemsDaoImpl(SessionFactory sessionFactory)
    {
    	this.sessionFactory=sessionFactory;
    }

	@Override
	public boolean saveorupdate(CartItems cartItems) {
		sessionFactory.getCurrentSession().saveOrUpdate(cartItems);
		return true;
	}

	@Override
	public boolean delete(CartItems cartItems) {
		sessionFactory.getCurrentSession().delete(cartItems);
		return true;
	}

	@Override
	public CartItems getCartItems(String Cartitem_Id) {
		String query = "from CartItems where Cartitem_Id='"+Cartitem_Id+ "'";
		Query  w = sessionFactory.getCurrentSession().createQuery(query);
		List<CartItems> list = (List<CartItems>)w.list();
		if(list==null || list.isEmpty())
			
return null;
		else
			return list.get(0);
	}
	
		

	@Override
	public List<CartItems> CartItemslist() {
		List<CartItems> cartItems=(List<CartItems>)sessionFactory.getCurrentSession()
		.createCriteria(CartItems.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		
		return cartItems;
	}

	@Override
	public List<CartItems> getlist(String cart_Id) {
		String query = "from CartItems where Cart_Id='"+cart_Id+ "'";
		Query  w = sessionFactory.getCurrentSession().createQuery(query);
		List<CartItems> list = (List<CartItems>)w.list();
		if(list==null || list.isEmpty())		
			
			return null;
		else
			return list;
	}

	
}
