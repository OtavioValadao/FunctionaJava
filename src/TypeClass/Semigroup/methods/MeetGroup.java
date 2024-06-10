package TypeClass.Semigroup.methods;

import TypeClass.Ord.Ord;
import TypeClass.Ord.methods.OrdUtils;
import TypeClass.Semigroup.Semigroup;

public class MeetGroup {


    public static <T> Semigroup<T> getMeetSemigroup(Ord<T> ord) {
        return (a, b) -> OrdUtils.min(a, b, ord);
    }

    public static <T> Semigroup<T> getJoinSemigroup(Ord<T> ord) {
        return (a, b) -> OrdUtils.max(a, b, ord);
    }
}
