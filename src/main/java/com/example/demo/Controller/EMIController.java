package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.EMI;
import com.example.demo.service.EMIService;

@RestController
@RequestMapping("/api/emis")
public class EMIController {
    @Autowired
    private EMIService emiService;

    @GetMapping
    public List<EMI> getAllEMIs() {
        return emiService.getAllEMIs();
    }

    // Other CRUD methods
}
