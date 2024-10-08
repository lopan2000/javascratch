package interview;

import java.util.*;

public class InterviewQuestions {

    public static void main(String[] args) {
        /*
        char[] s = "hello".toCharArray();
        reverseString(s);
        System.out.println(s);
        */
        /*
        int[] arr = generateOddReverseArray();
        Arrays.stream(arr).forEach(System.out::println);
        */
        //System.out.println(sortAscAndRemoveDupes("213414415"));
        //System.out.println(removeDuplicates("1112233"));
        /*
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        printLinkedList(head);
        printLinkedList(reverseLinkedList(head));
        */
        /*
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(3);
        printLinkedList(removeDupesFromLinkedList(head));
        */
        /*
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        System.out.println(getMiddleNodeFirstMiddleVersion(head).val);
        System.out.println(getMiddleNodeSecondMiddleVersion(head).val);
        */
        /*
        int[] runningSum = getRunningSum(new int[]{1,2,3,4,5});
        Arrays.stream(runningSum)
                .forEach(System.out::println);
        */
        //System.out.println(reverseWordsInString("once upon a time there was a fish"));
        for (int i = 0; i < 7; i++) {
            System.out.println(fibonacciOpt(i));
        }
    }

    private static void reverseString(char[] s) {
        int l = 0, r = s.length-1;
        while (l < r) {
            if (s[l] != s[r]) {
                char tempL = s[l];
                s[l] = s[r];
                s[r] = tempL;
                l++;
                r--;
            }
        }
    }

    private static int[] generateOddReverseArray() {
        int n = 100;
        int[] result = new int[n/2];
        for (int i = 0, j = n-1; i < result.length; i++, j-=2) {
            result[i] = j;
        }
        return result;
    }

    private static String sortAscAndRemoveDupes(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        int slow = 0;
        for (int fast = 0; fast < arr.length; fast++) {
            if (arr[fast] != arr[slow]) {
                slow++;
                arr[slow] = arr[fast];
            }
        }
        return String.valueOf(arr).substring(0, slow+1);
    }

    public static String removeDuplicates(String s) {
        char[] arr = s.toCharArray();
        int slow = 0;
        for (int fast = 0; fast < arr.length; fast++) {
            if (arr[slow] != arr[fast]) {
                slow++;
                arr[slow] = arr[fast];
            }
        }
        return String.valueOf(arr).substring(0, slow+1);
    }

    /* (TODO)
    Air traffic control needs to lands planes coming into an airport. Return a list of the order the planes should land according to 1) their priority[high, medium, low], 2) their size[large, medium, small] and 3) by their time of arrival
     */

    public static Node reverseLinkedList(Node head) {
        Node curr = head, prev = null;
        while (curr != null) {
            Node iterNext = curr.next;
            curr.next = prev;
            prev = curr;
            curr = iterNext;
        }
        return prev;
    }

    public static Node removeDupesFromLinkedList(Node head) {
        Node curr = head;
        while (curr.next != null && curr.next.next != null) {
            if (curr.val == curr.next.val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }

    public static Node getMiddleNodeFirstMiddleVersion(Node head) {
        Node slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static Node getMiddleNodeSecondMiddleVersion(Node head) {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void printLinkedList(Node head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println();
    }

    public static int[] getRunningSum(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i-1] + nums[i];
        }
        return result;
    }

    public static String reverseWordsInString(String s) {
        String[] arr = s.split(" ");
        int l = 0, r = arr.length-1;
        while (l < r) {
            String tempL = arr[l];
            arr[l] = arr[r];
            arr[r] = tempL;
            l++;
            r--;
        }
        return String.join(" ", arr);
    }

    public static int fibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        } else {
            return fibonacci(n-2) + fibonacci(n-1);
        }
    }

    public static int fibonacciOpt(int n) {
        return fib(n, new int[n+1]);    //(TODO) why needs n+1?
    }

    private static int fib(int n, int[] memo) {
        if (memo[n] != 0) {
            return memo[n];
        }
        if (n == 0 || n == 1) {
            return n;
        }
        int result = fib(n-2, memo) + fib(n-1, memo);
        memo[n] = result;
        return result;
    }
}

class Node {
    public int val;
    public Node next;
    public Node(int val) {
        this.val = val;
    }
}