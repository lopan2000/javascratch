package langfeatures.nestedclasses.staticinnerclasses;

public class MyClass {

    public int x = 1;
    public MyClass2 c2;

    public MyClass() {
        this.c2 = new MyClass2();
    }

    /*
    Static inner classes don't require an instance of the outer
    class to be instantiated.  So a client could write:
        MyClass.MyClass2 c2 = new MyClassMyClass2();
     */
    public static class MyClass2 {

        public int x = 2;
        private static int y = 100;
        public MyClass3 c3;

        public MyClass2() {
            this.c3 = new MyClass3();
        }

        public MyClass f() {
            return new MyClass();
        }

        /*
        Static inner classes don't require an instance of the outer
        class to be instantiated.  So a client could write:
            MyClass.MyClass2.MyClass3 c3 = new MyClass.MyClass2.MyClass3();
        */
        public static class MyClass3 {

            public int x = 3;

            public int getEnclosingY() {
                return y;
            }
        }
    }
}