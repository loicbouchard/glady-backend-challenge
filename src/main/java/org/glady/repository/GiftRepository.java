package org.glady.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import org.glady.dao.Gift;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GiftRepository implements PanacheRepositoryBase<Gift, Integer> {}
