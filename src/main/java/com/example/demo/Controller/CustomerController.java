package com.example.demo.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    @PutMapping(" update/{customerId}")
    public Customer updateCustomer(@PathVariable Long customerId, @RequestBody Customer customerDetails) {
        return customerService.updateCustomer(customerId, customerDetails);
    }
    @DeleteMapping("delete/{customerId}")
    public String deleteCustomer(@PathVariable Long customerId) {
        return customerService.deleteCustomer(customerId);
    }

    @PatchMapping("patch/{customerId}")
    public Customer patchCustomer(@PathVariable Long customerId, @RequestBody Map<String, Object> updates) {
        return customerService.patchCustomer(customerId, updates);
    }
    @RequestMapping(value = "/{customerId}", method = RequestMethod.HEAD)
    public ResponseEntity<Void> headCustomer(@PathVariable Long customerId) {
        if (customerService.existsById(customerId)) {
            return new ResponseEntity<>(HttpStatus.OK); // 200 OK if the customer exists
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404 Not Found if the customer doesn't exist
        }
    
}
}

