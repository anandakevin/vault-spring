package kevin.bo;

import kevin.service.Customer;

import java.util.List;

public interface CustomerBo {
    public void insert(Customer customer);
    public Customer findByCustomerId(int id);
    public List<Customer> findAllCustomers();
    public void update(Customer customer);
    public void deleteAll();
    public void delete(int id);
}
