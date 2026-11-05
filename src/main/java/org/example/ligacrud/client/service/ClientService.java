package org.example.ligacrud.client.service;

import org.example.ligacrud.client.dto.ClientResponse;
import org.example.ligacrud.client.dto.CreateClientRequest;
import org.example.ligacrud.client.dto.UpdateClientRequest;
import org.example.ligacrud.client.entity.Client;
import org.example.ligacrud.client.exception.ClientNotFoundException;
import org.example.ligacrud.client.repository.ClientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Transactional
    public ClientResponse createClient(CreateClientRequest request) {
        Client client = new Client(request.fullName(), request.gender());
        Client savedClient = clientRepository.save(client);
        return toResponse(savedClient);
    }

    @Transactional(readOnly = true)
    public List<ClientResponse> getAllClients() {
        return clientRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    @Transactional(readOnly = true)
    public ClientResponse getClientById(Long id) {
        return toResponse(findClientById(id));
    }

    @Transactional
    public ClientResponse updateClient(Long id, UpdateClientRequest request) {
        Client client = findClientById(id);

        if (request.fullName() != null) {
            client.setFullName(request.fullName());
        }
        if (request.gender() != null) {
            client.setGender(request.gender());
        }
        if (request.status() != null) {
            client.setStatus(request.status());
        }

        return toResponse(client);
    }

    @Transactional
    public void deleteClient(Long id) {
        Client client = findClientById(id);
        clientRepository.delete(client);
    }

    private Client findClientById(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new ClientNotFoundException(id));
    }

    private ClientResponse toResponse(Client client) {
        return new ClientResponse(
                client.getId(),
                client.getFullName(),
                client.getGender(),
                client.getStatus(),
                client.getCreateDttm(),
                client.getModifyDttm()
        );
    }

}
