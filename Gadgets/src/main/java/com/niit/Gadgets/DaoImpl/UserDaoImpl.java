package com.niit.Gadgets.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.Gadgets.Dao.UserDao;
import com.niit.Gadgets.Model.Authentication;
import com.niit.Gadgets.Model.Billing;
import com.niit.Gadgets.Model.Category;
import com.niit.Gadgets.Model.User;
@Transactional
@Repository("userDao")
public class UserDaoImpl implements UserDao
{
	@Autowired
    SessionFactory sessionFactory;
    
    public UserDaoImpl(SessionFactory sessionFactory)
    {
    	this.sessionFactory=sessionFactory;
    }
    
	@Override
	public boolean saveorupdate(User user) {
		Authentication auth=new Authentication();
		auth.setUsername(user.getUserEmailId());
		Billing bill = new Billing();
		bill.setBillingAddress(user.getUserAddress());
		bill.setBillingName(user.getUserName());
		bill.setBillingPhno(user.getUserPhno());
		bill.setUser(user);
		user.setBilling(bill);
		sessionFactory.getCurrentSession().saveOrUpdate(bill);
		sessionFactory.getCurrentSession().saveOrUpdate(auth);
		sessionFactory.getCurrentSession().saveOrUpdate(user);
		return true;
	}

	@Override
	public boolean delete(User user) {
		sessionFactory.getCurrentSession().delete(user);
		return true;
	}

	@Override
	public User getUser(String UserId) {
		String query = "from User where userId='"+UserId+ "'";
		Query  w = sessionFactory.getCurrentSession().createQuery(query);
		List<User> list = (List<User>)w.list();
		if(list==null || list.isEmpty())
			
return null;
		else
			return list.get(0);
	}

	@Override
	public List<User> Userlist() {
		List<User> user=(List<User>)sessionFactory.getCurrentSession()
				.createCriteria(User.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
				
				return user;
			}
	

public User isValid(String umail, String pwd) {
		String u1="from User where UserEmailId='"+umail+"'and password='"+pwd+"'";
		Query q1=sessionFactory.getCurrentSession().createQuery(u1);
		List<User> list=(List<User>) q1.list();
		if(list==null || list.isEmpty())
		{		
		return null;
	}
		else
		{
			return list.get(0);
		}
	}

@Override
public User getEmail(String currusername) {
	String u1="from User where UserEmailId='"+currusername+"'";
	Query q1=sessionFactory.getCurrentSession().createQuery(u1);
	List<User> list=(List<User>) q1.list();
	if(list==null || list.isEmpty())
	{		
	return null;
}
	else
	{
		return list.get(0);
	}

}
	
	
}
