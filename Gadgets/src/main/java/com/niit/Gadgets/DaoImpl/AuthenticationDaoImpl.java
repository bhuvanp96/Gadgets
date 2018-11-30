package com.niit.Gadgets.DaoImpl;

import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.Gadgets.Dao.AuthenticationDao;
import com.niit.Gadgets.Model.Authentication;

@Transactional
@Repository("authenticationDao")
public class AuthenticationDaoImpl implements AuthenticationDao 
{

	@Autowired
    SessionFactory sessionFactory;
    
    public AuthenticationDaoImpl(SessionFactory sessionFactory)
    {
    	this.sessionFactory=sessionFactory;
    }

	@Override
	public boolean saveorupdate(Authentication authentication) {
		sessionFactory.getCurrentSession().saveOrUpdate(authentication);
		return true;
	}

	@Override
	public boolean delete(Authentication authentication) {
		sessionFactory.getCurrentSession().delete(authentication);
		return true;
	}

	@Override
	public Authentication getAuthentication(String rId) {
		String query = "from Authentication where rId='"+rId+ "'";
		Query  w = sessionFactory.getCurrentSession().createQuery(query);
		List<Authentication> list = (List<Authentication>)w.list();
		if(list==null || list.isEmpty())
			
return null;
		else
			return list.get(0);
	}
	
		

	@Override
	public List<Authentication> Authenticationlist() {
		List<Authentication> authentication=(List<Authentication>)sessionFactory.getCurrentSession()
		.createCriteria(Authentication.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		
		return authentication;
	}

}
