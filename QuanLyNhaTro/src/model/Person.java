package model;

import java.io.Serializable;

public class Person implements Serializable {
    private String name;
    private int brithday;
    private  String id;

    public Person() {
    }

    public Person(String name, int brithday, String id) {
        this.name = name;
        this.brithday = brithday;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBrithday() {
        return brithday;
    }

    public void setBrithday(int brithday) {
        this.brithday = brithday;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", brithday='" + brithday + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
