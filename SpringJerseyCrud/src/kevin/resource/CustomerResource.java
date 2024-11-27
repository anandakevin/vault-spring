package kevin.resource;

import kevin.bo.CustomerBo;
import kevin.bo.impl.CustomerBoImpl;
import kevin.service.Customer;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

//path ini untuk menyatakan nama layanan web service
@Path("customer")
@Component
public class CustomerResource {
//    POST, PUT dan DELETE sebenarnya tidak perlu mengembalikan nilai kepada pemanggilnya, namun disini yg dikembalikan adalah status dari hasil eksekusinya
    @Autowired
    private CustomerBo customerBo;

    private static final Logger logger = Logger.getLogger(CustomerResource.class);

//    fungsi annotation @GET, @POST, @PUT dan @DELETE adalah untuk memetakan request dari klien ke method di dalam class ini yang akan menjadio handlernya
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listAllCustomers() {
        logger.info("###### Retrieve all customers ######");
        List<Customer> customers = customerBo.findAllCustomers();
        logger.info("###### Customers info retrieved ######");
        if(customers == null) {
            logger.info("###### There is currently no customer ######");
            return Response.status(Response.Status.NO_CONTENT).entity(null).build();
        }
        return Response.status(Response.Status.OK).entity(customers).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response getCustomer(@PathParam("id") int id) {
        logger.info("###### Fetching Customer with id " + id + " ######");
        Customer customer = customerBo.findByCustomerId(id);

        if(customer == null) {
            logger.info("###### Customer with id " + id + " not found ######");
            return Response.status(Response.Status.NOT_FOUND).entity(null).build();
        }

        return Response.status(Response.Status.OK).entity(customer).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response createCustomer(Customer cust) {
        logger.info("###### Creating Customer " + cust.getFullName() + " ######");
        Customer customer = new Customer(cust.getCustId(), cust.getFullName(), cust.getAddress(), cust.getEmail());

        try {
            customerBo.insert(customer);
            return Response.status(Response.Status.CREATED).entity(customer).build();
        } catch (Exception e) {
            return Response.status(Response.Status.CONFLICT).entity(customer).build();
        }
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateCustomer(Customer cust) {
        logger.info("###### Updating Customer " + cust.getCustId() + " ######");
        Customer customer = customerBo.findByCustomerId(cust.getCustId());
        if(customer == null) {
            logger.info("###### Customer with id " + cust.getCustId() + " not found ######");
            return Response.status(Response.Status.NOT_FOUND).entity(null).build();
        }
        customerBo.update(cust);
        return Response.status(Response.Status.OK).entity(cust).build();
    }

    @DELETE
    @Produces (MediaType.APPLICATION_JSON)
    public Response deleteAllCustomers() {
        logger.info("###### Deleting all customers ######");
        customerBo.deleteAll();
        return Response.status(Response.Status.NO_CONTENT).entity(null).build();
    }

    @DELETE
    @Produces (MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response deleteCustomer(@PathParam("id") int id) {
        logger.info("###### Fetching & Deleting customer with id " + id + " ######");
        Customer customer = customerBo.findByCustomerId(id);
        if(customer == null) {
            logger.info("###### Unable to delete. Customer with id " + id + " not found ######");
            return Response.status(Response.Status.NOT_FOUND).entity(null).build();
        }
        customerBo.delete(id);
        return Response.status(Response.Status.NO_CONTENT).entity(null).build();
    }

}
