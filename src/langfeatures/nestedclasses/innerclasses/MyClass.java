package langfeatures.nestedclasses.innerclasses;

public class MyClass {

    public int x = 1;
    private int y = 100;
    public MyClass2 c2;

    public MyClass() {
        this.c2 = new MyClass2();
    }

    /*
    Existence of (non-static) inner class depends on an
    instance of MyClass.
     */
    public class MyClass2 {

        public int x = 2;

        public int getEnclosingY() {
            return y;
        }

        public MyClass f() {
            return new MyClass();
        }
    }
}
