package com.dreamsoft.kyc.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AddressDTO {
    private String state;
    @NotBlank(message = "city must be provided")
    private String city;
    private String postalCode;
    @NotBlank(message = "street address must be provided")
    private String streetAddress;
    private String additionalAddress;
}
