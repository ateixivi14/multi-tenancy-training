package com.example.multitenancytraining.repository;

import com.example.multitenancytraining.configuration.TenantContext;
import com.example.multitenancytraining.entity.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Long> {

    default Optional<Contract> findById(Long id) {
        return findByTenantIdAndId(TenantContext.getTenantId(), id);
    }
    
    List<Contract> findAll();
    
    Contract findContractByReference(String reference);

    Optional<Contract> findByTenantIdAndId(String tenantId, Long id);
    
}
