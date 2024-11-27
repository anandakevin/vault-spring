package kevin.dao.impl;

import kevin.dao.CustomerDao;
import kevin.service.Customer;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao {
    @Autowired
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
        List<Customer> list = this.sessionFactory.getCurrentSession()
                .createQuery("from Customer where custId =: custid")
                .setParameter("custid", custId)
                .list();
        if(list.isEmpty()) return null;
        else return (Customer)list.get(0);
    }

    @Transactional
    public List<Customer> findAllCustomers() {
        List<Customer> custList = new ArrayList<Customer>();
        custList = this.sessionFactory.getCurrentSession()
                .createQuery("from Customer")
                .list();
        return custList;
    }

    @Transactional
    public void update(Customer customer) {
        this.sessionFactory.getCurrentSession().update(customer);
    }

    @Transactional
    public void deleteAll() {
        Query query = this.sessionFactory.getCurrentSession().createQuery("DELETE FROM Customer");
        int result = query.executeUpdate();
    }

    @Transactional
    public void delete(int custId) {
        Customer customer = findByCustomerId(custId);
        if(customer != null) this.sessionFactory.getCurrentSession().delete(customer);
    }


}
