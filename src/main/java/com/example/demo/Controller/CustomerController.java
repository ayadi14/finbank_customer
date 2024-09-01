package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Customer;
import com.example.demo.service.CustomerService;

@RestController

@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    

    @PostMapping("/register")
    public Customer registerCustomer(@RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
    }

    @GetMapping("/{customerId}")
    public Customer getCustomerById(@PathVariable Long customerId) {
        return customerService.getCustomerById(customerId);
    }

    @GetMapping("/email")
    public Customer getCustomerByEmail(@RequestParam String email) {
        return customerService.getCustomerByEmail(email);
    }
    @PutMapping("/{customerId}")
    public Customer updateCustomer(@PathVariable Long customerId, @RequestBody Customer customerDetails) {
        return customerService.updateCustomer(customerId, customerDetails);
    }
    @DeleteMapping("/{customerId}")
    public String deleteCustomer(@PathVariable Long customerId) {
        return customerService.deleteCustomer(customerId);
    }
}

