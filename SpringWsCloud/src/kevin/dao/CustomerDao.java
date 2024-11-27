package kevin.dao;

import kevin.service.Customer;

import java.util.List;

public interface CustomerDao {
    public void insert(Customer customer);
    public Customer findByCustomerId(int custId);
    public List<Customer> findAllCustomers();
    public void update(Customer customer);
    public void deleteAll();
    public void delete(int custId);
}
