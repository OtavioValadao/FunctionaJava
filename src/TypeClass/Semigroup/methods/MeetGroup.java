package TypeClass.Semigroup.methods;

import TypeClass.Ord.Ord;
import TypeClass.Semigroup.Semigroup;
import utils.Utils;

public class MeetGroup {


    public static <T> Semigroup<T> getMeetSemigroup(Ord<T> ord) {
        return (a, b) -> Utils.min(a, b, ord);
    }

    public static <T> Semigroup<T> getJoinSemigroup(Ord<T> ord) {
        return (a, b) -> Utils.max(a, b, ord);
    }
}
