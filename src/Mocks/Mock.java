package Mocks;

import Entities.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Mock {

    public static Person personMock(){
        return new Person(getName(), new Random().nextInt(90) + 10);
    }


    private static String getName(){
        List<String> names = new ArrayList<>();
        names.add("Ana");
        names.add("Bruno");
        names.add("Carlos");
        names.add("Diana");
        names.add("Eduardo");
        names.add("Fernanda");

        return names.get(new Random().nextInt(names.size()));
    }
}
