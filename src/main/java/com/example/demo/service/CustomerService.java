package com.example.demo.service;




import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.CustomerRepository;
import com.example.demo.entity.Customer;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer getCustomerById(Long customerId) {
        return customerRepository.findById(customerId).orElse(null);
    }

    public Customer getCustomerByEmail(String email) {
        return customerRepository.findByEmail(email);
    }

    public Customer updateCustomer(Long customerId, Customer customerDetails) {
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        if (optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();
            customer.setName(customerDetails.getName());
            customer.setEmail(customerDetails.getEmail());
            customer.setPassword(customerDetails.getPassword());
            customer.setBalance(customerDetails.getBalance());
            return customerRepository.save(customer);
        }
        return null;
    }
    public String deleteCustomer(Long customerId) {
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        if (optionalCustomer.isPresent()) {
            customerRepository.deleteById(customerId);
            return "Customer deleted successfully.";
        } else {
            return "Customer not found.";
        }
    }

            // Other methods...

            public Customer patchCustomer(Long customerId, Map<String, Object> updates) {
                Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
                if (optionalCustomer.isPresent()) {
                    Customer customer = optionalCustomer.get();

                    updates.forEach((key, value) -> {
                        switch (key) {
                            case "name":
                                customer.setName((String) value);
                                break;
                            case "email":
                                customer.setEmail((String) value);
                                break;
                            case "password":
                                customer.setPassword((String) value);
                                break;
                            case "balance":
                                customer.setBalance(Double.parseDouble(value.toString()));
                                break;
                            // Add other fields as needed
                        }
                    });

                    return customerRepository.save(customer);
                }
                return null;
            }


            // Other methods...
			 public boolean existsById(Long customerId) {
			        return customerRepository.existsById(customerId);
			    }


    }