package designpatterns.builder;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        Profile p1 = new Profile.Builder("Jason", 44, LocalDate.of(1887, 12, 3))
                .favoriteColor("red")
                .build();
        System.out.println(p1);

        Profile p2 = new Profile.Builder("Fred", 88, LocalDate.of(1990, 11, 26))
                .favoriteColor("blue")
                .favoriteFood("pizza")
                .build();
        System.out.println(p2);

        Order o1 = new Order.Builder("001234", 1)
                .note("leave on porch")
                .build();
        System.out.println(o1);
    }
}