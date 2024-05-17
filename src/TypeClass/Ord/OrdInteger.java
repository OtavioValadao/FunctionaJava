package TypeClass.Ord;

import TypeClass.Ord.Enum.Ordering;

public class OrdInteger implements Ord<Integer>{
    @Override
    public Ordering ordCompare(Integer a, Integer b) {
        return a < b ? Ordering.LT : a > b ? Ordering.GT : Ordering.EQ;
    }

    @Override
    public Boolean isEquals(Integer x, Integer y) {
        return ordCompare(x, y) == Ordering.EQ;
    }
}
