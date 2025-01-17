package interview;

import java.util.ArrayList;

//Leetcode 2625 (only supports Javascript there)
public class FlattenDeeplyNestedArray {

    private static class MultiDimensionalArray extends ArrayList<Object> {}

    private static MultiDimensionalArray getFlattenResult(MultiDimensionalArray arr, int n) {
        MultiDimensionalArray result = new MultiDimensionalArray();
        flatten(arr, 0, n, result);
        return result;
    }

    private static void flatten(MultiDimensionalArray arr, int depth,
                                int n, MultiDimensionalArray result) {

        for (Object element : arr) {
            if (element instanceof MultiDimensionalArray && depth < n) {
                flatten((MultiDimensionalArray) element, depth+1, n, result);
            } else {
                result.add(element);
            }
        }
    }

    public static void main(String[] args) {
        //[1,2,3,[4,5,6],[7,8,[9,10,11],12],[13,14,15]]
        MultiDimensionalArray arr = new MultiDimensionalArray();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(new MultiDimensionalArray() {{
            add(4);
            add(5);
            add(6);
        }});
        arr.add(new MultiDimensionalArray() {{
            add(7);
            add(8);
            add(new MultiDimensionalArray() {{
                add(9);
                add(10);
                add(11);
            }});
            add(12);
        }});
        arr.add(new MultiDimensionalArray() {{
            add(13);
            add(14);
            add(15);
        }});

        int depth = 2;

        // Flatten the array and print the result.
        MultiDimensionalArray result = getFlattenResult(arr, depth);
        System.out.println(result);
    }
}
