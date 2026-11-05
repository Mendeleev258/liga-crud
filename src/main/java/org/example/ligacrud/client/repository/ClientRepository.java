package org.example.ligacrud.client.repository;

import org.example.ligacrud.client.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
