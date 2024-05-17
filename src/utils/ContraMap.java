package utils;

import TypeClass.Eq.Eq;
import TypeClass.Ord.Enum.Ordering;
import TypeClass.Ord.Ord;
import TypeClass.Ord.methods.OrdMethods;

import java.util.function.BiFunction;
import java.util.function.Function;

public class ContraMap {

    public static <K, V> Function<Eq<V>, Eq<K>> contraMapEq(Function<K, V> func){
        return (eq) -> (arg1, arg2) -> eq.isEquals(func.apply(arg1), func.apply(arg2));
    }

    public static <T> Ord<T> contraMapOrd(BiFunction<T, T, Ordering> func){
        return new OrdMethods<>(func);
    }

}
