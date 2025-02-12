package com.example.receiptprocessor.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class Item {
    @NotEmpty
    @Pattern(regexp = "^[\\w\\s\\-]+$")
    private String shortDescription;

    @NotEmpty
    @Pattern(regexp = "^\\d+\\.\\d{2}$")
    private String price;

    // Getters and Setters

    public @NotEmpty @Pattern(regexp = "^[\\w\\s\\-]+$") String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(@NotEmpty @Pattern(regexp = "^[\\w\\s\\-]+$") String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public @NotEmpty @Pattern(regexp = "^\\d+\\.\\d{2}$") String getPrice() {
        return price;
    }

    public void setPrice(@NotEmpty @Pattern(regexp = "^\\d+\\.\\d{2}$") String price) {
        this.price = price;
    }
}