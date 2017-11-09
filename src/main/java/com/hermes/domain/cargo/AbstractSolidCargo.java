package com.hermes.domain.cargo;

import com.hermes.domain.orders.AbstractOrder;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *  30.10.15.
 */
@Entity
@DiscriminatorValue("ABSTRACT_SOLID_CARGO")
public abstract class AbstractSolidCargo extends AbstractCargo {
    AbstractSolidCargo() {
    }

    public AbstractSolidCargo(AbstractOrder order, double weight, double volume) {
        super(order, weight, volume);
    }
}
