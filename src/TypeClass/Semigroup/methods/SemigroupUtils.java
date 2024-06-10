package TypeClass.Semigroup.methods;

import TypeClass.Semigroup.Semigroup;
import TypeClass.Semigroup.SemigroupBoolean;
import utils.Utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class SemigroupUtils {

    public static <T> SemigroupBoolean<T> combineBoth(
            BiFunction<Predicate<T>, Predicate<T>, Predicate<T>> compare) {
        return new SemigroupBoolean<>(compare);
    }

    public static <T> T fold(Semigroup<T> semigroup, T item, List<T> list) {
        return list.stream().reduce(item, semigroup::concat);
    }

    public static <T> Semigroup<T> getStructSemigroup(Class<T> clazz, Map<String, Semigroup<?>> semigroups) {
        return (a, b) -> {
            HashMap<String, Object> result = new HashMap<>();
            for (String key : semigroups.keySet()) {
                Semigroup<Object> semigroup = (Semigroup<Object>) semigroups.get(key);

                Object aVal = Utils.getFieldValue(a, key);
                Object bVal = Utils.getFieldValue(b, key);

                Object combineVal = semigroup.concat(aVal, bVal);
                result.put(key, combineVal);
            }
            return (T) Utils.createNewInstance(clazz, result);
        };
    }
}
