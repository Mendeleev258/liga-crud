package org.example.ligacrud.client.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import org.example.ligacrud.client.entity.ClientStatus;
import org.example.ligacrud.client.entity.Gender;

public record UpdateClientRequest(
        @Schema(example = "Ivanov Ivan Ivanovich")
        String fullName,
        Gender gender,
        ClientStatus status
) {
}
