package intra.bca.co.id.bo;

import java.util.List;

import intra.bca.co.id.model.Customer;

public interface CustomerBo {
	public void insert(Customer customer);
	public Customer findByCustomerId(int custId);
	public List<Customer> findAllCustomers();
	public void update(Customer customer);
	public Customer delete(int custId);
}
