public class Main {

    public static void main(String[] args) {
        char[] s = "hello".toCharArray();
        reverseString(s);
        System.out.println(s);
    }

    private static void reverseString(char[] s) {
        int l = 0, r = s.length-1;
        while (l < r) {
            char tempL = s[l];
            s[l] = s[r];
            s[r] = tempL;
            l++;
            r--;
        }
    }
}
