package utils;

import Entities.Enum.PersonJobEnum;
import TypeClass.Eq.Eq;
import TypeClass.Ord.Enum.Ordering;
import TypeClass.Ord.Ord;
import TypeClass.Semigroup.Semigroup;
import TypeClass.Semigroup.SemigroupBoolean;

import java.util.List;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class Utils {

    public static <T> Boolean hasElementInArray(Eq<T> eq, T itemToVerify, List<T> list) {
        return list.stream().anyMatch(item -> eq.isEquals(item, itemToVerify));
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

    public static <T> SemigroupBoolean<T> combineBoth(
            BiFunction<Predicate<T>, Predicate<T>, Predicate<T>> compare) {
        return  new SemigroupBoolean<>(compare);
    }

}
