package com.example.receiptprocessor.service;

import com.example.receiptprocessor.model.Receipt;

public interface ReceiptService {
    public void storeReceipt(Receipt receipt);

    public Receipt getReceipt(String receiptId);

    public void deleteReceipt(String receiptId);

}
