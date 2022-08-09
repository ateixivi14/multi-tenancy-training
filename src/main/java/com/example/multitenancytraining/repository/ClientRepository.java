package com.example.multitenancytraining.repository;

import com.example.multitenancytraining.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    
    /*default List<Client> findAll(){
        return findByTenantId(ThreadTenant.getTenantId());
    } */
    List<Client> findAll();
        
    List<Client> findByTenantId(String tenantId);

    @Modifying
    @Transactional
    void deleteClientById(Long id);

}
