package intra.bca.co.id.dao;

import java.util.List;

import intra.bca.co.id.service.Customer;

public interface CustomerDao {
	public void insert(Customer customer);
	public Customer findByCustomerId(int custId);
	public List<Customer> findAllCustomer();
	public void update(Customer customer);
	public void delete (int custId);
}
