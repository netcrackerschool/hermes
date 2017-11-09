package com.hermes.infrastructure.dataaccess.services;


import com.hermes.domain.cargo.AbstractCargo;

/**
 *  05.10.15.
 */
public class CargoServiceImpl extends GenericServiceImpl<AbstractCargo> implements CargoService {
    public CargoServiceImpl(GenericRepository<AbstractCargo> repository) {
        super(repository);
    }
}
