package com.hermes.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.io.Serializable;
import java.util.UUID;

/**
 *  31.10.15.
 */
@MappedSuperclass
public abstract class AbstractPersistentObject implements Serializable{

    @Id
    @Column(name="ID")
    private UUID id;

    @Version
    @Column(name="VERSION")
    private Long version = null;

    @Column(name = "ENTITY_TYPE", length = 20, insertable = false, updatable = false)
    private String entityType;

    public AbstractPersistentObject() {
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    private void setId(UUID id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    private void setVersion(Long version) {
        this.version = version;
    }

//    public void incrementVersion(){
//        this.version = Long.valueOf(this.version+1);
//    }

    private String getEntityType() {
        return entityType;
    }

    private void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null ||
                !(o instanceof AbstractPersistentObject)) {

            return false;
        }

        AbstractPersistentObject other
                = (AbstractPersistentObject) o;

        // if the id is missing, return false
        if (id == null) return false;

        // equivalence by id
        return id.equals(other.getId());
    }

    public int hashCode() {
        if (id != null) {
            return id.hashCode();
        } else {
            return super.hashCode();
        }
    }

    public String toString() {
        return this.getClass().getName()
                + "[id=" + id + "]";
    }

    public boolean isCreation() {
        return version == null;
    }
}
