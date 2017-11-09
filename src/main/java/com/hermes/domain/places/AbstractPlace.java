package com.hermes.domain.places;

import com.hermes.domain.AbstractPersistentObject;

import javax.persistence.*;

@Entity
@Table(name="PLACES")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="ENTITY_TYPE", discriminatorType=DiscriminatorType.STRING, length = 20)
@DiscriminatorValue("ABSTRACT_PLACE")
public abstract class AbstractPlace extends AbstractPersistentObject {

    @Column(name="NAME")
    private String name;

    public String getName() {
        return name;
    }

    AbstractPlace() {
    }

    AbstractPlace(String name) {
        this.name = name;
    }
}
