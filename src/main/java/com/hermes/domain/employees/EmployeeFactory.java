package com.hermes.domain.employees;

/**
 *  05.10.15.
 */
public interface EmployeeFactory {
    BasicDriver createBasicDriver(String name);

    BasicDriver createBasicDriver(String name, int salary);
}
