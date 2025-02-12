package com.example.receiptprocessor.model;

import com.example.receiptprocessor.request.ReceiptBody;

public class Receipt {
    private String id;
    private ReceiptBody receiptBody;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ReceiptBody getReceiptBody() {
        return receiptBody;
    }

    public void setReceiptBody(ReceiptBody receiptBody) {
        this.receiptBody = receiptBody;
    }
}
