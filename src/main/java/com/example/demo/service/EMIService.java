package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.EMIRepository;
import com.example.demo.entity.EMI;
@Service
public class EMIService {
	@Autowired
    private EMIRepository emiRepository;

	public List<EMI> getAllEMIs() {
		// TODO Auto-generated method stub
		return null;
	}

    // CRUD operations
}


