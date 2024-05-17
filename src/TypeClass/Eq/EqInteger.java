package TypeClass.Eq;

public class EqInteger implements Eq<Integer> {

    @Override
    public Boolean isEquals(Integer x, Integer y) {
        return x.equals(y);
    }
}
