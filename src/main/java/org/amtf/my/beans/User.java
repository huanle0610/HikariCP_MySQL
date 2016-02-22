package org.amtf.my.beans;

/**
 * Spring bean
 *
 */
public class User {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public void printHello() {
        System.out.println("Hello ! " + name);
    }
}