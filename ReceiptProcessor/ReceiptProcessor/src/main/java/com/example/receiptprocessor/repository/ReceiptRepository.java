package com.example.receiptprocessor.repository;

import com.example.receiptprocessor.model.Receipt;
import com.example.receiptprocessor.request.ReceiptBody;

public interface ReceiptRepository {
    void saveReceipt(Receipt receipt);

    Receipt getReceipt(String id);
}
