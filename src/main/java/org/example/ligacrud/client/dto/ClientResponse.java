package org.example.ligacrud.client.dto;

import org.example.ligacrud.client.entity.ClientStatus;
import org.example.ligacrud.client.entity.Gender;

import java.time.OffsetDateTime;

public record ClientResponse(
        Long id,
        String fullName,
        Gender gender,
        ClientStatus status,
        OffsetDateTime createDttm,
        OffsetDateTime modifyDttm
) {
}
