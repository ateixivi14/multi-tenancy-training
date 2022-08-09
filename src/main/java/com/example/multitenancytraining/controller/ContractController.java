package com.example.multitenancytraining.controller;

import com.example.multitenancytraining.dto.ContractDto;
import com.example.multitenancytraining.service.ContractService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/contracts")
public class ContractController {

   private final ContractService contractService;

    @GetMapping
    public List<ContractDto> getContracts() {
        return contractService.getContracts();
    }
    
    @GetMapping("/{contractId}") 
    public ContractDto getContractByContractId(@PathVariable long contractId) {
        return contractService.getContractById(contractId);
    }

}
