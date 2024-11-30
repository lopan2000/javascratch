package langfeatures;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;
import static java.math.BigInteger.*;
import static java.util.stream.Collectors.toList;

public class Lambdas {
    public static void main(String[] args) throws InterruptedException {
        List<String> messages = new ArrayList<String>();
        messages.add(" hello ");
        messages.add("Goodbye");
        messages.add("i like your lettuce");
        /*
        messages.stream()
                .forEach(s -> System.out.println(s));

        messages.stream()
                .forEach(System.out::println);

        messages.stream()
                .map(langfeatures.Lambdas::formatMessage)
                .forEach(System.out::println);

        messages.stream()
                .map(i -> {
                    return i.trim();
                })
                .forEach(System.out::println);

        */
        /*
        //<input, output>
        Function<String, String> myMapping = i -> {
            return i.trim();
        };
        messages.stream()
                .map(myMapping)
                .forEach(System.out::println);

        //<input, output>
        Function<String, Integer> stringToLengthMap = s -> {
            return s.length();
        };
        messages.stream()
                .map(stringToLengthMap)
                .forEach(System.out::println);

        //<output> only
        //full version
        //Supplier<String> supplier = () -> {
        //    return ", brought to you by Broncen Tuo";
        //};
        //streamlined version
        Supplier<String> supplier = () -> ", brought to you by Broncen Tuo";
        Function<String, String> mapping = s -> {
            return s += supplier.get();
        };
        messages.stream()
                .map(mapping)
                .forEach(System.out::println);

        //<input> only
        Consumer<String> consumer = s -> {
            System.out.println(s);
        };
        messages.stream()
                .forEach(consumer);

        for (String msg : messages) {
            handleMessage(msg, consumer);
        }

        //old way
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("hi");
            }
        };
        Thread t = new Thread(r);
        t.start();
        Thread.sleep(100);

        //new way with langfeatures.Lambdas (since Runnable is a func interface (meaning has only one method))
        Runnable r = () -> {
            System.out.println("hi");
        };

        //simplify some more
        Runnable r = () -> System.out.println("hi");
        Thread t = new Thread(r);
        t.start();
        Thread.sleep(100);
        */
        /*s
        MyPrinter printer = () -> System.out.println("Hi");
        printer.printMessage();
        */
        /*
        int x = 10;
        messages.stream()
                .filter(s -> s.length() < x)
                .map(s -> s.toUpperCase())
                .forEach(s -> System.out.println(s + "_" + x));
        */
        /*
        //inf stream
        primes().map(p -> TWO.pow(p.intValueExact()).subtract(ONE))
                .filter(mersenne -> mersenne.isProbablePrime(50))
                .limit(10)
                //.forEach(System.out::println);
                .forEach(mp -> System.out.println(mp.bitLength() + ": " + mp));
        */


    }

    private static List<Card> newDeck() {
        List<Card> cards = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new Card(suit, rank));
            }
        }
        return cards;
    }

    private static List<Card> newDeckV2() {
        return Stream.of(Suit.values())
                .flatMap(suit ->
                        Stream.of(Rank.values())
                            .map(rank -> new Card(suit, rank)))
                .collect(toList());
    }

    private enum Rank {
        ACE(1), TWO(2), THREE(3), FOUR(4), FIVE(5),
        SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10),
        JACK(11), QUEEN(12), KING(13);
        private final int value;
        Rank(int value) { this.value = value;}
        public int getValue() { return value; }
    }
    private enum Suit {
        SPADES, CLUBS, HEARTS, DIAMONDS
    }

    private static class Card {
        Suit suit;
        Rank rank;
        public Card(Suit suit, Rank rank) {
            this.suit = suit;
            this.rank = rank;
        }
    }

    private static Stream<BigInteger> primes() {
        //static factory
        return Stream.iterate(TWO, BigInteger::nextProbablePrime);
    }

    @FunctionalInterface
    interface MyPrinter {
        void printMessage();
    }

    private static void handleMessage(String msg, Consumer<String> consumer) {
        //explicitly pass input to Consumer
        consumer.accept(msg);
    }

    private static String formatMessage(String s) {
        return s.trim();
    }
}