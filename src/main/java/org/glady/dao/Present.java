package org.glady.dao;

import javax.persistence.*;
import java.time.LocalDate;

@MappedSuperclass
public abstract class Present {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Integer id;

    @Column(nullable = false)
    protected float amount;

    @Column(name = "created_date", nullable = false)
    protected LocalDate createdDate;

    @ManyToOne
    protected Company company;

    @ManyToOne
    protected Customer customer;

    public Present() {}

    public Present(float amount, LocalDate createdDate, Company company, Customer customer) {
        this.amount = amount;
        this.createdDate = createdDate;
        this.company = company;
        this.customer = customer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
