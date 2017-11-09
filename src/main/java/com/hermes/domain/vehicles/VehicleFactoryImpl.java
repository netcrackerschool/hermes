package com.hermes.domain.vehicles;

/**
 *  05.10.15.
 */
public class VehicleFactoryImpl implements VehicleFactory {

    public VehicleFactoryImpl() {
    }

    @Override
    public BasicTruck createBasicTruck(){
        return new BasicTruck();
    }
}
