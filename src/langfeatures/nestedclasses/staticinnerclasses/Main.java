package langfeatures.nestedclasses.staticinnerclasses;

public class Main {

    public static void main(String[] args) {

        MyClass c = new MyClass();
        System.out.println(c.x + "," + c.c2.x + "," + c.c2.c3.x);

        MyClass.MyClass2 c2 = new MyClass.MyClass2();
        System.out.println(c2.x + "," + c2.c3.x);

        MyClass.MyClass2.MyClass3 c3 = new MyClass.MyClass2.MyClass3();
        System.out.println(c3.x);
        System.out.println(c3.getEnclosingY());
    }
}
