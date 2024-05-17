package utils;

import TypeClass.Ord.Enum.Ordering;
import TypeClass.Ord.Ord;
import TypeClass.Ord.OrdInteger;

import java.util.function.BiFunction;

public class FromCompare {

    public static <T> Ord<T> fromCompareOrd(BiFunction<T, T, Ordering> func){
        return new OrdClassMethods<>(func);
    }

}
