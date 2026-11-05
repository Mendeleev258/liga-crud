package org.example.ligacrud.client.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.OffsetDateTime;

@Entity
@Table(name = "client_account")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(
            name = "full_name",
            nullable = false,
            columnDefinition = "text"
    )
    private String fullName;

    @Column(name = "gender", length = 1)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(
            name = "status",
            length = 20,
            nullable = false
    )
    @Enumerated(EnumType.STRING)
    private ClientStatus status = ClientStatus.ACTIVE;

    @CreationTimestamp
    @Column(name = "create_dttm", nullable = false, updatable = false)
    private OffsetDateTime createDttm;

    @UpdateTimestamp
    @Column(name = "modify_dttm", nullable = false)
    private OffsetDateTime modifyDttm;


    // Constructors

    protected Client() {
    }

    public Client(String fullName, Gender gender) {
        this.fullName = fullName;
        this.gender = gender;
    }

    // Getters

    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public Gender getGender() {
        return gender;
    }

    public ClientStatus getStatus() {
        return status;
    }

    public OffsetDateTime getCreateDttm() {
        return createDttm;
    }

    public OffsetDateTime getModifyDttm() {
        return modifyDttm;
    }


    // Setters

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setStatus(ClientStatus status) {
        this.status = status;
    }
}
