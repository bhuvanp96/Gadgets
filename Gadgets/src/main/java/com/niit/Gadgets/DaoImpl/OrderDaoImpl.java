package com.niit.Gadgets.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.Gadgets.Dao.OrderDao;
import com.niit.Gadgets.Model.Order;

@Transactional
@Repository("orderDao")
public class OrderDaoImpl implements OrderDao
{
	@Autowired
    SessionFactory sessionFactory;
    
    public OrderDaoImpl(SessionFactory sessionFactory)
    {
    	this.sessionFactory=sessionFactory;
    }

	@Override
	public boolean saveorupdate(Order order) {
		sessionFactory.getCurrentSession().saveOrUpdate(order);
		return true;
	}

	@Override
	public boolean delete(Order order) {
		sessionFactory.getCurrentSession().delete(order);
		return true;
	}

	@Override
	public Order getOrder(String Order_Id) {
		String query = "from Order where Order_Id='"+Order_Id+ "'";
		Query  w = sessionFactory.getCurrentSession().createQuery(query);
		List<Order> list = (List<Order>)w.list();
		if(list==null || list.isEmpty())
			
return null;
		else
			return list.get(0);
	}
	
		

	@Override
	public List<Order> Orderlist() {
		List<Order> order=(List<Order>)sessionFactory.getCurrentSession()
		.createCriteria(Order.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		
		return order;
	}

}
