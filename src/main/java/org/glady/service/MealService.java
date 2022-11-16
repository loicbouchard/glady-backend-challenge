package org.glady.service;

import org.glady.dao.Company;
import org.glady.dao.Customer;
import org.glady.dao.Meal;
import org.glady.dto.PresentDto;
import org.glady.repository.MealRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.time.LocalDate;

@ApplicationScoped
public class MealService {
    private final MealRepository mealRepository;

    private final CustomerService customerService;

    private final CompanyService companyService;

    public MealService(
            MealRepository mealRepository,
            CustomerService customerService,
            CompanyService companyService) {
        this.mealRepository = mealRepository;
        this.customerService = customerService;
        this.companyService = companyService;
    }

    @Transactional
    public void addMealToCustomer(PresentDto meal) {
        Customer customer = customerService.getCustomerById(meal.getCustomerId());
        Company company = companyService.getCompanyById(meal.getCompanyId());

        checkCompanyBalance(meal, company);
        createMeal(meal, company, customer);
        updateCompanyBalance(company, meal.getAmount());
    }

    private void checkCompanyBalance(PresentDto meal, Company company) {
        if(company.getBalance() < meal.getAmount()) {
            throw new ArithmeticException("I am bankrupt");
        }
    }

    private void createMeal(PresentDto meal, Company company, Customer customer) {
        mealRepository.persist(
                new Meal(
                        meal.getAmount(),
                        LocalDate.now(),
                        company,
                        customer));
    }

    private void updateCompanyBalance(Company company, float amount) {
        company.setBalance(company.getBalance() - amount);
        companyService.persistCompany(company);
    }
}
