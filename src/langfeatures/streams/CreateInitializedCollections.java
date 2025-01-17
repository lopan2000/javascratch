package langfeatures.streams;

import java.util.Arrays;
import java.util.stream.Stream;

public class CreateInitializedCollections {

    public static void main(String[] args) {
        Arrays.stream(createStringBuilderArray(5))
                .forEach(s -> System.out.println(s.toString()));
    }

    private static StringBuilder[] createStringBuilderArray(int n) {
        StringBuilder[] arr = Stream.generate(StringBuilder::new)
                .limit(n)
                .toArray(StringBuilder[]::new);

        for (int i = 0; i < n; i++) {
            arr[i].append(i);
        }
        return arr;
    }
}
