package com.frigga.policy.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "audit_trails")
public class AuditTrail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String action;

    private LocalDateTime timestamp;

    @ManyToOne
    @JoinColumn(name = "document_id")
    private PolicyDocument document;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User performedBy;

    @PrePersist
    protected void onCreate() {
        this.timestamp = LocalDateTime.now();
    }

    // ✅ Constructors
    public AuditTrail() {
    }

    public AuditTrail(Long id, String action, LocalDateTime timestamp, PolicyDocument document, User performedBy) {
        this.id = id;
        this.action = action;
        this.timestamp = timestamp;
        this.document = document;
        this.performedBy = performedBy;
    }

    // ✅ Getters and Setters
    public Long getId() {
        return id;
    }

    public String getAction() {
        return action;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public PolicyDocument getDocument() {
        return document;
    }

    public User getPerformedBy() {
        return performedBy;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public void setDocument(PolicyDocument document) {
        this.document = document;
    }

    public void setPerformedBy(User performedBy) {
        this.performedBy = performedBy;
    }

    // ✅ Manual Builder
    public static class Builder {
        private Long id;
        private String action;
        private LocalDateTime timestamp;
        private PolicyDocument document;
        private User performedBy;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder action(String action) {
            this.action = action;
            return this;
        }

        public Builder timestamp(LocalDateTime timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder document(PolicyDocument document) {
            this.document = document;
            return this;
        }

        public Builder performedBy(User performedBy) {
            this.performedBy = performedBy;
            return this;
        }

        public AuditTrail build() {
            return new AuditTrail(id, action, timestamp, document, performedBy);
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    // ✅ equals, hashCode, toString
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AuditTrail)) return false;
        AuditTrail that = (AuditTrail) o;
        return Objects.equals(id, that.id) &&
               Objects.equals(action, that.action) &&
               Objects.equals(timestamp, that.timestamp) &&
               Objects.equals(document, that.document) &&
               Objects.equals(performedBy, that.performedBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, action, timestamp, document, performedBy);
    }

    @Override
    public String toString() {
        return "AuditTrail{" +
                "id=" + id +
                ", action='" + action + '\'' +
                ", timestamp=" + timestamp +
                ", document=" + document +
                ", performedBy=" + performedBy +
                '}';
    }
}