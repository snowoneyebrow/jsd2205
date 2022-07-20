package reflect;

import reflect.annotations.AutoRunClass;
import reflect.annotations.AutoRunMethod;

@AutoRunClass
public class Student {

    @AutoRunMethod
    public void study() {
        System.out.println("student：good good study，day day up！");
    }
}
