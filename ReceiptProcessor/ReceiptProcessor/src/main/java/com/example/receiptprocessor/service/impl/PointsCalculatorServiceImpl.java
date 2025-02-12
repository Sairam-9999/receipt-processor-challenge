package com.example.receiptprocessor.service.impl;

import com.example.receiptprocessor.request.Item;
import com.example.receiptprocessor.request.ReceiptBody;
import com.example.receiptprocessor.service.PointsCalculatorService;
import org.springframework.stereotype.Service;

@Service
public class PointsCalculatorServiceImpl implements PointsCalculatorService {


    @Override
    public double calculatePoints(ReceiptBody receipt) {
        int points = 0;

        // One point for every alphanumeric character in the retailer name
        points += receipt.getRetailer().replaceAll("[^a-zA-Z0-9]", "").length();

        // 50 points if the total is a round dollar amount with no cents
        if (receipt.getTotal().matches("^\\d+\\.00$")) {
            points += 50;
        }

        // 25 points if the total is a multiple of 0.25
        if (Double.parseDouble(receipt.getTotal()) % 0.25 == 0) {
            points += 25;
        }

        // 5 points for every two items on the receipt
        points += (receipt.getItems().size() / 2) * 5;

        // Points for item descriptions
        for (Item item : receipt.getItems()) {
            int descriptionLength = item.getShortDescription().trim().length();
            if (descriptionLength % 3 == 0) {
                points += Math.ceil(Double.parseDouble(item.getPrice()) * 0.2);
            }
        }

        // 5 points if the total is greater than 10.00
        if (Double.parseDouble(receipt.getTotal()) > 10.00) {
            points += 5;
        }

        // 6 points if the day in the purchase date is odd
        int day = Integer.parseInt(receipt.getPurchaseDate().split("-")[2]);
        if (day % 2 != 0) {
            points += 6;
        }

        // 10 points if the time of purchase is after 2:00pm and before 4:00pm
        String[] timeParts = receipt.getPurchaseTime().split(":");
        int hour = Integer.parseInt(timeParts[0]);
        int minute = Integer.parseInt(timeParts[1]);
        if (hour == 14 || (hour == 15 && minute < 60)) {
            points += 10;
        }

        return points;
    }
}
