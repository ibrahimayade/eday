package com.dreamsoft.kyc.mappers;

import com.dreamsoft.kyc.dtos.AddressDTO;
import com.dreamsoft.kyc.entities.Address;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);
    public Address toEntity(AddressDTO dto);

    public AddressDTO toDTO(Address address);
}
