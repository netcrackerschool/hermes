package com.hermes.domain.places;

import javax.persistence.*;

/**
 *  26.10.15.
 */
@Entity
@DiscriminatorValue("ABSTRACT_FIX")
public abstract class AbstractFix extends AbstractPlace {

    AbstractFix() {
    }

    AbstractFix(String name) {
        super(name);
    }
}
