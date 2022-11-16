package org.glady.dto;

import javax.validation.constraints.NotBlank;

public class CustomerDto {

    @NotBlank
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}