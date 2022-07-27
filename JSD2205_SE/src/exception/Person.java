package exception;

/*
使用当前类测试异常的抛出
throw关键字可以主动对外抛出异常，通常下列两种场景会这样：
1、程序出现了异常，但是该异常不应当被当前代码片段处理时，可以主动将其抛出给调用者。
2、程序可以执行，但是不满足业务需求时，可以主动对外抛出一个异常。
本案例就是第2种情况
 */
public class Person {
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws IllegalAgeException {
        if (age < 0 || age > 100) {
            //throw new RuntimeException("年龄超出范围");
            /*
            当我们在一个方法中使用throw主动对外抛出一个异常时，
            除了RuntimeException这类异常之外，
            其它异常都应当使用throws在方法上声明该异常的抛出，
            来通知上层调用者处理该异常。
             */
            throw new IllegalAgeException("年龄超出范围");
        }
        this.age = age;
    }
}
