package intra.bca.co.id.bo.impl;

import java.util.List;

import intra.bca.co.id.bo.CustomerBo;
import intra.bca.co.id.dao.CustomerDao;
import intra.bca.co.id.model.Customer;

public class CustomerBoImpl implements CustomerBo {
	private CustomerDao custDao;
	public CustomerDao getCustDao() {
		return custDao;
	}

	public void setCustDao(CustomerDao custDao) {
		this.custDao = custDao;
	}

	public void insert(Customer customer) {
		custDao.insert(customer);
	}

	public Customer findByCustomerId(int custId) {
		try {
			Customer customer = new Customer();
			customer = custDao.findByCustomerId(custId);
			if(customer != null) return customer;
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Data not found");
		}
		return null;
	}

	public List<Customer> findAllCustomers() {		
		return custDao.findAllCustomers();
	}

	public void update(Customer customer) {
		custDao.update(customer);
	}
	
	public Customer delete(int custId) {
		try {
			Customer customer = custDao.delete(custId);
			if(customer != null) return customer;
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Data not found");
		}
		return null;
	}
}
