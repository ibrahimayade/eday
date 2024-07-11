package com.dreamsoft.kyc.services.interfaces;

import com.dreamsoft.kyc.dtos.AddressDTO;
import com.dreamsoft.kyc.entities.Address;
import com.dreamsoft.kyc.entities.IdDocument;
import com.dreamsoft.kyc.entities.Kyc;

public interface KycService {
    public Boolean isAddressDefine(Long customerId);
    public Address setupAddress(Long customerId, AddressDTO dto);
    public Address updateAddress(String addressId, AddressDTO dto);
    public Address getAddress(String id);
    public Kyc getCustomerKyc(Long customerId);
    public Address getCustomerAddress(Long customerId);
    public IdDocument getCustomerIdDocument(Long customerId);
}
