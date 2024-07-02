import java.util.ArrayList;
import java.util.Collection;

public class Collection_1 {

    public static void main(String[] args) {
        /*
        Collection<String> strings = new ArrayList<>();
        strings.add("one");
        strings.add("two");
        System.out.println("strings = " + strings);
        strings.remove("one");
        System.out.println("strings = " + strings);

        if (!strings.contains("three")) {
            System.out.println("three is not here");
        }
         */

        Collection<String> strings = new ArrayList<>();
        strings.add("one");
        strings.add("two");
        strings.add("three");

        Collection<String> first = new ArrayList<>();
        strings.add("one");
        strings.add("two");

        Collection<String> second = new ArrayList<>();
        strings.add("one");
        strings.add("four");

        System.out.println("Is first contained in strings? " + strings.containsAll(first));
        System.out.println("Is second contained in strings? " + strings.containsAll(second));

    }
}
