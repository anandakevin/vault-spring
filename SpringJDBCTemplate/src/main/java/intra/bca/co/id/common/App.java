package intra.bca.co.id.common;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import intra.bca.co.id.dao.CustomerDao;
import intra.bca.co.id.model.Customer;

/**
 * Hello world!
 *
 */
public class App 
{
	@SuppressWarnings("resource")
    public static void main( String[] args )
    {
		
    	ApplicationContext context = new ClassPathXmlApplicationContext("Main.xml");
    	
    	System.out.println("lolos!!!");
    	
    	
        CustomerDao customerDAO = (CustomerDao) context.getBean("customerDAO");
        customerDAO.insert(new Customer(4, "Harry Carr", "9 Butterfield Way", "hcarr3@sina.com.cn"));
        customerDAO.insert(new Customer(5, "Willie Campbell", "48 Hayes Drive", "wcampbell4@archive.org"));
        customerDAO.insert(new Customer(6, "Amanda Parker", "095 Londonderry Alley", "aparker5@plala.or.jp"));
        
        Customer customer1 = customerDAO.findByCustomerId(4);
        System.out.println(customer1);
        
        System.out.println("------------------------------------------------");
        List <Customer> custList1 = customerDAO.findAllCustomers();
        for (Customer cust : custList1) {
			System.out.println(cust.getCustId() + " | " + cust.getFullname() + " | " + cust.getAddress() + " | " +cust.getEmail());
		}
        
        CustomerDao customerDAOSupport = (CustomerDao) context.getBean("customerDAOSupport");
        customerDAOSupport.insert(new Customer(8, "Martin Miller", "685 Northport Terrace", "mmiller7@imdb.com"));
        customerDAOSupport.insert(new Customer(9, "Irene Cooper", "90385 Continental Drive", "icooper8@yahoo.com"));
        customerDAOSupport.insert(new Customer(7, "Marie Anderson", "1577 Del Mar Plaza", "manderson6@mapquest.com"));

        Customer customer2 = customerDAOSupport.findByCustomerId(7);
        System.out.println(customer2);
        
        System.out.println("------------------------------------------------");
        List <Customer> custList2 = customerDAOSupport.findAllCustomers();
        for (Customer cust : custList2) {
			System.out.println(cust.getCustId() + " | " + cust.getFullname() + " | " + cust.getAddress() + " | " + cust.getEmail());
		}
    }
}
