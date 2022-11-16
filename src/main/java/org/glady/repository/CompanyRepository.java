package org.glady.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import org.glady.dao.Company;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CompanyRepository implements PanacheRepositoryBase<Company, Integer> {}
