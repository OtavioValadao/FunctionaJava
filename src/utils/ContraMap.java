package utils;

import TypeClass.Eq.Eq;

import java.util.function.Function;

public class ContraMap {

    public static <K, V> Function<Eq<V>, Eq<K>> contraMapEq(Function<K, V> func){
        return (eq) -> (arg1, arg2) -> eq.isEquals(func.apply(arg1), func.apply(arg2));
    }


}
