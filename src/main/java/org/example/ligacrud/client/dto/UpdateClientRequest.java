package org.example.ligacrud.client.dto;

import jakarta.validation.constraints.Pattern;
import org.example.ligacrud.client.entity.ClientStatus;
import org.example.ligacrud.client.entity.Gender;

public record UpdateClientRequest(
        @Pattern(regexp = ".*\\S.*", message = "fullName must not be blank")
        String fullName,
        Gender gender,
        ClientStatus status
) {
}
