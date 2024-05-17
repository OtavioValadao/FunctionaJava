package TypeClass.Ord.methods;

import TypeClass.Ord.Enum.Ordering;
import TypeClass.Ord.Ord;

import java.util.function.BiFunction;

public class OrdMethods<T> implements Ord<T> {

    BiFunction<T, T, Ordering> ord;

    BiFunction<T, T, Boolean> eq;


    @Override
    public Ordering ordCompare(T a, T b) {
        return this.ord.apply(a, b);
    }

    @Override
    public Boolean isEquals(T x, T y) {
        return ordCompare(x, y) == Ordering.EQ;
    }

    public OrdMethods(BiFunction<T, T, Ordering> compare) {
        this.ord = compare;
        this.eq = (a, b) -> this.ord.apply(a, b) == Ordering.EQ;
    }
}
