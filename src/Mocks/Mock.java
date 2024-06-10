package Mocks;

import Entities.Enum.PersonJobEnum;
import Entities.Person;

import java.util.*;

public class Mock {

    public static Person personMock(){
        return new Person(getName(), new Random().nextInt(90) + 10, getJob(), getHobbies());
    }

    private static List<String> getHobbies() {
        Map<Integer, List<String>> dictionary = new HashMap<>();
        Map<Integer, String> hobbies = new HashMap<>();
        List<String> stringList = new ArrayList<>();

        stringList.add("watch movies");
        stringList.add("play video games");
        stringList.add("make foods");
        stringList.add("read books");
        stringList.add("draw on the board");
        stringList.add("take photographs");
        stringList.add("learn new languages");
        stringList.add("solve puzzles");
        stringList.add("go hiking");
        stringList.add("play soccer");
        stringList.add("walk in the park");
        stringList.add("go fishing");

        for (int i = 0; i < 2; i++) {
            hobbies.put(i, stringList.get(new Random().nextInt(stringList.size())));
        }

        for (int i = 0; i < stringList.size(); i++) {
            dictionary.put(i, hobbies.values().stream().toList());
        }

        return dictionary.get(new Random().nextInt(dictionary.size()));
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

    private static PersonJobEnum getJob(){
        PersonJobEnum[] values = PersonJobEnum.values();
        return values[new Random().nextInt(values.length)];
    }
}
