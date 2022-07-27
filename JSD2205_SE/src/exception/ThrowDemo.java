package exception;

//异常的抛出
public class ThrowDemo {
    public static void main(String[] args) {
        Person p = new Person();

        try {
            /*
            当我们调用一个含有throws声明异常抛出的方法时，
            编译器要求我们必须处理这个异常，处理手段有两种：
            1、使用try-catch捕获并处理该异常
            2、在当前方法上继续使用throws声明这个异常的抛出通知上层调用者解决
            具体使用哪种要视异常处理的责任来确定。
             */
            p.setAge(2000); //满足语法，但是不满足业务
        } catch (IllegalAgeException e) {
            e.printStackTrace();
        }

        System.out.println("此人年龄：" + p.getAge());
    }
}
