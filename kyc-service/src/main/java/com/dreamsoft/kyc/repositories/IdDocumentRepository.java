package com.dreamsoft.kyc.repositories;

import com.dreamsoft.kyc.entities.IdDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IdDocumentRepository extends JpaRepository<IdDocument, String> {
    public Optional<IdDocument> findFirstByCustomerIdOrderByCreatedDateDesc(Long customerId);
 /*   public List<IdDocument> findByIdReviewStatus(IdDocument.IdReviewStatus status);*/
}
