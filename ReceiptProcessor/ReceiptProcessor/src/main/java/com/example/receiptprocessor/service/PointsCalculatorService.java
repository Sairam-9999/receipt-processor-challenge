package com.example.receiptprocessor.service;

import com.example.receiptprocessor.request.ReceiptBody;

public interface PointsCalculatorService {
    double calculatePoints(ReceiptBody receipt);
}
