package utils;

import TypeClass.Eq.Eq;
import TypeClass.Ord.Enum.Ordering;
import TypeClass.Ord.Ord;

import java.util.List;
import java.util.function.BiFunction;

public class Utils {

    public static <T> Boolean hasElementInArray(Eq<T> eq, T itemToVerify, List<T> list) {
        return list.stream().anyMatch(item -> eq.isEquals(item, itemToVerify));
    }

    public static <T> T min(T a, T b, Ord<T> ord) {
        return ord.ordCompare(a, b) == Ordering.LT ? a : b;
    }

    public static <T> T max(T a, T b, Ord<T> ord){
        return ord.ordCompare(a, b) == Ordering.GT ? a : b;
    }

}
