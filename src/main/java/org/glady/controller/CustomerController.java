package org.glady.controller;

import org.glady.dao.Customer;
import org.glady.dto.CustomerDto;
import org.glady.dto.CustomerGlobalBalance;
import org.glady.service.CustomerService;
import org.jboss.resteasy.reactive.ResponseStatus;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("customer")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @GET
    @Path("{id}")
    public Customer getCustomerById(@PathParam("id") Integer id) {
        return customerService.getCustomerById(id);
    }

    @POST
    @ResponseStatus(201)
    public Response createCustomer(@Valid CustomerDto customerDto) {
        customerService.persistCustomer(customerDto);
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    @Path("balance/{id}")
    public CustomerGlobalBalance getGlobalBalance(@PathParam("id") Integer id) {
        return customerService.getCustomerById(id).getGlobalBalance();
    }

    @GET
    @Path("balance/gift/{id}")
    public float getGiftBalance(@PathParam("id") Integer id) {
        return customerService.getCustomerById(id).getGiftsBalance();
    }

    @GET
    @Path("balance/meal/{id}")
    public float getMealBalance(@PathParam("id") Integer id) {
        return customerService.getCustomerById(id).getMealsBalance();
    }
}
