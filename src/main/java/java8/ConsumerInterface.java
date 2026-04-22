package java8;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ConsumerInterface {

    Consumer<String> save = s -> System.out.println("Saved " + s);
    Consumer<String> notify = s -> System.out.println("Notified " + s);

    Consumer<String> combine = save.andThen(notify);


    Consumer<String> log = s -> System.out.println("Processing: " + s);
    Consumer<String> process = s -> System.out.println("Done: " + s);
    Consumer<String> pipeline = log.andThen(process);
    pipeline.accept("Order1");

    //predicate
    public void predicate() {

        //test
        Predicate<Integer> isEven = n -> n % 2 == 0;

        System.out.println(isEven.test(4)); // true
        System.out.println(isEven.test(5)); // false


        List<String> names = List.of("John", "Alex", "Sam");
        Predicate<String> startsWithA = name -> name.startsWith("A");
        names.stream().filter(startsWithA)
                .forEach(System.out::println);

        //and
        Predicate<Integer> greaterThan10 = n -> n > 10;
        Predicate<Integer> even = n -> n % 2 == 0;
        Predicate<Integer> result = greaterThan10.and(even);
        System.out.println(result.test(12)); // true
        System.out.println(result.test(9));  // false
        //or
        Predicate<Integer> result2 = greaterThan10.or(even);

        System.out.println(result2.test(9)); // false
        System.out.println(result2.test(8)); // true

        //negatate

        Predicate<Integer> notEven = even.negate();
        System.out.println(notEven.test(3)); // true

//        Practical use cases
//        Filtering data (very common with Streams)
//        Validation (e.g., input checks)
//        Business rules (eligibility, conditions)
//        Searching/matching logic

        List<Integer> nums = List.of(5, 12, 18, 7, 20);

        Predicate<Integer> greaterThan10s = n -> n > 10;
        Predicate<Integer> even2 = n -> n % 2 == 0;

        nums.stream()
                .filter(greaterThan10s.and(even2))
                .forEach(System.out::println);

        /*
        12 18 20
         */
    }
    }
