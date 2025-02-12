package com.example.receiptprocessor.controller;

import com.example.receiptprocessor.model.Receipt;
import com.example.receiptprocessor.request.ReceiptBody;
import com.example.receiptprocessor.service.PointsCalculatorService;
import com.example.receiptprocessor.service.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/receipts")
public class ReceiptController {

    private ReceiptService receiptService;
    private PointsCalculatorService calculatorService;

    @PostMapping("/process")
    public ResponseEntity<Map<String, String>> processReceipt(@Valid @RequestBody ReceiptBody receipt) {
        String receiptId = java.util.UUID.randomUUID().toString();
        receiptService.storeReceipt(toReceiptDto(receipt, receiptId));
        Map<String, String> response = new HashMap<>();
        response.put("id", receiptId);
        return ResponseEntity.ok(response);
    }

    private Receipt toReceiptDto(ReceiptBody receipt, String receiptId) {
        Receipt receiptDto = new Receipt();
        receiptDto.setId(receiptId);
        receiptDto.setReceiptBody(receipt);
        return receiptDto;
    }


    @GetMapping("/{id}/points")
    public ResponseEntity<Map<String, Double>> getPoints(@PathVariable String id) {
        Receipt receipt = receiptService.getReceipt(id);
        if (receipt == null) {
            return ResponseEntity.status(404).body(null);
        }
        Map<String, Double> response = new HashMap<>();
        response.put("points", calculatorService.calculatePoints(receiptService.getReceipt(id).getReceiptBody()));
        return ResponseEntity.ok(response);
    }

    private int calculatePoints(ReceiptBody receipt) {
        // Implement your points calculation logic here
        return 100; // Example points
    }

    @Autowired
    public void setReceiptService(ReceiptService receiptService) {
        this.receiptService = receiptService;
    }

    @Autowired
    public void setCalculatorService(PointsCalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }
}