package kevin.bo.impl;

import kevin.bo.CustomerBo;
import kevin.dao.CustomerDao;
import kevin.dao.impl.CustomerDaoImpl;
import kevin.service.Customer;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CustomerBoImpl implements CustomerBo {
    @Autowired
    private CustomerDao custDao;

    public void setCustDao(CustomerDao custDao) {
        this.custDao = custDao;
    }

    public CustomerDao getCustDao() {
        return custDao;
    }

    @Override
    public void insert(Customer customer) {
        custDao.insert(customer);
    }

    @Override
    public Customer findByCustomerId(int id) {
        return custDao.findByCustomerId(id);
    }

    @Override
    public List<Customer> findAllCustomers() {
        return custDao.findAllCustomers();
    }

    @Override
    public void update(Customer customer) {
        custDao.update(customer);
    }

    @Override
    public void deleteAll() {
        custDao.deleteAll();
    }

    @Override
    public void delete(int id) {
        custDao.delete(id);
    }
}
