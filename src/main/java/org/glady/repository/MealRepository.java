package org.glady.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import org.glady.dao.Meal;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MealRepository implements PanacheRepositoryBase<Meal, Integer> {}
