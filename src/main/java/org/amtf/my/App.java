package org.amtf.my;

import org.amtf.my.beans.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App {
    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("Spring-Module.xml");

        User user = (User) context.getBean("User");

        user.printHello();
    }
}
