package org.glady.dto;

import javax.validation.constraints.PositiveOrZero;

public class CustomerGlobalBalance {
    @PositiveOrZero
    private float giftBalance;

    @PositiveOrZero
    private float mealBalance;

    public CustomerGlobalBalance() { }

    public CustomerGlobalBalance(float giftBalance, float mealBalance) {
        this.giftBalance = giftBalance;
        this.mealBalance = mealBalance;
    }

    public float getGiftBalance() {
        return giftBalance;
    }

    public void setGiftBalance(float giftBalance) {
        this.giftBalance = giftBalance;
    }

    public float getMealBalance() {
        return mealBalance;
    }

    public void setMealBalance(float mealBalance) {
        this.mealBalance = mealBalance;
    }
}
