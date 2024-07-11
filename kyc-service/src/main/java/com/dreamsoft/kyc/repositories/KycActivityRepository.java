package com.dreamsoft.kyc.repositories;

import com.dreamsoft.kyc.entities.KycActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface KycActivityRepository extends JpaRepository<KycActivity, String> {
    public List<KycActivity> findByCustomerIdOrderByCreatedDateDesc(Long customerId);
    public Optional<KycActivity> findFirstByCustomerIdOrderByCreatedDateDesc(Long customerId);

}
