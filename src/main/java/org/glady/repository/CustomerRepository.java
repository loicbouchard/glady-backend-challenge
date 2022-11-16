package org.glady.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import org.glady.dao.Customer;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CustomerRepository implements PanacheRepositoryBase<Customer, Integer> {}
