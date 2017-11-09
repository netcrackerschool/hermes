package com.hermes.domain.cargo;

import com.hermes.domain.AbstractPersistentObject;
import com.hermes.domain.orders.AbstractOrder;
import com.hermes.domain.hauls.AbstractHaul;

import javax.persistence.*;

/**
 *  26.10.15.
 */
@Entity
@Table(name = "CARGO")
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="ENTITY_TYPE", discriminatorType=DiscriminatorType.STRING, length = 20)
@DiscriminatorValue("ABSTRACT_CARGO")
public abstract class AbstractCargo extends AbstractPersistentObject {

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="ORDER_ID", referencedColumnName = "ID")
    protected AbstractOrder order;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="HAUL_ID", referencedColumnName = "ID")
    protected AbstractHaul haul;

    @Column(name="WEIGHT", nullable = false)
    protected double weight;

    @Column(name="VOLUME", nullable = false)
    protected double volume;

    AbstractCargo() {
    }

    public AbstractCargo(double weight, double volume) {
        this.weight = weight;
        this.volume = volume;
    }

    public AbstractCargo(AbstractOrder order, double weight, double volume) {
        this.order = order;
        this.weight = weight;
        this.volume = volume;
    }

    public AbstractHaul getHaul() {
        return haul;
    }

    public void setHaul(AbstractHaul haul) {
        this.haul = haul;
    }

    public double getWeight() {
        return weight;
    }

    public double getVolume() {
        return volume;
    }
}

