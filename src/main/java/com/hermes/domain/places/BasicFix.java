package com.hermes.domain.places;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *  30.10.15.
 */
@Entity
@DiscriminatorValue("BASIC_FIX")
public class BasicFix extends AbstractFix {
    BasicFix() {
    }

    BasicFix(String name) {
        super(name);
    }
}
