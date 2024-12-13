package interview;

import java.math.BigInteger;

public class FibonnaciVariants {

    public static void main(String[] args) {
        final int n = 7;
        for (int i = 0; i < n; i++) {
            //System.out.println(fibRecursive(i));
            //System.out.println(fibRecursiveMemo(i, new int[n]));
            //System.out.println(fibIterative(i));
            //System.out.println(fibIterativePreventOverflowWithException(i));
            System.out.println(fibIterativePreventOverflowWithBigInt(i));
        }
    }

    private static int fibRecursive(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fibRecursive(n-2) + fibRecursive(n-1);
    }

    private static int fibRecursiveMemo(int n, int[] memo) {
        if (memo[n] != 0) {
            return memo[n];
        } else if (n == 0 || n == 1) {
            return n;
        }
        int result = fibRecursiveMemo(n-2, memo) + fibRecursiveMemo(n-1, memo);
        memo[n] = result;
        return result;
    }

    private static int fibIterative(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int a = 0, b = 1;
        for (int i = 2; i < n+1; i++) {
            int tempA = a;
            a = b;
            b = tempA + b;
        }
        return b;
    }

    private static int fibIterativePreventOverflowWithException(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int a = 0, b = 1;
        for (int i = 2; i < n+1; i++) {
            if (Integer.MAX_VALUE - b < a) {
                throw new ArithmeticException("Int overflow at fib(" + i + ")");
            }
            int tempA = a;
            a = b;
            b = tempA + b;
        }
        return b;
    }

    private static BigInteger fibIterativePreventOverflowWithBigInt(int n) {
        if (n == 0) {
            return BigInteger.ZERO;
        } else if (n == 1) {
            return BigInteger.ONE;
        }
        BigInteger a = BigInteger.ZERO, b = BigInteger.ONE;
        for (int i = 2; i < n+1; i++) {
            BigInteger tempA = a;
            a = b;
            b = tempA.add(b);
        }
        return b;
    }














}