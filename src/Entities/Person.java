package Entities;


import Entities.Enum.PersonJobEnum;

public class Person {

    public String name;

    public Integer age;

    public PersonJobEnum job;

    public Person( String name, Integer age, PersonJobEnum personJobEnum) {
        this.age = age;
        this.name = name;
        this.job = personJobEnum;
    }

    @Override
    public String toString() {
        return "Person " +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                ", age=" + age;
    }
}
