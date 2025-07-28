package com.frigga.policy.service;

import java.util.List;

import com.frigga.policy.model.AuditTrail;
import com.frigga.policy.model.PolicyDocument;

public interface AuditTrailService {
	AuditTrail logAction(String action, PolicyDocument document, Long userId);
    List<AuditTrail> getHistoryByDocument(PolicyDocument document);
}
