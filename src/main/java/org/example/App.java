package org.example;

import org.example.configuration.RootConfiguration;
import org.example.console.ConsoleApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//xml
//java base
//annotation base

//constructor
//setter
//field
public class App {
    public static void main( String[] args ) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(RootConfiguration.class);
        ConsoleApplication consoleApplication = applicationContext.getBean("consoleApplication", ConsoleApplication.class);
        consoleApplication.run();
    }
}
