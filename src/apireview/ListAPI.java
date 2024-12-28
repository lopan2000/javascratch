package apireview;

import java.util.Arrays;
import java.util.List;

public class ListAPI {

    public static void main(String[] args) {
        //cannotPutNullInListOf();
        //canPutNullInArraysAsList();
        canPutNullInArrayLiteralInitialization();
    }

    private static void cannotPutNullInListOf() {
        Object o1 = new Object();
        Object o2 = null;
        try {
            for (Object o : List.of(o1, o2)) {  //throws NPE because of o2 being null
                System.out.println(o);
            }
        } catch (NullPointerException e) {
            System.out.println("Throws NPE");
        }
    }

    private static void canPutNullInArraysAsList() {
        Object o1 = new Object();
        Object o2 = null;
        for (Object o : Arrays.asList(o1, o2)) {  //OK
            System.out.println(o);
        }
    }

    private static void canPutNullInArrayLiteralInitialization() {
        Object o1 = new Object();
        Object o2 = null;
        for (Object o : new Object[]{o1, o2}) {  //OK
            System.out.println(o);
        }
    }
}
