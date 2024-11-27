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
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        
        Traveler firstTraveler = (Traveler) context.getBean("TheFirstTraveler");
        System.out.println(firstTraveler);
        firstTraveler.showCar();
        firstTraveler.startJourney();

        System.out.println("========================================");
        /*
        Traveler secondTraveler = (Traveler) context.getBean("TheSecondTraveler");
        System.out.println(secondTraveler);
        secondTraveler.showCar();
        secondTraveler.startJourney();
        System.out.println("========================================");
        */
        Traveler thirdTraveler = (Traveler) context.getBean("TheThirdTraveler");
        System.out.println(thirdTraveler);
        thirdTraveler.showCar();
        thirdTraveler.startJourney();
        
        System.out.println("========================================");
        Traveler fourthTraveler = (Traveler) context.getBean("TheFourthTraveler");
        System.out.println(fourthTraveler);
        fourthTraveler.showCar();
        fourthTraveler.startJourney();

        System.out.println("========================================");
        Traveler fifthTraveler = (Traveler) context.getBean("TheFifthTraveler");
        System.out.println(fifthTraveler);
        fifthTraveler.showCar();
        fifthTraveler.startJourney();
    }
}
