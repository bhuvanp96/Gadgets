package com.niit.Gadgets.Config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.Gadgets.Dao.AuthenticationDao;
import com.niit.Gadgets.Dao.BillingDao;
import com.niit.Gadgets.Dao.CartDao;
import com.niit.Gadgets.Dao.CartItemsDao;
import com.niit.Gadgets.Dao.CategoryDao;
import com.niit.Gadgets.Dao.OrderDao;
import com.niit.Gadgets.Dao.OrderItemsDao;
import com.niit.Gadgets.Dao.PayDao;
import com.niit.Gadgets.Dao.ProductDao;
import com.niit.Gadgets.Dao.ShippingDao;
import com.niit.Gadgets.Dao.SupplierDao;
import com.niit.Gadgets.Dao.UserDao;
import com.niit.Gadgets.DaoImpl.AuthenticationDaoImpl;
import com.niit.Gadgets.DaoImpl.BillingDaoImpl;
import com.niit.Gadgets.DaoImpl.CartDaoImpl;
import com.niit.Gadgets.DaoImpl.CartItemsDaoImpl;
import com.niit.Gadgets.DaoImpl.CategoryDaoImpl;
import com.niit.Gadgets.DaoImpl.OrderDaoImpl;
import com.niit.Gadgets.DaoImpl.OrderItemsDaoImpl;
import com.niit.Gadgets.DaoImpl.PayDaoImpl;
import com.niit.Gadgets.DaoImpl.ProductDaoImpl;
import com.niit.Gadgets.DaoImpl.ShippingDaoImpl;
import com.niit.Gadgets.DaoImpl.SupplierDaoImpl;
import com.niit.Gadgets.DaoImpl.UserDaoImpl;
import com.niit.Gadgets.Model.Authentication;
import com.niit.Gadgets.Model.Billing;
import com.niit.Gadgets.Model.Cart;
import com.niit.Gadgets.Model.CartItems;
import com.niit.Gadgets.Model.Category;
import com.niit.Gadgets.Model.Order;
import com.niit.Gadgets.Model.OrderItems;
import com.niit.Gadgets.Model.Pay;
import com.niit.Gadgets.Model.Product;
import com.niit.Gadgets.Model.Shipping;
import com.niit.Gadgets.Model.Supplier;
import com.niit.Gadgets.Model.User;

@Configuration
@ComponentScan("com.niit.*")
@EnableTransactionManagement
public class ApplicationContext 
{
	@Bean("dataSource")
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/test/gadget");
		dataSource.setUsername("bhuvanp");
		dataSource.setPassword("bhuvanp");
		return dataSource;
}
	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.connection.pool_size", "10");
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		return properties;
	}
	
	@Autowired
	@Bean("sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.addAnnotatedClass(Category.class);
		sessionBuilder.addAnnotatedClass(Product.class);
		sessionBuilder.addAnnotatedClass(Supplier.class);
		sessionBuilder.addAnnotatedClass(User.class);
		sessionBuilder.addAnnotatedClass(Authentication.class);
		sessionBuilder.addAnnotatedClass(Cart.class);
		sessionBuilder.addAnnotatedClass(CartItems.class);
		sessionBuilder.addAnnotatedClass(Order.class);
		sessionBuilder.addAnnotatedClass(OrderItems.class);
		sessionBuilder.addAnnotatedClass(Pay.class);
		sessionBuilder.addAnnotatedClass(Shipping.class);
		sessionBuilder.addAnnotatedClass(Billing.class);
		return sessionBuilder.buildSessionFactory();
	}
	
	@Autowired
	@Bean("transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}

	@Autowired
	@Bean("categoryDao")
	public CategoryDao getCategoryDao(SessionFactory sessionFactory) {
		return new CategoryDaoImpl(sessionFactory);
	}
	@Autowired
	@Bean("productDao")
	public ProductDao getProductyDao(SessionFactory sessionFactory) {
		return new ProductDaoImpl(sessionFactory);
	}

	@Autowired
	@Bean("supplierDao")
	public SupplierDao getSupplierDao(SessionFactory sessionFactory) {
		return new SupplierDaoImpl(sessionFactory);
	}

	@Autowired
	@Bean("userDao")
	public UserDao getUserDao(SessionFactory sessionFactory) {
		return new UserDaoImpl(sessionFactory);
	}

	@Autowired
	@Bean("authenticationDao")
	public AuthenticationDao getAuthenticationDao(SessionFactory sessionFactory) {
		return new AuthenticationDaoImpl(sessionFactory);
	}

	@Autowired
	@Bean("cartDao")
	public CartDao getCartDao(SessionFactory sessionFactory) {
		return new CartDaoImpl(sessionFactory);
		
	}
	
	@Autowired
	@Bean("cartItemsDao")
	public CartItemsDao getCartItemsDao(SessionFactory sessionFactory) {
		return new CartItemsDaoImpl(sessionFactory);
		
	}
	
	
	@Autowired
	@Bean("orderDao")
	public OrderDao getOrderDao(SessionFactory sessionFactory) {
		return new OrderDaoImpl(sessionFactory);
	}

	@Autowired
	@Bean("orderItemsDao")
	public OrderItemsDao getOrderItemsDao(SessionFactory sessionFactory) {
		return new OrderItemsDaoImpl(sessionFactory);
	}
	
	@Autowired
	@Bean("payDao")
	public PayDao getPayDao(SessionFactory sessionFactory) {
		return new PayDaoImpl(sessionFactory);
	}

	@Autowired
	@Bean("shippingDao")
	public ShippingDao getShippingDao(SessionFactory sessionFactory) {
		return new ShippingDaoImpl(sessionFactory);
	}
	
	
	@Autowired
	@Bean("billingDao")
	public BillingDao getBillingDao(SessionFactory sessionFactory) {
		return new BillingDaoImpl(sessionFactory);
	}


	


	



}