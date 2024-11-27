package intra.bca.co.id.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
    public static void main( String[] args )
    {
    	String strClassPath = System.getProperty("java.class.path");
        System.out.println("Classpath is " + strClassPath);
        
        ApplicationContext context = new ClassPathXmlApplicationContext("Main.xml");
        CustomerDao customerDAO = (CustomerDao) context.getBean("customerDAO");
        customerDAO.insert(new Customer(1, "Russell Banks", "5160 Haas Junciton", "rbanks0@seesaa.net"));
        customerDAO.insert(new Customer(2, "Tina Peters", "0023 Mandrake Pass", "tpeters1@rambler.ru"));
        customerDAO.insert(new Customer(3, "Jeremy Ward", "6200 Kenwood Circle", "jward2@skyrock.com"));

        Customer customer1 = customerDAO.findByCustomerId(1);
        System.out.println(customer1);
    }
}
