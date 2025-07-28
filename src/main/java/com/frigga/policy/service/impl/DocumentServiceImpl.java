package com.frigga.policy.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.frigga.policy.model.PolicyDocument;
import com.frigga.policy.model.User;
import com.frigga.policy.repository.PolicyDocumentRepository;
import com.frigga.policy.service.DocumentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DocumentServiceImpl implements DocumentService{
	private final PolicyDocumentRepository documentRepository;

    public PolicyDocument create(PolicyDocument document) {
        return documentRepository.save(document);
    }

    public PolicyDocument update(PolicyDocument document) {
        return documentRepository.save(document);
    }

    public Optional<PolicyDocument> getById(Long id) {
        return documentRepository.findById(id);
    }

    public List<PolicyDocument> getAll() {
        return documentRepository.findAll();
    }

    public List<PolicyDocument> getByAuthor(User author) {
        return documentRepository.findByAuthor(author);
    }
    
    public void delete(Long id) {
        documentRepository.deleteById(id);
    }

	public DocumentServiceImpl(PolicyDocumentRepository documentRepository) {
		super();
		this.documentRepository = documentRepository;
	}

}
