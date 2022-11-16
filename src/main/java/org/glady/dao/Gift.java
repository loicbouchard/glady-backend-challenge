package org.glady.dao;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "gift", schema = "glady")
public class Gift extends Present {
    @Column(name = "days_lifespan", nullable = false)
    private int daysLifespan;

    public Gift() {}

    public Gift(float amount, LocalDate createdDate, Company company, Customer customer, int daysLifespan) {
        super(amount, createdDate, company, customer);
        this.daysLifespan = daysLifespan;
    }

    public int getDaysLifespan() {
        return daysLifespan;
    }

    public void setDaysLifespan(int daysLifespan) {
        this.daysLifespan = daysLifespan;
    }

    public boolean isNotExpired() {
        return createdDate.plusDays(daysLifespan).compareTo(LocalDate.now()) > 0;
    }
}
