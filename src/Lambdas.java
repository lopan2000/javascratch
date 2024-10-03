import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

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
                .map(Lambdas::formatMessage)
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

        //new way with Lambdas (since Runnable is a func interface (meaning has only one method))
        Runnable r = () -> {
            System.out.println("hi");
        };

        //simplify some more
        Runnable r = () -> System.out.println("hi");
        Thread t = new Thread(r);
        t.start();
        Thread.sleep(100);
        */

        MyPrinter printer = () -> System.out.println("Hi");
        printer.printMessage();

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