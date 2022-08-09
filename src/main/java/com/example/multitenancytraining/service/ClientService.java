package com.example.multitenancytraining.service;

import com.example.multitenancytraining.controller.ClientRequest;
import com.example.multitenancytraining.dto.ClientDto;
import com.example.multitenancytraining.entity.Client;
import com.example.multitenancytraining.repository.ClientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }
    
    public List<ClientDto> getClients() {
        List<ClientDto> clientDtoList = new ArrayList<>();
        clientRepository.findAll().forEach(client -> clientDtoList.add(ClientDto.toDto(client)));
        return clientDtoList;
    }
    
    public void removeClientById(Long id) {
       clientRepository.deleteClientById(id);
    }
    
    public void addClient(ClientRequest clientRequest) {
        Client client = Client.builder()
                .name(clientRequest.getName())
                .deleted(clientRequest.isDeleted())
                .nationalId(clientRequest.getNationalId())
                .build();
        clientRepository.save(client);
    }

}
