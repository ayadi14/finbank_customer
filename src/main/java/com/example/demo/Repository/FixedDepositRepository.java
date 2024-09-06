package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.FixedDeposit;

public interface FixedDepositRepository extends JpaRepository<FixedDeposit, String> {
	}	

