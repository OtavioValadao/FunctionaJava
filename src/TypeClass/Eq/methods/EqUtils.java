package TypeClass.Eq.methods;

import TypeClass.Eq.Eq;
import utils.Utils;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

public class EqUtils {

    public static <K, V> Function<Eq<V>, Eq<K>> contraMap(Function<K, V> func) {
        return (eq) -> (arg1, arg2) -> eq.isEquals(func.apply(arg1), func.apply(arg2));
    }

    public static <T> Predicate<T> hasElementInArray(Eq<T> eq, List<T> list) {
        return (pred) -> list.stream().anyMatch(item -> eq.isEquals(item, pred));
    }

    public static <T> Eq<T> getStructEq(Map<String, Eq<T>> eqs) {
        return (a, b) -> {
            for (String key : eqs.keySet()) {
                Eq<Object> eq = (Eq<Object>) eqs.get(key);

                Object eqAVal = Utils.getFieldValue(a, key);
                Object eqBVal = Utils.getFieldValue(b, key);

                if (!eq.isEquals(eqAVal, eqBVal)) {
                    return false;
                }
            }
            return true;
        };
    }


}
