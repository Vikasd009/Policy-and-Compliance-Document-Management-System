package com.frigga.policy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.frigga.policy.model.PolicyDocument;
import com.frigga.policy.model.User;

public interface PolicyDocumentRepository extends JpaRepository<PolicyDocument, Long>{
	List<PolicyDocument> findByCreatedBy(User user);
}
