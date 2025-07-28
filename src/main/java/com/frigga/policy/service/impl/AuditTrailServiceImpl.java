package com.frigga.policy.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.frigga.policy.model.AuditTrail;
import com.frigga.policy.model.PolicyDocument;
import com.frigga.policy.model.User;
import com.frigga.policy.repository.AuditTrailRepository;
import com.frigga.policy.repository.UserRepository;
import com.frigga.policy.service.AuditTrailService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuditTrailServiceImpl implements AuditTrailService{
	private final AuditTrailRepository auditTrailRepository;
    private final UserRepository userRepository;

    public AuditTrail logAction(String action, PolicyDocument document, Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        AuditTrail audit = AuditTrail.builder()
                .action(action)
                .document(document)
                .performedBy(user)
                .build();
        return auditTrailRepository.save(audit);
    }

    public List<AuditTrail> getHistoryByDocument(PolicyDocument document) {
        return auditTrailRepository.findByDocument(document);
    }

	public AuditTrailServiceImpl(AuditTrailRepository auditTrailRepository, UserRepository userRepository) {
		super();
		this.auditTrailRepository = auditTrailRepository;
		this.userRepository = userRepository;
	}
}
