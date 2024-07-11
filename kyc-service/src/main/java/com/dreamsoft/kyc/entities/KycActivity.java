package com.dreamsoft.kyc.entities;

import com.dreamsoft.kyc.entities.enumerations.KycRejectedReason;
import com.dreamsoft.kyc.entities.enumerations.KycStep;
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
public class KycActivity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @CreatedDate
    @Column(name = "created_date", updatable = false)
    @JsonIgnore
    private Instant createdDate = Instant.now();
    @Column(name = "customer_id", updatable = false, nullable = false)
    private Long customerId;
    @Enumerated(EnumType.STRING)
    @Column(name = "kyc_step", updatable = false, nullable = false)
    private KycStep kycStep;
    @Enumerated(EnumType.STRING)
    @Column(name = "kyc_rejected_reason", updatable = false)
    private KycRejectedReason rejectedReason;
}
