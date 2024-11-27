package intra.bca.co.id.common;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import intra.bca.co.id.bo.CustomerBo;
import intra.bca.co.id.model.Customer;
import net.bytebuddy.asm.Advice.This;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext appContext = new ClassPathXmlApplicationContext("spring/config/Main.xml");
        CustomerBo custBo = (CustomerBo) appContext.getBean("customerBo");
        
        //custBo.insert(new Customer(11, "Nicholas Freeman", "06 Thackeray Lane", "nfreeman0@mac.com"));
        custBo.insert(new Customer(12, "Jack Ortiz", "018 Mesta Circle", "jortiz1@mozilla.org"));
        //custBo.insert(new Customer(13, "Virginia Carroll", "0532 Lighthouse Bay Road", "vcarroll2@pen.io"));
        //custBo.insert(new Customer(14, "NHicholas Welch", "7 Melvin Alley", "nwelch3@nih.gov"));
        //custBo.insert(new Customer(15, "Adam Black", "581 Continental Drive", "ablack4@soup.io"));
        
        //Display all customer
        System.out.println("-------------------------------------");
        List <Customer> custList = custBo.findAllCustomers();
        for (Customer cust : custList) {
			System.out.println(cust);
		}
        
        //UPDATE 1 CUSTOMER
        System.out.println("--- UPDATING ---");
        Customer customer = custBo.findByCustomerId(12);
        System.out.println("Customer info before updating: ");
        System.out.println(customer);
        customer.setEmail("jortiz1@mozilla.co.id");
        custBo.update(customer);
        System.out.println("--- UPDATED! ---");
        System.out.println("Customer info after updating: ");
        System.out.println(customer);
        
        //DELETE 1 CUSTOMER
        System.out.println("--- DELETING ---");
        customer = custBo.delete(12);
        System.out.println("--- DELETED! ---");
        System.out.println("Deleted customer info: ");
        System.out.println(customer);
        //customer = custBo.findByCustomerId(12);

        Transaction tx = this.sessionFactory.getCurrentSession().beginTransaction();
        try {
			//INSERT 2 CUSTOMER
        	this.sessionFactory.getCurrentSession().save(new Customer(21, "Nicholas Freeman", "06 Thackeray Lane", "nfreeman0@mac.com"));
        	this.sessionFactory.getCurrentSession().save(new Customer(22, "Jack Ortiz", "018 Mesta Circle", "jortiz1@mozzila.org"));
        	
        	//UPDATE 1 CUSTOMER
        	List <Customer> list = this.sessionFactory.getCurrentSession().createQuery("from Customer where custId =: custid").setParameter("custid", 22).list();
        	
        	Customer updCustomer = (Customer) list.get(0);
        	updCustomer.setEmail("jortiz1@mozilla.co.id");
        	this.sessionFactory.getCurrentSession().update(updCustomer);
        	
        	//DELETE CUSTOMER
        	Customer delCustomer = findByCustomer(21);
        	this.sessionFactory.getCurrentSession().delete(delCustomer);
        	
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
		} 
    }
}
