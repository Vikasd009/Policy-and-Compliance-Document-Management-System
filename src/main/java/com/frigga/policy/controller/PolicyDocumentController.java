package com.frigga.policy.controller;

import com.frigga.policy.model.PolicyDocument;
import com.frigga.policy.repository.PolicyDocumentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/documents")
public class PolicyDocumentController {
//	 private static final PolicyDocumentController policyDocumentService = null;
	 @Autowired
	    private PolicyDocumentRepository documentRepository;

	    // POST: Create document
	    @PostMapping
	    public ResponseEntity<PolicyDocument> createDocument(@RequestBody PolicyDocument doc) {
	        return ResponseEntity.ok(documentRepository.save(doc));
	    }

	    // GET: All documents
	    @GetMapping
	    public ResponseEntity<List<PolicyDocument>> getAllDocuments() {
	        return ResponseEntity.ok(documentRepository.findAll());
	    }
	    
	    	    
	    @PutMapping("/{id}")
	    public ResponseEntity<PolicyDocument> updateDocument(@PathVariable Long id, @RequestBody PolicyDocument updatedDoc) {
	        Optional<PolicyDocument> existingDocOpt = documentRepository.findById(id);

	        if (existingDocOpt.isEmpty()) {
	            return ResponseEntity.notFound().build();
	        }

	        PolicyDocument existingDoc = existingDocOpt.get();
	        existingDoc.setTitle(updatedDoc.getTitle());
	        existingDoc.setContent(updatedDoc.getContent());
	        existingDoc.setCategory(updatedDoc.getCategory());

	        PolicyDocument savedDoc = documentRepository.save(existingDoc);
	        return ResponseEntity.ok(savedDoc);
	    }


	    // PUT: Update document status
	    @PutMapping("/{id}/status")
	    public ResponseEntity<PolicyDocument> updateStatus(
	            @PathVariable Long id,
	            @RequestBody PolicyDocument update
	    ) {
	        return documentRepository.findById(id)
	                .map(existing -> {
	                    existing.setStatus(update.getStatus());
	                    return ResponseEntity.ok(documentRepository.save(existing));
	                })
	                .orElse(ResponseEntity.notFound().build());
	    }
	    
	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteDocument(@PathVariable Long id) {
	        if (!documentRepository.existsById(id)) {
	            return ResponseEntity.notFound().build();
	        }

	        documentRepository.deleteById(id);
	        return ResponseEntity.noContent().build();
	    }
}
