package intra.bca.co.id.common;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import intra.bca.co.id.bo.CustomerBo;
import intra.bca.co.id.model.Customer;

public class App {

    // If you want to keep sessionFactory non-static, it should be initialized in an instance method
    private static SessionFactory sessionFactory;

    public static void main(String[] args) {
        ApplicationContext appContext = new ClassPathXmlApplicationContext("spring/config/Main.xml");
        CustomerBo custBo = (CustomerBo) appContext.getBean("customerBo");

        // custBo.insert(new Customer(11, "Nicholas Freeman", "06 Thackeray Lane", "nfreeman0@mac.com"));
        custBo.insert(new Customer(12, "Jack Ortiz", "018 Mesta Circle", "jortiz1@mozilla.org"));
        // custBo.insert(new Customer(13, "Virginia Carroll", "0532 Lighthouse Bay Road", "vcarroll2@pen.io"));
        // custBo.insert(new Customer(14, "NHicholas Welch", "7 Melvin Alley", "nwelch3@nih.gov"));
        // custBo.insert(new Customer(15, "Adam Black", "581 Continental Drive", "ablack4@soup.io"));

        // Display all customers
        System.out.println("-------------------------------------");
        List<Customer> custList = custBo.findAllCustomers();
        for (Customer cust : custList) {
            System.out.println(cust);
        }

        // UPDATE 1 CUSTOMER
        System.out.println("--- UPDATING ---");
        Customer customer = custBo.findByCustomerId(12);
        System.out.println("Customer info before updating: ");
        System.out.println(customer);
        customer.setEmail("jortiz1@mozilla.co.id");
        custBo.update(customer);
        System.out.println("--- UPDATED! ---");
        System.out.println("Customer info after updating: ");
        System.out.println(customer);

        // DELETE 1 CUSTOMER
        System.out.println("--- DELETING ---");
        customer = custBo.delete(12);
        System.out.println("--- DELETED! ---");
        System.out.println("Deleted customer info: ");
        System.out.println(customer);

        // Now working with Hibernate transactions

        // If using Spring Hibernate setup, get sessionFactory from the Spring context
        sessionFactory = appContext.getBean("sessionFactory", SessionFactory.class);

        // Open session and begin transaction
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        try {
            // INSERT 2 CUSTOMER
            session.save(new Customer(21, "Nicholas Freeman", "06 Thackeray Lane", "nfreeman0@mac.com"));
            session.save(new Customer(22, "Jack Ortiz", "018 Mesta Circle", "jortiz1@mozzila.org"));

            // UPDATE 1 CUSTOMER
            List<Customer> list = session.createQuery("from Customer where custId = :custid")
                    .setParameter("custid", 22)
                    .list();

            Customer updCustomer = (Customer) list.get(0);
            updCustomer.setEmail("jortiz1@mozilla.co.id");
            session.update(updCustomer);

            // DELETE CUSTOMER
            Customer delCustomer = findByCustomer(21);
            session.delete(delCustomer);

            tx.commit();
        } catch (HibernateException e) {
            tx.rollback();
            e.printStackTrace();
        } catch (RuntimeException e) {
            tx.rollback();
            e.printStackTrace();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    private static Customer findByCustomer(int id) {
        // Implement the logic to find customer by id using sessionFactory
        return null; // Example placeholder, implement according to your needs
    }
}
