package com.dreamsoft.kyc.dtos;

import com.dreamsoft.kyc.entities.enumerations.IdType;
import lombok.Data;

import java.time.LocalDate;

@Data
public class IdDocuemntDTO {
    private String idType;
    private String idNumber;
    private LocalDate idExpirationDate;
}
