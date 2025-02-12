package com.example.receiptprocessor.repository.impl;

import com.example.receiptprocessor.model.Receipt;
import com.example.receiptprocessor.repository.ReceiptRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class ReceiptRepositoryImpl implements ReceiptRepository {
    private Map<String, Receipt> receipts = new ConcurrentHashMap<>();
    @Override
    public void saveReceipt(Receipt receipt) {
        receipts.put(receipt.getId(), receipt);
    }

    @Override
    public Receipt getReceipt(String id) {
        return receipts.get(id);
    }
}
