package langfeatures.streams;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MiscStuff {
    public static void main(String[] args) throws Exception {
        /*
        Integer[] ints = {1,2,3,4,5};

        Stream.of(ints)
                .forEach(i -> System.out.println(i));

        Stream.of(ints)
                .map(i -> i+1)
                .forEach(i -> System.out.println(i));
        Stream.of(ints)
                .map(i -> i+1)
                .filter(i -> i % 2 == 0)
                .forEach(i -> System.out.println(i));
        Stream.of(ints)
                .filter(i -> i % 2 == 0)
                .map(i -> i+1)
                .forEach(i -> System.out.println(i));
        //equals 15
        int result = Stream.of(ints)
                .reduce(0, (a,b) -> a+b);
        System.out.println(result);

        //equals 115
        result = Stream.of(ints)
                .reduce(100, (a,b) -> a+b);
        System.out.println(result);

        //equals 5
        result = Stream.of(ints)
                .max(Comparator.comparing(i -> i))
                .get();
        System.out.println(result);

        //result: 2,3,4,5
        Stream.of(ints)
                .skip(1)
                .forEach(i -> System.out.println(i));

        //result: 2,3,4
        Stream.of(ints)
                .skip(1)
                .limit(3)
                .forEach(i -> System.out.println(i));

        Person homer = new Person("Homer");
        Person bart = new Person("Bart");
        Person lisa = new Person("Lisa");
        homer.children = new Person[]{bart, lisa};

        Person moe = new Person("Moe");
        moe.children = new Person[]{};


        //result: Bart, List, Bart, Lisa
        Stream.of(homer, homer)
                .flatMap(p -> Stream.of(p.children))
                .forEach(p -> System.out.println(p.name));

        List<Person> children = Stream.of(homer)
                .flatMap(p -> Stream.of(p.children))
                .collect(Collectors.toList());
        children.forEach(p -> System.out.println(p.name));


        //result = false
        boolean boolResult = Stream.of(homer)
                .allMatch(p -> p.children.length == 0);
        System.out.println(boolResult);

        //result = true
        boolean result2 = Stream.of(homer, moe)
                .anyMatch(p -> p.children.length == 0);
        System.out.println(result2);

        //result = false
        boolean result3 = Stream.of(homer, moe)
                .noneMatch(p -> p.children.length == 0);
        //System.out.println(result3);
        */
        /*
        //try w/o catch is "try-with-resources" which auto closes the resource even if error
        //v1
        Map<String, Set<String>> groups = new HashMap<>();
        try (Scanner s = new Scanner("staple petals")) {
            while (s.hasNext()) {
                String word = s.next();
                groups.computeIfAbsent(alphabetize(word),
                        (unused) -> new TreeSet<>()).add(word);
            }
        }
        //v2 using Streams
        try (Stream<String> words = new Scanner("staple petals").tokens()) {
            words.collect(groupingBy(word -> alphabetize(word)))
                    //...
        }
        */

        //what happens use try-with-resources on a non-resource?
        /*
        try (String s = alphabetize("abc")) {

        }
        java: incompatible types: try-with-resources not applicable to variable type
                (java.lang.String cannot be converted to java.lang.AutoCloseable)
        try (MyAutoclosableResource r = new MyAutoclosableResource()) {
            //this works
        }
        */
        /*
        "abc".chars().forEach(new IntConsumer() {
            @Override
            public void accept(int value) {
                System.out.println(value);
            }
        });
        "abc".chars().forEach(c -> System.out.println(c));
        "abc".chars().forEach(System.out::println);
         */
        /*
        List<String> words = Stream.of("This is good", "This is bad", "This is okay")
                .flatMap(sentence ->
                        Arrays.stream(sentence.split(" "))
                                .map(String::toUpperCase)
                )
                .toList();
        words.forEach(System.out::println);
        */
        /*
        //Make words of even length uppercase
        List<String> words = Stream.of("This is goody", "this is bad", "this is okay")
                .flatMap(sentence ->
                        Arrays.stream(sentence.split(" "))
                                .map(word -> {
                                    return word.length() % 2 == 0 ?
                                            word.toUpperCase() : word;
                                })
                )
                .toList();
        words.forEach(System.out::println);
         */
        //Break out each letter from each word
        /*
        List<String> words = Stream.of("This is goody", "this is bad", "this is okay")
                .flatMap(sentence ->
                        Arrays.stream(sentence.split(" "))
                                .flatMap(word ->
                                        Arrays.stream(word.split(""))
                                )
                )
                .toList();
        words.forEach(System.out::println);
         */
        //group sum price by name
        Stream<CustOrder> orders = Stream.of(
                new CustOrder("Jason", new BigDecimal("25.00")),
                new CustOrder("Fred", new BigDecimal("3.00")),
                new CustOrder("Jason", new BigDecimal("9.00")));

        Map<String, BigDecimal> groupSum = orders.collect(
                Collectors.groupingBy(
                    CustOrder::getName,
                    Collectors.mapping(
                            CustOrder::getPrice,
                            Collectors.reducing(BigDecimal.ZERO, BigDecimal::add)
                    )
                )
        );
        groupSum.forEach((name, price) -> {
            System.out.println(name + ": " + price);
        });

    }

    static class CustOrder {
        private String name;
        private BigDecimal price = BigDecimal.ZERO;
        public CustOrder(String name, BigDecimal price) {
            this.name = name;
            this.price = price;
        }
        public String getName() {
            return name;
        }
        public BigDecimal getPrice() {
            return price;
        }
    }

    static class MyAutoclosableResource implements AutoCloseable {
        @Override
        public void close() throws Exception {
            System.out.println("close()");
        }
    }

    private static String alphabetize(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }

    static class Person {
        String name;
        Person[] children;
        public Person(String name) {
            this.name = name;
        }
    }
}