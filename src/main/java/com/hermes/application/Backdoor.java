package com.hermes.application;

import com.hermes.domain.users.Role;
import com.hermes.domain.users.UserFactory;
import com.hermes.infrastructure.dataaccess.services.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Backdoor {

    public static void main(String[] args){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        UserService userService = context.getBean(UserService.class);
        UserFactory userFactory = context.getBean(UserFactory.class);

        userService.add(userFactory.createUser("Dudkin", "123", "Pavel Dudkin", Role.ADMIN));
        userService.add(userFactory.createUser("Gurbatov", "123", "Pavel Gurbatov", Role.DRIVER));
        userService.add(userFactory.createUser("Kireev", "123", "Pavel Kireev", Role.MANAGER));
        userService.add(userFactory.createUser("FYL", "123", "Pavel Fyl", Role.PLANNER));
        userService.add(userFactory.createUser("Azanov", "123", "Pavel Fyl", Role.INFORMER));
    }
}
