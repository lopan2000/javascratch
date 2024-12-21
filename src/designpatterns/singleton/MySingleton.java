package designpatterns.singleton;

import java.io.Serial;
import java.io.Serializable;

public class MySingleton implements Serializable {

    private static final MySingleton INSTANCE = new MySingleton();
    private MySingleton() {}
    public static MySingleton getInstance() {
        return INSTANCE;
    }
    /*
    Ensures same instance upon serialize->deserialize.
    After deserialization, this readResolve is invoked
    and used in place of the newly created object which
    is GC'd.
     */
    private Object readResolve() {
        return INSTANCE;
    }
}