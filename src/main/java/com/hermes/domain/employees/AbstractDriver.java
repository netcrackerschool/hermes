package com.hermes.domain.employees;

import com.hermes.domain.hauls.AbstractHaul;

import javax.persistence.*;

/**
 *  25.10.15.
 */
@Entity
@DiscriminatorValue("ABSTRACT_DRIVER")
public abstract class AbstractDriver extends AbstractEmployee {

    @OneToOne(cascade = CascadeType.PERSIST , fetch = FetchType.EAGER, mappedBy = "assignedDriver")
    protected AbstractHaul currentHaul;

    @Embedded
    private DriverLicense driverLicense = new DriverLicense();

    AbstractDriver() {
    }

    AbstractDriver(String name) {
        super(name);
    }

    AbstractDriver(String name, int salary) {
        super(name, salary);
    }

    public AbstractHaul getCurrentHaul() {
        return currentHaul;
    }

    public DriverLicense getDriverLicense() {
        return driverLicense;
    }

    public void setDriverLicense(DriverLicense driverLicense) {
        this.driverLicense = driverLicense;
    }
}
