package org.glady.dao;

import javax.persistence.*;
import java.time.LocalDate;

import static java.time.temporal.TemporalAdjusters.lastDayOfMonth;

@Entity
@Table(name = "meal", schema = "glady")
public class Meal extends Present {

    public Meal() { }

    public Meal(float amount, LocalDate createdDate, Company company, Customer customer) {
        super(amount, createdDate, company, customer);
    }

    public boolean isNotExpired() {
        LocalDate expirationDate = LocalDate
                .of(createdDate.getYear() + 1, 2, 1)
                .with(lastDayOfMonth());
        return expirationDate.compareTo(LocalDate.now()) > 0;
    }
}

