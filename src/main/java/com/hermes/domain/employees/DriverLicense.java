package com.hermes.domain.employees;

import javax.persistence.*;
import java.io.Serializable;
import java.util.EnumSet;
import java.util.Set;

/**
 *  30.10.15.
 */
@Embeddable
public class DriverLicense implements Serializable {

    @ElementCollection(targetClass = VehicleType.class, fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "DRIVER_LICENSES",
                     joinColumns = @JoinColumn(name="DRIVER_ID"))
    @Column(name="VEHICLE_CATEGORY")
    private Set<VehicleType> vehicleTypes;

    public Set<VehicleType> getAllVehicleTypes(){
        return this.vehicleTypes;
    }

    public boolean contains(VehicleType type){
        return this.vehicleTypes.contains(type);
    }

    public boolean addVehicleType(VehicleType type){
        return this.vehicleTypes.add(type);
    }

    public DriverLicense() {
        this.vehicleTypes = EnumSet.of(VehicleType.TRUCK);
    }

    public DriverLicense(VehicleType vehicleType) {
        this.vehicleTypes = EnumSet.of(vehicleType);
    }

    public DriverLicense(Set<VehicleType> vehicleTypes) {
        this.vehicleTypes = vehicleTypes;
    }
}
