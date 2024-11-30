package interview;

import java.awt.*;
import java.util.*;
import java.util.List;

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
        /*
        for (int i = 0; i < 7; i++) {
            System.out.println(fibonacciOpt(i));
        }
        */
        /*
        printArray(flattenMatrix(new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9},
        }));
        */
        /*
        System.out.println(isWordInMatrix("aloe", new char[][]{
                {'a','b','e'},
                {'l','d','o'},
                {'o','e','l'},
                {'e','d','a'}
        }));
         */
        /*
        int[] arr = {1,2,3,4,5};
        reverseArray(arr, 0, arr.length-1);
        printArray(arr);
         */
        //System.out.print(Math.floorDiv(3,2));
        /*
        String s = "  abc               ";
        String[] arr = s.trim().split("\\s+");
        Arrays.stream(arr)
                .map(x -> "'" + x + "'")
                .forEach(System.out::println);

         */
        /*
        List<String> input = Arrays.asList("aba", "a", "abc");
        input.stream()
                .forEach(s -> System.out.println(isPalindrome(s)));
        */
        /*
        //remove() throws exception if list created with Arrays.asList();
        //List<Integer> list = Arrays.asList(1,2,3);
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(1);
        list.forEach(System.out::println);
         */
        /*
        System.out.println(signedBitShiftDivBy2(-10));
        System.out.println(unsignedBitShiftDivBy2(-10));
        */
        /*
        System.out.println(9/5);
         */
        /*
        Map<String, Integer> map = new HashMap<>();
        map.merge("a", 1, Integer::sum);
        System.out.println(map.get("a"));
        map.merge("a", 1, Integer::sum);
        System.out.println(map.get("a"));
        map.merge("a", 2, Integer::sum);
        System.out.println(map.get("a"));
        map.merge("a", 100, (existingVal, newVal) -> {
            return existingVal * newVal;
        });
        System.out.println(map.get("a"));
         */
        /*
        int[] nums = new int[]{3,1,2};
        Arrays.sort(nums);
        Arrays.stream(nums)
                .forEach(System.out::println);
        */

        //System.out.println(gcd(1,3));
        //System.out.println((1,4));
        /*
        String s = "";
        int[] arr = new int[]{3,2,1};
        for (int i = 0; i < arr.length; i++) {
            s = arr[i] + s;
        }
        System.out.println(s);
        */
        /*
        int c = 7/10;
        System.out.println(c);
        System.out.println(7 % 10);
         */
        //System.out.println(backwardSumFromBackwardNumbers(111, 111));
        //String s = "1234";
        //int x = Integer.parseInt(s);
        /*
        Map<Integer, Integer> map = new HashMap<>();
        map.merge(1, 1, Integer::sum);
        System.out.println(map.get(1));
        int mergeResult = map.merge(1, -1, Integer::sum);
        System.out.println(mergeResult);
         */
        /*
        String s = "dog cat fish";
        String[] arr = s.split(" ");
        Arrays.stream(arr)
                .forEach(System.out::println);
         */
        /*
        Map<String, String> map = new HashMap<>();
        map.put("a", "a_val");
        System.out.println(map.getOrDefault("a", "not found"));
        System.out.println(map.getOrDefault("b", "not found"));
        */

        //int[] arr = commonNumbers(new int[]{1,2,3}, new int[]{2,3,4});
        //Arrays.stream(arr).forEach(System.out::println);

        //new Thread(new MyThread()).start();
        /*
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("way 3");
            }
        }).start();
         */
        //new Thread(() -> System.out.println("way 4")).start();
        /*
        int[] result = twoSumSorted(new int[]{1,2,3,4,5,6}, 10);
        System.out.println(result[0] + "," + result[1]);

        int[] result2 = twoSumUnsorted(new int[]{2,1,6,5,4,3}, 10);
        System.out.println(result2[0] + "," + result2[1]);
         */
        //System.out.println(revString("123456789"));
        /*
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.add(2);
        maxHeap.add(3);
        maxHeap.add(1);
        //maxHeap.forEach(System.out::println);
        while (!maxHeap.isEmpty()) {
            System.out.println(maxHeap.poll());
        }
        */
        /*
        PriorityQueue<HeapNode<String>> maxHeap =
                new PriorityQueue<>((x,y) -> Integer.compare(y.freq, x.freq));
        HeapNode<String> node1 = new HeapNode<>(1, 100, "a");
        HeapNode<String> node2 = new HeapNode<>(2, 200, "b");
        HeapNode<String> node3 = new HeapNode<>(3, 300, "c");
        maxHeap.add(node2);
        maxHeap.add(node1);
        maxHeap.add(node3);
        maxHeap.remove(node1);
        node1.freq = 1000;
        maxHeap.add(node1);
        while (!maxHeap.isEmpty()) {
            System.out.println(maxHeap.poll());
        }
        */
        /*
        int x = 0;
        System.out.println(++x);
        System.out.println(x);
        int y = 0;
        System.out.println(y++);
        System.out.println(y);
         */
        /*
        int z = 0;
        int w = z++;
        System.out.println(w);
        System.out.println(z);
        */
        //System.out.println(sumOfSquaresOfDigits(294));
        //Arrays.stream(intToDigits(2335643)).forEach(System.out::println);
        //List<List<Integer>> list = new ArrayList<>();
        /*
        String a = "a", b = null;
        for (String s : List.of(a, b)) {
            System.out.println(s);
        }
        */
        /*
        List<String> list = new ArrayList<>(Collections.nCopies(3, ""));
        list.forEach(s -> s += "z"); //doesn't save new str to s, so not to list
        list.forEach(System.out::println);
         */
        //List<StringBuilder> list = new ArrayList<>(Collections.nCopies(3, new StringBuilder()));
        //List<StringBuilder> list = new ArrayList<>(3);
        //list.get(0);
        //list.forEach(sb -> sb.append("x"));
        //list.forEach(sb -> System.out.println(sb.toString()));
        //int x = 1;
        //System.out.println(x == 1 ? true : false);
        int x = 1;
        x = (x == 1) ? --x : ++x;
        System.out.println(x);

    }

    private static int sumOfSquaresOfDigits(int x) {
        int sum = 0;
        while (x > 0) {
            int digit = x % 10;     //get right-most digit
            sum += digit * digit;
            x /= 10;                //shift left
        }
        return sum;
    }

    private static Integer[] intToDigits(int x) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        while (x > 0) {
            queue.addFirst(x % 10);
            x /= 10;
        }
        return queue.toArray(new Integer[0]);
    }

    private static class MyThread implements Runnable {
        @Override
        public void run() {
            System.out.println("hello");
        }
    }

    /*
    private static int[] commonNumbers(int[] a, int[] b) {
        if (a.length > b.length) {
            commonNumbers(b, a);
        }
        Set<Integer> setB = new HashSet<>();
        for (int x : b) {
            setB.add(x);
        }
        Set<Integer> result = new HashSet<>();
        for (int x : a) {
            if (setB.contains(x)) {
                result.add(x);
            }
        }
        return result.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
    */



    /*
    private static int backwardSumFromBackwardNumbers(int a, int b) {
        String result = "";
        String sa = String.valueOf(a), sb = String.valueOf(b);
        int carry = 0;
        int i = 0;
        while (i < sa.length() || i < sb.length() || carry > 0) {
            int sum = sum(sa, sb, i) + carry;
            carry = sum / 10;
            result += String.valueOf(sum % 10);
            i++;
        }
        return Integer.parseInt(result);
    }
    private static int sum(String sa, String sb, int i) {
        return (i < sa.length() ? sa.charAt(i) : 0) +
                (i < sb.length() ? sb.charAt(i) : 0);
    }
    */
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

    private static String reverseString(String s) {
        char[] arr = s.toCharArray();
        int l = 0, r = arr.length-1;
        while (l < r) {
            char tempL = arr[l];
            arr[l] = arr[r];
            arr[r] = tempL;
            l++;
            r--;
        }
        return String.valueOf(arr);
    }

    private static String revString(String s) {
        int len = s.length();
        if (len == 1) {
            return s;
        }
        return s.charAt(len-1) + revString(s.substring(0, len-1));
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

    private static int[] flattenMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[] result = new int[m*n];
        int resultIdx = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[resultIdx] = matrix[i][j];
                resultIdx++;
            }
        }
        return result;
    }

    private static void printArray(int[] arr) {
        for (int x : arr) {
            System.out.print(x + ",");
        }
    }

    private static class Coord {
        public int x, y;
        public Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Coord coord = (Coord) o;
            return x == coord.x && y == coord.y;
        }
        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    private static boolean isWordInMatrix(String s, char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        Set<Coord> visited = new HashSet<>();
        Queue<Coord> queue = new ArrayDeque<>();
        initQueue(matrix, m, n, s, queue, visited);
        int level = 0;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                Coord node = queue.remove();
                if (matrix[node.x][node.y] != s.charAt(level)) {
                    continue;
                } else if (level == s.length()-1) {
                    return true;
                }
                for (Coord neighbor : getNeighbors(node, m, n)) {
                    if (visited.contains(neighbor)) {
                        continue;
                    }
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
            level++;
        }
        return false;
    }

    private static void initQueue(char matrix[][], int m, int n, String s, Queue<Coord> queue, Set<Coord> visited) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == s.charAt(0)) {
                    Coord coord = new Coord(i,j);
                    queue.add(coord);
                    visited.add(coord);
                }
            }
        }
    }

    private static List<Coord> getNeighbors(Coord node, int m, int n) {
        List<Coord> neighbors = new ArrayList<>();
        int[][] tfs = {{0,-1},{1,0},{0,1},{-1,0}};
        for (int[] tf : tfs) {
            Coord newCoord = new Coord(node.x + tf[0], node.y + tf[1]);
            if (newCoord.x < 0 || newCoord.x > m-1 ||
                newCoord.y < 0 || newCoord.y > n-1) {
                continue;
            }
            neighbors.add(newCoord);
        }
        return neighbors;
    }

    private static void reverseArray(int[] nums, int l, int r) {
        while (l < r) {
            int tempL = nums[l];
            nums[l] = nums[r];
            nums[r] = tempL;
            l++;
            r--;
        }
    }

    private static boolean isPalindrome(String s) {
        int l = 0, r = s.length()-1;
        char[] arr = s.toCharArray();
        while (l < r) {
            if (arr[l] != arr[r]) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    /**
     * ex) gcd(10,20) -> gcd(20,10) -> gcd(10,0) -> 10
     * ex) gcd(3,5) -> gcd(5,3) -> gcd(3,2) -> gcd(2,1) -> gcd(1,1) -> gcd(1,0) -> 1
     *
     */
    private static int gcd(int a, int b) {
        //base case
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    /*
        0000 = 0
        0001 = 1
        0010 = 2
        0011 = 3
        0100 = 4
        0101 = 5
        0110 = 6
        0111 = 7
        1000 = 8
     */
    private static int unsignedBitShiftDivBy2(int x) {
        return x >>> 1;
    }

    private static int signedBitShiftDivBy2(int x) {
        return x >> 1;
    }

    private static int[] twoSumSorted(int[] arr, int trg) {
        int l = 0, r = arr.length-1;
        while (l < r) {
            int sum = arr[l] + arr[r];
            if (sum == trg) {
                return new int[]{l, r};
            } else if (sum < trg) {
                l++;
            } else {
                r++;
            }
        }
        return new int[]{};
    }

    private static int[] twoSumUnsorted(int[] arr, int trg) {
        Map<Integer, Integer> map = new HashMap<>(); //e:index
        for (int i = 0; i < arr.length; i++) {
            int x = arr[i], y = trg - x;
            if (map.containsKey(y)) {
                return new int[]{i, map.get(y)};
            } else {
                map.put(x, i);
            }
        }
        return new int[]{};
    }
}

class Node {
    public int val;
    public Node next;
    public Node(int val) {
        this.val = val;
    }
}

class HeapNode<T> {
    int key;
    int freq;
    T val;
    public HeapNode(int key, int freq, T val) {
        this.key = key;
        this.freq = freq;
        this.val = val;
    }
    @Override
    public String toString() {
        return "{key: " + key + ",freq: " + freq + ",val: " + val + "}";
    }
}
