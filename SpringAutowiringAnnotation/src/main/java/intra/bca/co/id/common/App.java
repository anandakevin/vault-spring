package intra.bca.co.id.common;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**  * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        Traveler firstTraveler = (Traveler) context.getBean("TheTraveler");
        System.out.println(firstTraveler);
        firstTraveler.showCar();
        firstTraveler.startJourney();
    }
}
