package kevin.dao.impl;

import kevin.dao.CustomerDao;
import kevin.service.Customer;
import org.hibernate.*;
import org.hibernate.boot.spi.SessionFactoryOptions;
import org.hibernate.engine.spi.FilterDefinition;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.metadata.CollectionMetadata;
import org.hibernate.query.Query;
import org.hibernate.stat.Statistics;
import org.springframework.beans.factory.annotation.Autowired;

import javax.naming.NamingException;
import javax.naming.Reference;
import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceUnitUtil;
import javax.persistence.SynchronizationType;
import javax.persistence.criteria.CriteriaBuilder;
import javax.transaction.Transactional;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
