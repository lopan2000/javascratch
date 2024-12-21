package langfeatures;

public class Mod {

    public static void main(String[] args) {
        testModRenormalizationTechnique();
    }

    private static void testModRenormalizationTechnique() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + ": " +
                    i % 3 + ", " +
                    negate(i) % 3 + ", " +                      //really a 'remainder operator'
                    renormalizedModulo(negate(i), 3) + ", " +  //true mathematical modulo operator
                    mathematicalModulo(negate(i), 3));
        }
    }

    private static int negate(int x) {
        return x * -1;
    }

    //should be equivalent to mathematicalModulo
    private static int renormalizedModulo(int x, int k) {
        return ((x % k) + k) % k;
    }

    private static int mathematicalModulo(int a, int b) {
        //return (a - b) * Math.floorDiv(a, b);
        return Math.floorMod(a, b);
    }
}
