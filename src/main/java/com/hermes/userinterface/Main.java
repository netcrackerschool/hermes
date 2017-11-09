package com.hermes.userinterface;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *  05.10.15.
 */
public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        Controller controller = context.getBean(Controller.class);
        controller.launch();
    }
}
