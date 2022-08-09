package com.example.multitenancytraining.service;

import com.example.multitenancytraining.dto.ContractDto;
import com.example.multitenancytraining.repository.ContractRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.StaleObjectStateException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ContractService {
    private final ContractRepository contractRepository;

    public List<ContractDto> getContracts() {
        List<ContractDto> contractDtoList = new ArrayList<>();
        contractRepository.findAll().forEach(client -> contractDtoList.add(ContractDto.toDto(client)));
        return contractDtoList;
    }

    public ContractDto getContractById(Long contractId) {
        return   ContractDto.toDto(contractRepository.findById(contractId).orElseThrow());
    }

    public ContractDto getContractByReference(String ref) {
        return   ContractDto.toDto(contractRepository.findContractByReference(ref));
    }

}
