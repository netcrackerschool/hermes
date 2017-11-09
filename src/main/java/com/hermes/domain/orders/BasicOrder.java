package com.hermes.domain.orders;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *  26.10.15.
 */
@Entity
@DiscriminatorValue("BASIC_ORDER")
public class BasicOrder extends AbstractOrder {
    BasicOrder() {
    }
}
