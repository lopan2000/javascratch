package langfeatures;

import java.util.Objects;

public class ObjectsRequireNonNull {

    public static void main(String[] args) {

        Person p1 = new Person("Fred");
        System.out.println(p1.getName());

        try {
            Person p2 = new Person(null);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
}

class Person {
    private String name;
    public Person(String name) {
        this.name = Objects.requireNonNull(name);
    }
    public String getName() {
        return name;
    }
}