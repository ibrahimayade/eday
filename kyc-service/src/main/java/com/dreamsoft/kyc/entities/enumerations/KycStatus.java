package com.dreamsoft.kyc.entities.enumerations;

public enum KycStatus {
    NOT_STARTED,
    PENDING,
    REJECTED_WITH_RETRY,
    REJECTED_WITH_BLOCK,
    ACCEPTED,
    BLOCKED,
    DISABLE,
    UNBLOCKED
}
