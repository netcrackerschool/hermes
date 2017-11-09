package com.hermes.infrastructure.dataaccess.services;

import com.hermes.domain.hauls.AbstractHaul;

/**
 *  05.10.15.
 */
public class HaulServiceImpl extends GenericServiceImpl<AbstractHaul> implements HaulService {
    public HaulServiceImpl(GenericRepository<AbstractHaul> repository) {
        super(repository);
    }
}
