package langfeatures;

import java.util.ArrayList;

public class Var {

    public static void main(String[] args) {
        //List<String> list = new ArrayList<>();
        var list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.forEach(System.out::println);
    }
}
