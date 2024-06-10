package TypeClass.Ord.methods;

import Entities.Enum.PersonJobEnum;
import TypeClass.Ord.Enum.Ordering;
import TypeClass.Ord.Ord;

import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class OrdUtils {

    public static <T> Ord<T> fromCompareOrd(BiFunction<T, T, Ordering> func) {
        return new OrdMethods<>(func);
    }

    public static <T> Ord<T> contraMapOrd(BiFunction<T, T, Ordering> func) {
        return new OrdMethods<>(func);
    }

    public static <T> T min(T a, T b, Ord<T> ord) {
        return ord.ordCompare(a, b) == Ordering.LT ? a : b;
    }

    public static <T> T max(T a, T b, Ord<T> ord) {
        return ord.ordCompare(a, b) == Ordering.GT ? a : b;
    }

    public static <T> Predicate<T> isOlder(Function<T, Integer> func) {
        return (old) -> func.apply(old) >= 60;
    }

    public static <T> Predicate<T> needHighEducation(Function<T, String> func) {
        return (job) -> {
            String jobEnum = func.apply(job);
            return !Objects.equals(jobEnum, PersonJobEnum.DRIVER.name()) && !Objects.equals(jobEnum, PersonJobEnum.ATHLETE.name());
        };
    }

}
