package intra.bca.co.id.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import intra.bca.co.id.dao.CustomerDao;
import intra.bca.co.id.service.Customer;

public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional 
	public void insert(Customer customer) {
		this.sessionFactory.getCurrentSession().save(customer);
	}

	@Transactional
	public Customer findByCustomerId(int custId) {
		List <Customer> list = this.sessionFactory.getCurrentSession().createQuery("from customer where custId =: custId").setParameter("custid", custId).list();
		return (Customer) list.get(0);
	}

	@Transactional
	public List<Customer> findAllCustomer() {
		List<Customer> custList = new ArrayList<Customer>();
		custList = this.sessionFactory.getCurrentSession().createQuery("from Customer").list();
		return custList;
	}

	@Transactional
	public void update(Customer customer) {
		this.sessionFactory.getCurrentSession().update(customer);
	}

	@Transactional
	public void delete(int custId) {
		Customer customer = findByCustomerId(custId);
		this.sessionFactory.getCurrentSession().delete(customer);
		
	}
	
}
