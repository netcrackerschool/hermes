package com.hermes.infrastructure.dataaccess.services;

import com.hermes.domain.vehicles.AbstractVehicle;

/**
 *  05.10.15.
 */
public class VehicleServiceImpl extends GenericServiceImpl<AbstractVehicle> implements VehicleService {
    public VehicleServiceImpl(GenericRepository<AbstractVehicle> repository) {
        super(repository);
    }
}
