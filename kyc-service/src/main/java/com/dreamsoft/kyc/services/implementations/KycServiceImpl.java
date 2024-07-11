package com.dreamsoft.kyc.services.implementations;

import com.dreamsoft.kyc.dtos.AddressDTO;
import com.dreamsoft.kyc.entities.Address;
import com.dreamsoft.kyc.entities.IdDocument;
import com.dreamsoft.kyc.entities.Kyc;
import com.dreamsoft.kyc.mappers.AddressMapper;
import com.dreamsoft.kyc.repositories.AddressRepository;
import com.dreamsoft.kyc.repositories.IdDocumentRepository;
import com.dreamsoft.kyc.repositories.KycActivityRepository;
import com.dreamsoft.kyc.repositories.KycRepository;
import com.dreamsoft.kyc.services.interfaces.KycService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class KycServiceImpl implements KycService {
    private final KycRepository kycRepository;
    private final AddressRepository addressRepository;
    private final IdDocumentRepository idDocumentRepository;
    private final KycActivityRepository kycActivityRepository;
    private final AddressMapper addressMapper;


    public Address setupAddress(Long customerId, AddressDTO dto) {
        if (isAddressDefine(customerId)) {
            throw new RuntimeException();
        }
        Address address = addressMapper.toEntity(dto);
        address.setCustomerId(customerId);
        address.setReviewStatus(Address.AddressReviewStatus.PENDING);
        return addressRepository.save(address);

    }

    @Override
    public Address updateAddress(String addressId, AddressDTO dto) {
        Address address = getAddress(addressId);
        address.setAdditionalAddress(dto.getAdditionalAddress());
        address.setCity(dto.getCity());
        address.setPostalCode(dto.getPostalCode());
        address.setStreetAddress(dto.getStreetAddress());
        return addressRepository.save(address);
    }

    @Override
    public Address getAddress(String addressId) {
        return addressRepository.findById(addressId).orElseThrow(() -> new RuntimeException());
    }

    @Override
    public Kyc getCustomerKyc(Long customerId) {
        return kycRepository.findFirstByCustomerIdOrderByCreatedDateDesc(customerId).orElseThrow(() -> new RuntimeException());
    }

    @Override
    public Address getCustomerAddress(Long customerId) {
        return addressRepository.findFirstByCustomerIdOrderByCreatedDateDesc(customerId).orElseThrow(() -> new RuntimeException());
    }

    @Override
    public IdDocument getCustomerIdDocument(Long customerId) {
        return idDocumentRepository.findFirstByCustomerIdOrderByCreatedDateDesc(customerId).orElseThrow(() -> new RuntimeException());
    }

    public Boolean isAddressDefine(Long customerId) {
        return addressRepository.findFirstByCustomerIdOrderByCreatedDateDesc(customerId).isPresent() ? Boolean.TRUE : Boolean.FALSE;

    }
}
