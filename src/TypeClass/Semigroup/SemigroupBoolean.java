package TypeClass.Semigroup;

import java.util.function.BiFunction;
import java.util.function.Predicate;

public class SemigroupBoolean<T> implements Semigroup<Predicate<T>>{

    BiFunction<Predicate<T>, Predicate<T>, Predicate<T>> concatCompare;

    @Override
    public Predicate<T> concat(Predicate<T> x, Predicate<T> y) {
        return this.concatCompare.apply(x,y);
    }

    public SemigroupBoolean(BiFunction<Predicate<T>, Predicate<T>, Predicate<T>> compare) {
       this.concatCompare = compare;
    }
}
