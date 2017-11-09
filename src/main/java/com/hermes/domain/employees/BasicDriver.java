package com.hermes.domain.employees;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *  25.10.15.
 */
@Entity
@DiscriminatorValue("BASIC_DRIVER")
public class BasicDriver extends AbstractDriver {
    BasicDriver() {
    }

    BasicDriver(String name) {
        super(name);
    }

    BasicDriver(String name, int salary) {
        super(name, salary);
    }
}
