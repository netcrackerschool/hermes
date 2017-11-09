package com.hermes.domain.employees;

/**
 *  02.10.15.
 */
public class EmployeeFactoryImpl implements EmployeeFactory {

    public EmployeeFactoryImpl() {
    }

    @Override
    public BasicDriver createBasicDriver(String name){
        return new BasicDriver(name);
    }

    @Override
    public BasicDriver createBasicDriver(String name, int salary){
        return new BasicDriver(name, salary);
    }
}
