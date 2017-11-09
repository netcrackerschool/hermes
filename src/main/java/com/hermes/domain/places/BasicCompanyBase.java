package com.hermes.domain.places;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *  26.10.15.
 */
@Entity
@DiscriminatorValue("BASIC_COMPANY_BASE")
public class BasicCompanyBase extends AbstractBase {

    BasicCompanyBase() {
    }

    BasicCompanyBase(String name) {
        super(name);
    }
}
