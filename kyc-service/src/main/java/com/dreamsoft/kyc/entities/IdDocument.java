package com.dreamsoft.kyc.entities;

import com.dreamsoft.kyc.entities.enumerations.IdType;
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
public class IdDocument {
    @Transient
    private static final int MAX_REVIEW_COUNT = 5;
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @CreatedDate
    @Column(name = "created_date", updatable = false)
    @JsonIgnore
    private Instant createdDate = Instant.now();

    private IdType idType;
    private String idNumber;
    private LocalDate idExpirationDate;
    @Column(name = "recto_id_picture")
    private String rectoIdPicture;
    @Column(name = "verso_id_picture")
    private String versoIdPicture;
    private String selfie;

    @Enumerated(EnumType.STRING)
    @Column(name = "id_review_status")
    private IdReviewStatus reviewStatus = IdReviewStatus.PENDING;
    @Column(name = "review_count")
    private int reviewCount = 0;
    private Long customerId;

    public boolean isMaxReviewCountReached() {
        return reviewCount > MAX_REVIEW_COUNT;
    }

    public void incrementReviewCount() {
        reviewCount += 1;
    }

    public boolean isApproved() {
        return this.reviewStatus.equals(IdReviewStatus.APPROVED);
    }

    public enum IdReviewStatus {
        APPROVED, REJECTED, PENDING, LOCKED_TEMP, LOCKED_FULL;
    }
}
