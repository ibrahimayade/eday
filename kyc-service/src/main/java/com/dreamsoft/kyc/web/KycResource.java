package com.dreamsoft.kyc.web;

import com.dreamsoft.kyc.clients.CustomerRestClient;
import com.dreamsoft.kyc.dtos.AddressDTO;
import com.dreamsoft.kyc.entities.Address;
import com.dreamsoft.kyc.entities.Kyc;
import com.dreamsoft.kyc.models.Customer;
import com.dreamsoft.kyc.services.interfaces.KycService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kycs")
@Slf4j
@Tag(name = "ONBOARDING - API", description = "Permet de faire le kyc")
@Validated
@RequiredArgsConstructor
public class KycResource {
    private final KycService kycService;
    private final CustomerRestClient customerRestClient;

    @Operation(summary = "Api pour visualiser le kyc d'un customer")
    @GetMapping("/customer/{customerId}")
    public ResponseEntity<Kyc> getCustomerKyc(@PathVariable final Long customerId) {
        Kyc kyc = kycService.getCustomerKyc(customerId);
        Customer customer = customerRestClient.findCustomerById(kyc.getCustomerId());
        kyc.setCustomer(customer);
        return ResponseEntity.ok().body(kyc);
    }

    @Operation(summary = "Api pour visualiser une adresse")
    @GetMapping("/address/details/{addressId}")

    public ResponseEntity<Address> getAdressDetails(@RequestParam(value = "addressId") final String addressId) {
        Address address = kycService.getAddress(addressId);
        return ResponseEntity.ok().body(address);
    }

    @Operation(summary = "Api pour visualiser l'addresse d'un customer")
    @GetMapping("customer/{customerId}/address")

    public ResponseEntity<Address> getCustomerAdress(@PathVariable final Long customerId) {
        Address address = kycService.getCustomerAddress(customerId);
        return ResponseEntity.ok().body(address);
    }

    @Operation(summary = "Api pour definir l'adresse")
    @PostMapping("customer/{customerId}/address")

    public ResponseEntity<Address> setupAdress(@PathVariable final Long customerId, @RequestBody @Valid AddressDTO addressDTO) {
        Address address = kycService.setupAddress(customerId, addressDTO);
        return ResponseEntity.ok().body(address);
    }

    @Operation(summary = "Api pour modifier l'adresse")
    @PostMapping("/address/{addressId}")

    public ResponseEntity<Address> updateAdress(@RequestParam(value = "addressId") final String addressId, @RequestBody @Valid AddressDTO addressDTO) {
        Address address = kycService.updateAddress(addressId, addressDTO);
        return ResponseEntity.ok().body(address);
    }

}
