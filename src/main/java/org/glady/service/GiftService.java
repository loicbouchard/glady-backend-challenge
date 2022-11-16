package org.glady.service;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.glady.dao.Company;
import org.glady.dao.Customer;
import org.glady.dao.Gift;
import org.glady.dto.PresentDto;
import org.glady.repository.GiftRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.time.LocalDate;

@ApplicationScoped
public class GiftService {

    private final GiftRepository giftRepository;

    private final CustomerService customerService;

    private final CompanyService companyService;

    @ConfigProperty(name = "days-lifespan", defaultValue = "365")
    private Integer daysLifespan;

    public GiftService(GiftRepository giftRepository,
                       CustomerService customerService,
                       CompanyService companyService) {
        this.giftRepository = giftRepository;
        this.customerService = customerService;
        this.companyService = companyService;
    }
    @Transactional
    public void addGiftToCustomer(PresentDto gift) {
        Customer customer = customerService.getCustomerById(gift.getCustomerId());
        Company company = companyService.getCompanyById(gift.getCompanyId());

        checkCompanyBalance(gift, company);
        createGift(gift, company, customer);
        updateCompanyBalance(company, gift.getAmount());
    }

    private void checkCompanyBalance(PresentDto gift, Company company) {
        if(company.getBalance() < gift.getAmount()) {
            throw new ArithmeticException("I am bankrupt");
        }
    }

    private void createGift(PresentDto gift, Company company, Customer customer) {
        giftRepository.persist(
                new Gift(
                        gift.getAmount(),
                        LocalDate.now(),
                        company,
                        customer,
                        daysLifespan));
    }

    private void updateCompanyBalance(Company company, float amount) {
        company.setBalance(company.getBalance() - amount);
        companyService.persistCompany(company);
    }
}
