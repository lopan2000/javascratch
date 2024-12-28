package langfeatures;

import java.util.function.IntConsumer;
import java.util.stream.IntStream;

public class IntConsumerExample {

    public static void main(String[] args) {
        printSquareExample();
    }

    private static void printSquareExample() {
        IntConsumer printSquare = x -> System.out.println(x*x);
        printSquare.accept(3);
        System.out.println();

        IntStream.range(1, 10)
                .forEach(printSquare);
        System.out.println();

        //dynamic lambda def of IntConsumer in forEach()
        IntStream.range(1, 4)
                .forEach(x -> System.out.println(x*x));
        System.out.println();

        IntConsumer printSquareThenPrintSquare =
                printSquare.andThen(printSquare);
        printSquareThenPrintSquare.accept(4);
    }
}
