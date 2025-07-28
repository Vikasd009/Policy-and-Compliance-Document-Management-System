package com.frigga.policy.service;

import java.util.List;
import java.util.Optional;

import com.frigga.policy.model.PolicyDocument;
import com.frigga.policy.model.User;

public interface DocumentService {
	PolicyDocument create(PolicyDocument document);
    PolicyDocument update(PolicyDocument document);
    Optional<PolicyDocument> getById(Long id);
    List<PolicyDocument> getAll();
    List<PolicyDocument> getByAuthor(User author);
    void delete(Long id);
}
