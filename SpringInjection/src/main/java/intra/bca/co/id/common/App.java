package intra.bca.co.id.common;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
        
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        Vehicle carMercy = (Vehicle) context.getBean("TheMercedes");
        Vehicle carBmw = (Vehicle) context.getBean("TheBmw");
        
        System.out.println(carMercy);
        carMercy.move();
        System.out.println("------------------------------");
        System.out.println(carBmw);
        carBmw.move();
        
    }
}
