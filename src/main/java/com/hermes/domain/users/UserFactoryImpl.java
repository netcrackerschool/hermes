package com.hermes.domain.users;

import com.hermes.domain.employees.AbstractEmployee;
import com.hermes.domain.employees.EmployeeFactory;

/**
 *  02.10.15.
 */
public class UserFactoryImpl implements UserFactory {

    private final EmployeeFactory employeeFactory;

    public UserFactoryImpl(EmployeeFactory employeeFactory) {
        this.employeeFactory = employeeFactory;
    }

    @Override
    public AbstractUser createUser(String login, String password, String name, Role role){
        if(role != Role.DRIVER){
            return new BasicUser(login, password, name, role);
        }

        AbstractEmployee representation = employeeFactory.createBasicDriver(name);
        AbstractUser user = new RepresentedUser(login, password, name, role, representation);
        return user;
    }
}
