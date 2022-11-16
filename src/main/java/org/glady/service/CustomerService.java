package org.glady.service;

import org.glady.dao.Customer;
import org.glady.dto.CustomerDto;
import org.glady.repository.CustomerRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;

@ApplicationScoped
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer getCustomerById(Integer id) {
        return customerRepository.findByIdOptional(id).orElseThrow(() -> new NotFoundException("Customer not found!"));
    }

    @Transactional
    public void persistCustomer(CustomerDto customerDto) {
        customerRepository.persist(new Customer(customerDto.getName()));
    }
}
