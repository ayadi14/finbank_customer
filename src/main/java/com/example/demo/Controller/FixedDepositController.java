package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.FixedDeposit;
import com.example.demo.service.FixedDepositService;

@RestController
@RequestMapping("/api/fixed-deposits")
public class FixedDepositController {
    @Autowired
    private FixedDepositService fixedDepositService;

    @GetMapping
    public List<FixedDeposit> getAllFixedDeposits() {
        return fixedDepositService.getAllFixedDeposits();
    }

    // Other CRUD methods
}

