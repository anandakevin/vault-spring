package kevin.common;

import kevin.model.GreetingJson;
import org.springframework.web.client.RestTemplate;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        final String uri = "http://localhost:8080/SpringWs02-0.0.1-SNAPSHOT/greet.json";

        try {
            RestTemplate restTemplate = new RestTemplate();
            String result = restTemplate.getForObject(uri, String.class);
            //Method = GET
            System.out.println(result);

            GreetingJson greeting = restTemplate.getForObject(uri,GreetingJson.class);
            System.out.println("Guest ID= " + greeting.getGuestId() );
            System.out.println("Guest Name= " + greeting.getGuestName() );
            System.out.println("Message= " + greeting.getMessage() );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
