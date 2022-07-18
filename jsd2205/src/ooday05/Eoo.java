package ooday05;

//演示final修饰变量
class Eoo {
    final int a = 5;

    void show() {
        //a = 55; //编译错误，final的变量不能被改变
    }
}

//演示final修饰方法
class Foo {
    final void show() {
    }

    void test() {
    }
}

class Goo extends Foo {
    //void show(){} //编译错误，final的方法不能被重写
    void test() {
    }
}

