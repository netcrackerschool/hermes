package com.hermes.infrastructure.dataaccess.services;

import com.hermes.domain.employees.AbstractEmployee;

/**
 *  05.10.15.
 */
public class EmployeeServiceImpl extends GenericServiceImpl<AbstractEmployee> implements EmployeeService {
    public EmployeeServiceImpl(GenericRepository<AbstractEmployee> repository) {
        super(repository);
    }
}

