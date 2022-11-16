package org.glady.dao;

import org.glady.dto.CustomerGlobalBalance;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customer", schema = "glady")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Gift> gifts = new ArrayList<>();

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Meal> meals = new ArrayList<>();

    public Customer() {}

    public Customer(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Gift> getGifts() {
        return gifts;
    }

    public void setGifts(List<Gift> gifts) {
        this.gifts = gifts;
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }

    public float getGiftsBalance() {
        return gifts.stream()
                .filter(Gift::isNotExpired)
                .map(Gift::getAmount)
                .reduce(Float::sum)
                .orElse(0f);
    }

    public float getMealsBalance() {
        return meals.stream()
                .filter(Meal::isNotExpired)
                .map(Meal::getAmount)
                .reduce(Float::sum)
                .orElse(0f);
    }


    public CustomerGlobalBalance getGlobalBalance() {
        return new CustomerGlobalBalance(getGiftsBalance(), getMealsBalance());
    }
}
