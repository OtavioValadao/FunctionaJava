package TypeClass.Ord;

import TypeClass.Eq.Eq;
import TypeClass.Ord.Enum.Ordering;

public interface Ord<T> extends Eq<T> {

    Ordering ordCompare(T a, T b);

}
