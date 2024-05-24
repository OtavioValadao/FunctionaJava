package TypeClass.Semigroup;

public class SemigroupProduct implements Semigroup<Integer>{
    @Override
    public Integer concat(Integer x, Integer y) {
        return x * y;
    }
}
