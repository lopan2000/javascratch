package langfeatures;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class BiConsumerExample {

    public static void main(String[] args) {

        //nameAndAgePrinter();
        mapEntryPrinter();
    }

    private static void nameAndAgePrinter() {
        BiConsumer<String, Integer> nameAgePrinter = (name, age) ->
                System.out.println(name + " is " + age + " years old.");
        nameAgePrinter.accept("Fred", 55);
        nameAgePrinter.accept("Axl", 23);
    }

    private static void mapEntryPrinter() {
        Map<String, Integer> map = new HashMap<>();
        map.put("Fred", 55);
        map.put("Axl", 23);

        BiConsumer<String, Integer> entryPrinter = (key, value) ->
                System.out.println(key + ": " + value);

        map.forEach(entryPrinter);
    }
}
