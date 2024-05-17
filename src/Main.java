import Entities.Person;
import Mocks.Mock;
import TypeClass.Eq.Eq;
import TypeClass.Eq.EqInteger;
import TypeClass.Eq.EqString;
import utils.ContraMap;
import utils.Utils;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        testingEq();

    }


    public static void testingEq() {
        System.out.println("Inciando testes da Eq\n");

        EqInteger eqInteger = new EqInteger();
        EqString eqString = new EqString();

        Integer itemToVerifyInteger = 1;
        String itemToVerifyString = "pineapple";

        System.out.printf("Integer: the element %s is present in array ?\n" +
                        Utils.hasElementInArray(eqInteger, itemToVerifyInteger, List.of(1, 2, 3)),
                itemToVerifyInteger);

        System.out.println("\n*******************");

        System.out.printf("String: the element %s is present in array ?\n" +
                        Utils.hasElementInArray(
                                eqString,
                                itemToVerifyString,
                                List.of("apple", "orange", "banana")
                        ),
                itemToVerifyString);

        System.out.println("\n*******************");

        Person person1 = Mock.personMock();
        Person person2 = Mock.personMock();

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

    public static void testingOrd(){


    }
}

