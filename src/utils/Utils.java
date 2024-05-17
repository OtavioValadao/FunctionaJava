package utils;

import TypeClass.Eq.Eq;

import java.util.List;

public class Utils {

    public static <T> Boolean hasElementInArray(Eq<T> eq, T itemToVerify, List<T> list){
        return list.stream().anyMatch(item -> eq.isEquals(item, itemToVerify));
    }

}
