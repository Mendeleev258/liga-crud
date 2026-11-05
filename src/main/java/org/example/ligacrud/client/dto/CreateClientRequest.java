package org.example.ligacrud.client.dto;

import jakarta.validation.constraints.NotBlank;
import org.example.ligacrud.client.entity.Gender;

public record CreateClientRequest(
        @NotBlank
        String fullName,
        Gender gender
) {
}
