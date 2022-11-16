package org.glady.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class PresentDto {
    @NotNull
    private Integer companyId;

    @NotNull
    private Integer customerId;

    @NotNull
    @Positive
    private float amount;

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}
