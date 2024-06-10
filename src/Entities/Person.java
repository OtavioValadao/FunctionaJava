package Entities;


import Entities.Enum.PersonJobEnum;

import java.util.List;

public class Person {

    public String name;

    public Integer age;

    public PersonJobEnum job;

    public List<String> hobbies;

    public Person(String name, Integer age, PersonJobEnum personJobEnum, List<String> hobbies) {
        this.age = age;
        this.name = name;
        this.job = personJobEnum;
        this.hobbies = hobbies;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "Person " +
                "name = '" + name + '\'' +
                ", job = '" + job + '\'' +
                ", age = " + age +
                ", hobbies =" + hobbies;
    }
}
