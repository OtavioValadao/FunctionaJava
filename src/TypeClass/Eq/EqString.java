package TypeClass.Eq;

public class EqString implements Eq<String> {
    @Override
    public Boolean isEquals(String x, String y) {
        return x.equals(y);
    }
}
