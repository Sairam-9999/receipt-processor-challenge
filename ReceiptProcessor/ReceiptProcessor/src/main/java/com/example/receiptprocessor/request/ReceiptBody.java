package com.example.receiptprocessor.request;

import java.util.List;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class ReceiptBody {
    @NotEmpty
    @Pattern(regexp = "^[\\w\\s\\-&]+$")
    private String retailer;

    @NotEmpty
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$")
    private String purchaseDate;

    @NotEmpty
    @Pattern(regexp = "^\\d{2}:\\d{2}$")
    private String purchaseTime;

    @NotEmpty
    @Size(min = 1)
    private List<Item> items;

    @NotEmpty
    @Pattern(regexp = "^\\d+\\.\\d{2}$")
    private String total;

    public @NotEmpty @Pattern(regexp = "^[\\w\\s\\-&]+$") String getRetailer() {
        return retailer;
    }

    public void setRetailer(@NotEmpty @Pattern(regexp = "^[\\w\\s\\-&]+$") String retailer) {
        this.retailer = retailer;
    }

    public @NotEmpty @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$") String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(@NotEmpty @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$") String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public @NotEmpty @Pattern(regexp = "^\\d{2}:\\d{2}$") String getPurchaseTime() {
        return purchaseTime;
    }

    public void setPurchaseTime(@NotEmpty @Pattern(regexp = "^\\d{2}:\\d{2}$") String purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    public @NotEmpty @Size(min = 1) List<Item> getItems() {
        return items;
    }

    public void setItems(@NotEmpty @Size(min = 1) List<Item> items) {
        this.items = items;
    }

    public @NotEmpty @Pattern(regexp = "^\\d+\\.\\d{2}$") String getTotal() {
        return total;
    }

    public void setTotal(@NotEmpty @Pattern(regexp = "^\\d+\\.\\d{2}$") String total) {
        this.total = total;
    }
}