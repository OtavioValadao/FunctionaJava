package TypeClass.Ord.methods;

import TypeClass.Ord.Enum.Ordering;
import TypeClass.Ord.Ord;

import java.util.function.BiFunction;

public class OrdUtils {

    public static <T> Ord<T> fromCompareOrd(BiFunction<T, T, Ordering> func) {
        return new OrdMethods<>(func);
    }

    public static <T> Ord<T> contraMapOrd(BiFunction<T, T, Ordering> func) {
        return new OrdMethods<>(func);
    }

}
