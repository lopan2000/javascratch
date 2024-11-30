package interview.privateconstructor;

public class PrivateConstructor {

    private PrivateConstructor() {
        System.out.println("hi1");
    }

    private PrivateConstructor(Integer x) {
        System.out.println("hi2");
    }
}
