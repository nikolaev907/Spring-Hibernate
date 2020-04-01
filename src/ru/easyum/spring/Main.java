package ru.easyum.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("config/xml/spring-config.xml");
        HelloWorld helloWorld = context.getBean("helloWorld", HelloWorld.class);
        System.out.println(helloWorld);

        FactorySelfCreatedBean factorySelfCreatedBean = (FactorySelfCreatedBean) context.getBean("FactorySelfCreatedBean");
        System.out.println(factorySelfCreatedBean);

        helloWorld = context.getBean("helloWorldFromFactory", HelloWorld.class);
        System.out.println(helloWorld);
    }
}
