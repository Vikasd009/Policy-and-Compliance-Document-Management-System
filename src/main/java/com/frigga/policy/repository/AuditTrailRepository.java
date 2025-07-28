package com.frigga.policy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.frigga.policy.model.AuditTrail;
import com.frigga.policy.model.PolicyDocument;

public interface AuditTrailRepository extends JpaRepository<AuditTrail, Long>{
	List<AuditTrail> findByDocument(PolicyDocument document);
}
