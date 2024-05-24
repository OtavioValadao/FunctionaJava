package TypeClass.Semigroup;

public class SemigroupString implements Semigroup<String>{
    @Override
    public String concat(String x, String y) {
        return x + " " + y;
    }
}
