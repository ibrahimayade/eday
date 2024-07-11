package com.dreamsoft.kyc.entities;

import com.dreamsoft.kyc.entities.enumerations.*;
import com.dreamsoft.kyc.models.Customer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.Instant;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Kyc {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @CreatedDate
    @Column(name = "created_date", updatable = false)
    @JsonIgnore
    private Instant createdDate = Instant.now();
    private LocalDate birthDate;
    private String nationality;
    private String countryOfBirth;
    private String cityOfBirth;

    @Enumerated(EnumType.STRING)
    @Column(name = "id_review_status")
    private IdDocument.IdReviewStatus idReviewStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "id_rejected_reason")
    private IdRejectedReason  idRejectedReason;

    @Enumerated(EnumType.STRING)
    @Column(name = "address_review_status")
    private Address.AddressReviewStatus addressReviewStatus;

    @Column(name = "address_rejected_reason")
    private AddressRejectedReason addressRejectedReason;
    @Enumerated(EnumType.STRING)
    @Column(name = "kyc_status")
    private KycStatus kycStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "kyc_rejected_reason")
    private KycRejectedReason kycRejectedReason;
    private Long customerId;
    @Transient
    private Customer customer;
}
