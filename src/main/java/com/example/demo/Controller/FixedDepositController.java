package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.FixedDepositDto;
import com.example.demo.entity.FixedDeposit;
import com.example.demo.service.FixedDepositService;

@RestController
@RequestMapping("/api/fixed-deposits")
public class FixedDepositController {


 @Autowired
 private FixedDepositService fixedDepositService;

 @GetMapping("/path")
 
 public List<FixedDepositDto> getAllFixedDeposits() {
     return fixedDepositService.getAllFixedDeposits();
 }

 @GetMapping("/{id}")
 public ResponseEntity<FixedDepositDto> getFixedDepositById(@PathVariable Long id) {
     FixedDepositDto fixedDepositDTO = fixedDepositService.getFixedDepositById(id);
     return ResponseEntity.ok(fixedDepositDTO);
 }

// @PostMapping("/path2")
 //public ResponseEntity<String> createFixedDeposit(@RequestBody FixedDepositDto requestDTO) {
     // Process the request
   //  return new ResponseEntity<>("Fixed Deposit created successfully!", HttpStatus.CREATED);
 //}
 @PostMapping("/path1")
  public String createFixedDepositByUser(@RequestBody FixedDepositDto dto ) {
	return fixedDepositService.createFixedDepositByUser(dto);
	 
 }
 @PutMapping("/{id}")
 public ResponseEntity<FixedDepositDto> updateFixedDeposit(@PathVariable String id, @RequestBody FixedDepositDto fixedDepositDTO) {
     FixedDepositDto updatedFixedDeposit = fixedDepositService.updateFixedDeposit(id, fixedDepositDTO);
     return ResponseEntity.ok(updatedFixedDeposit);
 }

 @DeleteMapping("/{id}")
 public ResponseEntity<Void> deleteFixedDeposit(@PathVariable String id) {
     fixedDepositService.deleteFixedDeposit(id);
     return ResponseEntity.noContent().build();
 }
}
