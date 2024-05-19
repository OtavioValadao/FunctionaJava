import Entities.Person;
import Mocks.Mock;
import TypeClass.Eq.Eq;
import TypeClass.Eq.EqInteger;
import TypeClass.Eq.EqString;
import TypeClass.Ord.Ord;
import TypeClass.Ord.OrdInteger;
import TypeClass.Semigroup.Semigroup;
import TypeClass.Semigroup.SemigroupBoolean;
import TypeClass.Semigroup.methods.MeetGroup;
import utils.ContraMap;
import utils.FromCompare;
import utils.Utils;

import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

        testingEq(false);

        testingOrd(false);

        testingSemigroup(true);


    }


    public static void testingEq(Boolean isToPLay) {

        if (isToPLay) {
            System.out.println("Starting testing of Eq\n");

            EqInteger eqInteger = new EqInteger();
            EqString eqString = new EqString();

            Integer itemToVerifyInteger = 1;
            String itemToVerifyString = "pineapple";

            Boolean hasElementInArrayInteger = Utils.hasElementInArray(eqInteger, itemToVerifyInteger, List.of(1, 2, 3));

            System.out.printf("Integer: the element %s is present in array ?\n" +
                            hasElementInArrayInteger,
                    itemToVerifyInteger);

            System.out.println("\n*******************");

            Boolean hasElementInArrayString = Utils.hasElementInArray(
                    eqString,
                    itemToVerifyString,
                    List.of("apple", "orange", "banana")
            );
            System.out.printf("String: the element %s is present in array ?\n" +
                            hasElementInArrayString,
                    itemToVerifyString);

            System.out.println("\n*******************");

            Person person1 = Mock.personMock();
            Person person2 = Mock.personMock();

            System.out.println(person1);
            System.out.println(person2);

            Eq<Person> personEqInt = ContraMap.contraMapEq((Person prs) -> prs.age).apply(eqInteger);
            Eq<Person> personEqStr = ContraMap.contraMapEq((Person prs) -> prs.name).apply(eqString);

            System.out.printf("The person have the same age?\n"
                    + personEqInt.isEquals(person1, person2) +
                    "\nAge that was comparing %s and %s\n", person1.age, person2.age
            );

            System.out.printf("The person have the same name?\n"
                    + personEqStr.isEquals(person1, person2) +
                    "\nNames that was comparing %s and %s\n", person1.name, person2.name
            );
        }

    }

    public static void testingOrd(Boolean isToPlay) {

        if (isToPlay) {
            System.out.println("Starting testing of Ord\n");

            OrdInteger ordInteger = new OrdInteger();
            Person person1 = Mock.personMock();
            Person person2 = Mock.personMock();

            System.out.println(person1);
            System.out.println(person2);

            Integer min = Utils.min(person1.age, person2.age, ordInteger);

            System.out.printf(
                    "\nWhich is the less age? %s ou %s\n" +
                            min + "\n",
                    person1.age, person2.age
            );

            Ord<Person> fromCompareOrd = FromCompare
                    .fromCompareOrd(
                            (Person p1, Person p2) -> ordInteger.ordCompare(p1.age, p2.age)
                    );

            System.out.println("***************");
            System.out.println(
                    "Person1 is LT or GT of Person2? " +
                            fromCompareOrd.ordCompare(person1, person2) + "\n"
            );

            System.out.println("***************");

            Ord<Person> contraedMapOrd = ContraMap.contraMapOrd(
                    (Person p1, Person p2) -> ordInteger.ordCompare(p1.age, p2.age)
            );

            System.out.println(
                    "With person is LT by ContraMap\n" +
                            Utils.min(person1, person2, contraedMapOrd)
            );
            System.out.println("--------------------");

            System.out.println(
                    "With person is GT by ContraMap\n" +
                            Utils.max(person1, person2, contraedMapOrd)
            );
        }
    }

    public static void testingSemigroup(Boolean isToPlay) {
        if (isToPlay) {
            System.out.println("================================");
            System.out.println("Starting testing of Semigroup");
            System.out.println("================================");
            System.out.println("Print persons");
            Person person1 = Mock.personMock();
            Person person2 = Mock.personMock();

            System.out.println(person1);
            System.out.println(person2);
            System.out.println("================================");

            OrdInteger ordInteger = new OrdInteger();

            Semigroup<Integer> meetSemigroup = MeetGroup.getMeetSemigroup(ordInteger);
            Semigroup<Integer> joinSemigroup = MeetGroup.getJoinSemigroup(ordInteger);

            System.out.println("Implement MIN by concat result: " + meetSemigroup.concat(person1.age, person2.age));
            System.out.println("Implement MAX by concat result: " + joinSemigroup.concat(person1.age, person2.age));
            System.out.println("********************************");

            Predicate<Person> isOlder = Utils.isOlder((Person p) -> p.age);
            Predicate<Person> needHighEducation = Utils.needHighEducation((Person p) -> p.job.name());

            System.out.printf("The %s is older? " + isOlder.test(person1) + "\n", person1.name);
            System.out.printf("The %s is older? " + isOlder.test(person2) + "\n", person2.name);

            System.out.printf("The %s need high education? " + needHighEducation.test(person1) + "\n", person1.name);
            System.out.printf("The %s need high education? " + needHighEducation.test(person2) + "\n", person2.name);
            System.out.println("**********************************");

            SemigroupBoolean<Person> personSemigroupBoolean =
                    Utils.combineBoth(Predicate::and);

            Predicate<Person> concat = personSemigroupBoolean.concat(isOlder, needHighEducation);

            System.out.printf("%s will be rewarded? " + concat.test(person1), person1.name);
            System.out.println(" ");
            System.out.printf("%s will be rewarded? " + concat.test(person2), person2.name);
            System.out.println(" ");
            System.out.println("**********************************");



        }
    }

}

