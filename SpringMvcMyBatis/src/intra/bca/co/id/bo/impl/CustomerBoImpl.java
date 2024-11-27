package intra.bca.co.id.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import intra.bca.co.id.bo.CustomerBo;
import intra.bca.co.id.dao.CustomerDao;
import intra.bca.co.id.service.Customer;

public class CustomerBoImpl implements CustomerBo {

	@Autowired
	private CustomerDao custDao;
	
	public CustomerDao getCustDao() {
		return custDao;
	}

	public void setCustDao(CustomerDao custDao) {
		this.custDao = custDao;
	}

	@Override
	public void insert(Customer customer) {
		custDao.insert(customer);
	}

	@Override
	public Customer findByCustomerId(int custId) {
		return custDao.findByCustomerId(custId);
	}

	@Override
	public List<Customer> findAllCustomer() {
		return custDao.findAllCustomer();
	}

	@Override
	public void update(Customer customer) {
		custDao.update(customer);		
	}

	@Override
	public void delete(int custId) {
		custDao.delete(custId);
	}
}
