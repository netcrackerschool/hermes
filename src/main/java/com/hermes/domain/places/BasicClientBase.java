package com.hermes.domain.places;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *  26.10.15.
 */
@Entity
@DiscriminatorValue("BASIC_CLIENT_BASE")
public class BasicClientBase extends AbstractBase {
    BasicClientBase() {
    }

    BasicClientBase(String name) {
        super(name);
    }
}
