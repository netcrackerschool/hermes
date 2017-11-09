package com.hermes.infrastructure.dataaccess.services;

import com.hermes.domain.places.AbstractPlace;

/**
 *  05.10.15.
 */
public class PlaceServiceImpl extends GenericServiceImpl<AbstractPlace> implements PlaceService {
    public PlaceServiceImpl(GenericRepository<AbstractPlace> repository) {
        super(repository);
    }
}
