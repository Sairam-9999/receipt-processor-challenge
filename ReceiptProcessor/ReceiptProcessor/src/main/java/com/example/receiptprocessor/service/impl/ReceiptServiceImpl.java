package com.example.receiptprocessor.service.impl;

import com.example.receiptprocessor.model.Receipt;
import com.example.receiptprocessor.repository.ReceiptRepository;
import com.example.receiptprocessor.request.ReceiptBody;
import com.example.receiptprocessor.service.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReceiptServiceImpl implements ReceiptService {
    private final ReceiptRepository repository;

    ReceiptServiceImpl(@Autowired ReceiptRepository repository) {
        this.repository = repository;
    }
    @Override
    public void storeReceipt(Receipt receipt) {
        repository.saveReceipt(receipt);
    }

    @Override
    public Receipt getReceipt(String receiptId) {
        return repository.getReceipt(receiptId);
    }

    @Override
    public void deleteReceipt(String receiptId) {

    }
}
