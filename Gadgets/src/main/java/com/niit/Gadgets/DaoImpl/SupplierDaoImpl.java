package com.niit.Gadgets.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.Gadgets.Dao.SupplierDao;
import com.niit.Gadgets.Model.Product;
import com.niit.Gadgets.Model.Supplier;



@Transactional
@Repository("supplierDao")
public class SupplierDaoImpl implements SupplierDao

{

	@Autowired
    SessionFactory sessionFactory;
    
    public SupplierDaoImpl(SessionFactory sessionFactory)
    {
    	this.sessionFactory=sessionFactory;
    }
    
	@Override
	public boolean saveorupdate(Supplier supplier) {
		sessionFactory.getCurrentSession().saveOrUpdate(supplier);
		return true;
	}

	@Override
	public boolean delete(Supplier supplier) {
		sessionFactory.getCurrentSession().delete(supplier);
		return true;
	}

	@Override
	public Supplier getSupplier(String SupplierId) {
		String query = "from Supplier where supplierId='"+SupplierId+ "'";
		Query  w = sessionFactory.getCurrentSession().createQuery(query);
		List<Supplier> list = (List<Supplier>)w.list();
		if(list==null || list.isEmpty())
			
return null;
		else
			return list.get(0);
	}

	@Override
	public List<Supplier> Supplierlist() {
		List<Supplier> supplier=(List<Supplier>)sessionFactory.getCurrentSession()
				.createCriteria(Supplier.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
				
				return supplier;
			}
}