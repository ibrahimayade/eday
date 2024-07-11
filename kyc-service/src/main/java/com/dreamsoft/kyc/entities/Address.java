package com.dreamsoft.kyc.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.Instant;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @CreatedDate
    @Column(name = "created_date", updatable = false)
    @JsonIgnore
    private Instant createdDate = Instant.now();
    private String state;
    private String city;
    private String postalCode;
    private String streetAddress;
    private String additionalAddress;
    private String proofOfAddressUrl;
    private Long customerId;
    @Enumerated(EnumType.STRING)
    @Column(name = "Id_review_status")
    private AddressReviewStatus reviewStatus = AddressReviewStatus.PENDING;
    public enum AddressReviewStatus {
        APPROVED, REJECTED, PENDING, LOCKED_TEMP, LOCKED_FULL;
    }
}
