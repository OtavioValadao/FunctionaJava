import Entities.Person;
import Mocks.Mock;
import TypeClass.Eq.Eq;
import TypeClass.Eq.EqInteger;
import TypeClass.Eq.EqString;
import TypeClass.Ord.Ord;
import TypeClass.Ord.OrdInteger;
import utils.ContraMap;
import utils.FromCompare;
import utils.Utils;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        testingEq(false);

        testingOrd(true);

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

            Boolean hasElementInArrayString  = Utils.hasElementInArray(
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

        if (isToPlay){
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

            Ord<Person> personOrd = FromCompare
                    .fromCompareOrd(
                            (Person p1, Person p2) -> ordInteger.ordCompare(p1.age, p2.age)
                    );

            System.out.println("***************");
            System.out.println(
                    "Person1 is LT or GT of Person2? " +
                    personOrd.ordCompare(person1, person2) + "\n"
            );



        }
    }
}

