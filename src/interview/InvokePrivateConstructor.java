package interview;

import interview.privateconstructor.PrivateConstructor;

import java.lang.reflect.Constructor;

public class InvokePrivateConstructor {

    public static void main(String[] args) {
        try {
            //new PrivateConstructor(123); compile-time error

            Constructor<PrivateConstructor> constructor =
                    PrivateConstructor.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            constructor.newInstance();

            Class<?>[] paramTypes = {Integer.class};
            Constructor<PrivateConstructor> constructor2 =
                    PrivateConstructor.class.getDeclaredConstructor(paramTypes);
            constructor2.setAccessible(true);
            constructor2.newInstance(100);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
