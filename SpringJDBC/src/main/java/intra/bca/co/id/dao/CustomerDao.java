package intra.bca.co.id.dao;

import intra.bca.co.id.model.Customer;

public interface CustomerDao {
	public void insert(Customer customer);
	public Customer findByCustomerId(int custId);
}
