package com.dreamsoft.kyc.repositories;

import com.dreamsoft.kyc.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, String> {
    public Optional<Address> findFirstByCustomerIdOrderByCreatedDateDesc(Long customerId);

}
