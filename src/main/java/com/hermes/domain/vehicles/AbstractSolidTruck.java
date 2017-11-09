package com.hermes.domain.vehicles;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *  25.10.15.
 */
@Entity
@DiscriminatorValue("ABSTRACT_SOLID_TRUCK")
public abstract class AbstractSolidTruck extends AbstractTruck {
    /*private List<SolidCargo> currentCargo;

    public AbstractSolidMannedTruck() {
    }

    public boolean addSolidCargo(SolidCargo cargo) {
        if(currentCargo == null){
            currentCargo = new ArrayList<>();
        }

        if(this.getAvailableWeight() >= cargo.getWeight() && this.getAvailableVolume() >= cargo.getVolume()){
            currentCargo.add(cargo);
            return true;
        }else{
            return false;
        }
    }

    public List<SolidCargo> unloadAll() {
        List<SolidCargo> temp = currentCargo;
        currentCargo = null;
        return temp;
    }*/

    AbstractSolidTruck() {
    }
}
