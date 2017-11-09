package com.hermes.infrastructure.dataaccess.services;

import com.hermes.domain.orders.AbstractOrder;

/**
 *  05.10.15.
 */
public class OrderServiceImpl extends GenericServiceImpl<AbstractOrder> implements OrderService {
    public OrderServiceImpl(GenericRepository<AbstractOrder> repository) {
        super(repository);
    }
}