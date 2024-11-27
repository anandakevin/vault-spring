package intra.bca.co.id.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import intra.bca.co.id.dao.CustomerDao;
import intra.bca.co.id.model.Customer;

public class CustomerDaoImpl implements CustomerDao {

	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void insert(Customer customer) {
		this.sessionFactory.getCurrentSession().save(customer);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public Customer findByCustomerId(int custId) {
		List <Customer> list = this.sessionFactory.getCurrentSession().createQuery("from Customer where custId =: custId").setParameter("custId", custId).list();
		return (Customer) list.get(0);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Customer> findAllCustomers() {
		List <Customer> custList = new ArrayList <Customer> ();
		custList = this.sessionFactory.getCurrentSession()
.createQuery("from Customer").list();
		return custList;
	}

	@Transactional
	public void update(Customer customer) {
		this.sessionFactory.getCurrentSession().update(customer);
	}

	@Transactional
	public Customer delete(int custId) {
		Customer customer = findByCustomerId(custId);
		this.sessionFactory.getCurrentSession().delete(customer);
		return customer;
	}

}
