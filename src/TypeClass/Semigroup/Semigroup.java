package TypeClass.Semigroup;

public interface Semigroup<T> {

    T concat(T x, T y);
}
