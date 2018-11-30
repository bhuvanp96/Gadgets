package com.niit.Gadgets.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.Gadgets.Dao.PayDao;
import com.niit.Gadgets.Model.Pay;

@Transactional
@Repository("payDao")

public class PayDaoImpl implements PayDao
{
	@Autowired
    SessionFactory sessionFactory;
    
    public PayDaoImpl(SessionFactory sessionFactory)
    {
    	this.sessionFactory=sessionFactory;
    }

	@Override
	public boolean saveorupdate(Pay pay) {
		sessionFactory.getCurrentSession().saveOrUpdate(pay);
		return true;
	}

	@Override
	public boolean delete(Pay pay) {
		sessionFactory.getCurrentSession().delete(pay);
		return true;
	}

	@Override
	public Pay getPay(String Pay_Id) {
		String query = "from Pay where Pay_Id='"+Pay_Id+ "'";
		Query  w = sessionFactory.getCurrentSession().createQuery(query);
		List<Pay> list = (List<Pay>)w.list();
		if(list==null || list.isEmpty())
			
return null;
		else
			return list.get(0);
	}
	
		

	@Override
	public List<Pay> Paylist() {
		List<Pay> pay=(List<Pay>)sessionFactory.getCurrentSession()
		.createCriteria(Pay.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		
		return pay;
	}
		
}
