package com.dreamsoft.kyc.repositories;
import com.dreamsoft.kyc.entities.Kyc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface KycRepository extends JpaRepository<Kyc, Long> {
    public Optional<Kyc> findFirstByCustomerIdOrderByCreatedDateDesc(Long customerId);
}
