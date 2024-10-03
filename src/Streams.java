import java.util.stream.Stream;

public class Streams {
    public static void main(String[] args) {
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
        int result = Stream.of(ints)
                .reduce(100, (a,b) -> a+b);
        System.out.println(result);

        //equals 5
        int result = Stream.of(ints)
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

        */

        Person homer = new Person("Homer");
        Person bart = new Person("Bart");
        Person lisa = new Person("Lisa");
        homer.children = new Person[]{bart, lisa};

        Person moe = new Person("Moe");
        moe.children = new Person[]{};

        /*
        //result: Bart, List, Bart, Lisa
        Stream.of(homer, homer)
                .flatMap(p -> Stream.of(p.children))
                .forEach(p -> System.out.println(p.name));

        List<Person> children = Stream.of(homer)
                .flatMap(p -> Stream.of(p.children))
                .collect(Collectors.toList());
        children.forEach(p -> System.out.println(p.name));
        */

        //result = false
        boolean result = Stream.of(homer)
                .allMatch(p -> p.children.length == 0);
        System.out.println(result);

        //result = true
        boolean result2 = Stream.of(homer, moe)
                .anyMatch(p -> p.children.length == 0);
        System.out.println(result2);

        //result = false
        boolean result3 = Stream.of(homer, moe)
                .noneMatch(p -> p.children.length == 0);
        System.out.println(result3);
    }

    static class Person {
        String name;
        Person[] children;
        public Person(String name) {
            this.name = name;
        }
    }
}