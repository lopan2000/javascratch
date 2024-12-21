package langfeatures.nestedclasses.innerclasses;

public class Main {

    public static void main(String[] args) {

        MyClass c = new MyClass();
        System.out.println(c.x + "," + c.c2.x);
        System.out.println(c.c2.getEnclosingY());
    }
}
