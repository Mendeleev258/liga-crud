package org.example.ligacrud.client.controller;

import jakarta.validation.Valid;
import org.example.ligacrud.client.dto.ClientResponse;
import org.example.ligacrud.client.dto.CreateClientRequest;
import org.example.ligacrud.client.dto.UpdateClientRequest;
import org.example.ligacrud.client.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity<ClientResponse> createClient(
            @Valid @RequestBody CreateClientRequest createClientRequest) {
        ClientResponse clientResponse = clientService.createClient(createClientRequest);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(clientResponse);
    }

    @GetMapping
    public ResponseEntity<List<ClientResponse>> getAllClients() {
        return ResponseEntity.ok(clientService.getAllClients());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientResponse> getClientById(@PathVariable Long id) {
        return ResponseEntity.ok(clientService.getClientById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientResponse> updateClient(
            @PathVariable Long id,
            @Valid @RequestBody UpdateClientRequest updateClientRequest
    ) {
        return ResponseEntity.ok(clientService.updateClient(id, updateClientRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
        return ResponseEntity.noContent().build();
    }

}
