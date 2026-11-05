package org.example.ligacrud.client.exception;

public class ClientNotFoundException extends RuntimeException {

    public ClientNotFoundException(Long id) {
        super("Client with id " + id + " not found");
    }
}
