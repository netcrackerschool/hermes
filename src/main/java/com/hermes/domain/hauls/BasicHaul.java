package com.hermes.domain.hauls;

import com.hermes.domain.employees.AbstractDriver;
import com.hermes.domain.milestones.FinishMilestone;
import com.hermes.domain.milestones.StartMilestone;
import com.hermes.domain.vehicles.AbstractVehicle;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *  26.10.15.
 */
@Entity
@DiscriminatorValue("BASIC_HAUL")
public class BasicHaul extends AbstractHaul {
    BasicHaul() {
    }

    public BasicHaul(StartMilestone start, FinishMilestone finish, AbstractDriver assignedDriver, AbstractVehicle assignedVehicle) {
        super(start, finish, assignedDriver, assignedVehicle);
    }

//    public BasicHaul(Milestone start, Milestone finish, Driver assignedDriver, AbstractVehicle assignedVehicle) {
//        super(start, finish, assignedDriver, assignedVehicle);
//    }
}
