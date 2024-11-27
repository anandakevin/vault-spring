package kevin.controller;

import kevin.bo.CustomerBo;
import kevin.service.Customer;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    private CustomerBo customerBo;

    private static final Logger logger = Logger.getLogger(CustomerController.class);

    @RequestMapping(value = "/customer",
                    method = RequestMethod.GET,
                    produces = MediaType.APPLICATION_JSON_VALUE
    ) public ResponseEntity<List<Customer>> listAllCustomers() {
        logger.info("###### Retrieve all customers ######");
        List<Customer> customers = customerBo.findAllCustomers();

        if(customers.isEmpty()) return new ResponseEntity<List<Customer>>(HttpStatus.NO_CONTENT);
        //or HttpStatus.NOT_FOUND

        return new ResponseEntity<List<Customer>>(customers, new HttpHeaders(), HttpStatus.OK);
    }

    @RequestMapping(value = "/customer/{id}",
                    method = RequestMethod.GET,
                    produces = MediaType.APPLICATION_JSON_VALUE
    ) public ResponseEntity<Customer> getCustomer(@PathVariable("id") int id) {
        logger.info("###### Fetching Customer with id " + id + " ######");
        Customer customer = customerBo.findByCustomerId(id);
        if(customer == null) {
            logger.info("###### Customer with id " + id + " not found ######");
            return new ResponseEntity<Customer>(HttpStatus.NO_CONTENT);
        }
        //or HttpStatus.NOT_FOUND

        return new ResponseEntity<Customer>(customer, new HttpHeaders(), HttpStatus.OK);
    }

    @RequestMapping(value = "/customer",
                    method = RequestMethod.POST
    ) public ResponseEntity<Void> createCustomer(
            @RequestBody Customer cust,
            UriComponentsBuilder ucBuilder
            ) {
        logger.info("###### Creating Customer " + cust.getFullName() + " ######");
        Customer customer = new Customer(cust.getCustId(), cust.getFullName(), cust.getAddress(), cust.getEmail());

        try {
            customerBo.insert(customer);
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(ucBuilder.path("/list-customer/{id}")
                                        .buildAndExpand(cust.getCustId()).toUri());

            return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
    }

    @RequestMapping(value = "/customer",
                    method = RequestMethod.PUT
    ) public ResponseEntity<Customer> updateCustomer(@RequestBody Customer cust) {
        logger.info("###### Updating Customer " + cust.getCustId() + " ######");
        Customer customer = customerBo.findByCustomerId(cust.getCustId());
        if(customer == null) {
            logger.info("###### Customer with id " + cust.getCustId() + " not found ######");
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        }

        customerBo.update(cust);
        return new ResponseEntity<Customer>(cust, HttpStatus.OK);
    }

    @RequestMapping(value = "/customer",
                    method = RequestMethod.DELETE
    ) public ResponseEntity<Customer> deleteAllCustomers() {
        logger.info("###### Deleting all customers ######");
        customerBo.deleteAll();
        return new ResponseEntity<Customer>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/customer/{id}",
                    method=RequestMethod.DELETE
    ) public ResponseEntity<Customer> deleteCustomer(@PathVariable("id") int id) {
        logger.info("###### Fetching & Deleting Customer with id " + id + " ######");
        Customer customer = customerBo.findByCustomerId(id);
        if(customer == null) {
            logger.info("###### Unable to delete. Customer with id  " + id + " not found ######");
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        }

        customerBo.delete(id);
        return new ResponseEntity<Customer>(HttpStatus.NO_CONTENT);
    }
}