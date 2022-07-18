package ooday05;

public class StaticDemo {
    public static void main(String[] args) {
        Moo.test(); //常常通过类名点来访问
    }
}

//演示静态方法
class Moo {
    int a; //实例变量(对象来访问)
    static int b; //静态变量(类名点来访问)

    void show() { //有隐式this
        System.out.println(this.a);
        System.out.println(Moo.b);
    }

    static void test() { //没有隐式this
//静态方法中没有隐式this传递，没有this就意味着没有对象，而实例变量a是必须通过对象点来访问的，所以如下语句发生编译错误
        //System.out.println(a); //编译错误
        System.out.println(Moo.b);
    }
}

//演示静态方法何时用
class Noo {
    int a; //实例变量（属于对象，描述对象的属性）

    //show()中需要访问对象的属性a，说明此方法与对象有关，不能设计为静态方法
    void show() {
        System.out.println(a);
    }

    //plus()中没有访问对象的属性或行为，说明此方法与对象无关，可以设计为静态方法
    static int plus(int num1, int num2) {
        int num = num1 + num2;
        return num;
    }
}

