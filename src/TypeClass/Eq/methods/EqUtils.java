package TypeClass.Eq.methods;

import TypeClass.Eq.Eq;

import java.util.function.Function;

public class EqUtils {

    public static <K, V> Function<Eq<V>, Eq<K>> contraMap(Function<K, V> func) {
        return (eq) -> (arg1, arg2) -> eq.isEquals(func.apply(arg1), func.apply(arg2));
    }


}
