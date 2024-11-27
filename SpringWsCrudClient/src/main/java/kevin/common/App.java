package kevin.common;

import kevin.service.Customer;
import org.springframework.web.client.RestTemplate;

import java.sql.*;
import java.util.LinkedHashMap;
import java.util.List;

import static sun.misc.Version.println;

public class App {
//    static final String uri = "http://localhost:8080/SpringWsCloud/";
    static final String uri = "http://localhost:8181/SpringJerseyCrud/";

    public static void main( String[] args ) {
        //REMOVE ALL (DELETE)
        deleteAllCustomers();

        //CREATE CUSTOMERS (POST)
        createCustomer(new Customer(71, "Tammy Hawkins", "691 Luster Center", "thawkinsi12@thetimes.co.uk"));
        createCustomer(new Customer(72, "Jack Tucker", "25445 Surrey Alley", "jtuckeri5@abc.net.au"));
        createCustomer(new Customer(73, "Matthew Morgan", "9 Jay Pass", "mmorgani6@kickstarter.com"));
        createCustomer(new Customer(74, "Timothy Watkins", "746 Center Alley", "twatkingsi7@tumblr.com"));
        createCustomer(new Customer(75, "Sara Williamson", "97121 Algoma Drive", "swilliamsoni8@woothemes.com"));
        createCustomer(new Customer(76, "Eugene Mcdonald", "51 Merrick Way", "emcdonaldi9@usnews.com"));

        //RETRIEVE ALL (GET)
        listAllCustomers();

        //GET ONE CUSTOMER (GET)
        Customer cust = getCustomers(74);

        //UPDATE (PUT)
        cust.setEmail("no-email");
        updateCustomer(cust);

        //REMOVE A CUSTOMER (DELETE)
        deleteCustomer(73);

        //RETRIEVE ALL (GET)
        listAllCustomers();

    }

    /* GET */
    @SuppressWarnings("unchecked")
    private static void listAllCustomers() {
        RestTemplate restTemplate = new RestTemplate();
        List<LinkedHashMap<String, Object>> customerMap = restTemplate.getForObject(uri + "/customer/", List.class);

        if(customerMap != null) {
            System.out.println("Retrieve all customers: ");
            for(LinkedHashMap<String, Object> map: customerMap) {
                System.out.println("Customer : id = " + map.get("custId")
                        + ", Name=  " + map.get("fullName")
                        + ", Address = " + map.get("address")
                        + ", Email = " + map.get("email")
                );
            }
        } else {
            System.out.println("No customer exist currently ------------------------------");
        }
    }

    /* GET */
    private static Customer getCustomers(int id) {
        RestTemplate restTemplate = new RestTemplate();
        Customer cust = restTemplate.getForObject(uri + "/customer/" + id, Customer.class);

        if(cust != null) {
            System.out.println("Retrieve a customer: ");
            System.out.println("Customer : id = " + cust.getCustId()
                    + ", Name=  " + cust.getFullName()
                    + ", Address = " + cust.getAddress()
                    + ", Email = " + cust.getEmail()
            );
            return cust;
        } else {
            System.out.println("No customer exist with such data currently ------------------------------");
            return null;
        }
    }

    /* POST */
    private static void createCustomer(Customer cust) {
        RestTemplate restTemplate = new RestTemplate();
        System.out.println("Create a customer: " + cust.getFullName());
        restTemplate.postForLocation(uri + "/customer/", cust, Customer.class);
    }

    /* PUT */
    private static void updateCustomer(Customer cust) {
        RestTemplate restTemplate = new RestTemplate();
        System.out.println("Update a customer: " + cust.getCustId());
        restTemplate.put(uri + "/customer", cust);
    }

    /* DELETE */
    private static void deleteCustomer(int id) {
        RestTemplate restTemplate = new RestTemplate();
        System.out.println("Delete a customer: " + id);
        restTemplate.delete(uri + "/customer/" + id);
    }

    /* DELETE */
    private static void deleteAllCustomers() {
        RestTemplate restTemplate = new RestTemplate();
        System.out.println("Delete all customers");
        restTemplate.delete(uri + "/customer/");
    }
}
