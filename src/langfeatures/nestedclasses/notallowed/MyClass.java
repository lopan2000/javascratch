package langfeatures.nestedclasses.notallowed;

public class MyClass {

    public MyClass2 c2 = new MyClass2();

    public class MyClass2 {

        /*
        ERROR: a static inner class could only be directly nested in:
            1) a top-level class
            2) another static inner class
         */
        public static class MyClass3 {

            /* ERROR -- can't do this since constructing a MyClass2 deps on an instance of MyClass
            public MyClass2 f() {
                return new MyClass2();
            }
             */

            //but this is allowed
            public MyClass2 g() {
                return new MyClass().c2;
            }
        }
    }
}
