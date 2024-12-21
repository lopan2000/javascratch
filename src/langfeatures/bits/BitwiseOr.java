package langfeatures.bits;

/**
 * TODO write code to compare behavior of |= vs ||=
 */
public class BitwiseOr {

    public static void main(String[] args) {

        boolean flag = false;
        for (int i = 0; i < 10; i++) {
            /*
            True at least once, does not short-circuit
             */
            flag |= i == 7;
        }

        System.out.println(flag);
    }
}
