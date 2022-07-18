package ooday07;

//匿名内部类的演示
public class NstInnerClassDemo {
    public static void main(String[] args) {
        //1)创建了Aoo的一个派生类，但是没有名字
        //2)为该派生类创建了一个对象，名为o1----向上造型为Aoo类型
        //  ---new Aoo(){}是在创建Aoo的派生类的对象
        //3)大括号中的为派生类的类体
        Aoo o1 = new Aoo() {

        };

        int num = 5;
        //1)创建了Boo的一个派生类，但是没有名字
        //2)为该派生类创建了一个对象，名为o3----向上造型为Boo类型
        //3)大括号中的为派生类的类体
        Boo o3 = new Boo() {
            void show() { //重写
                System.out.println("show");
                //num = 55; //编译错误，在此处会默认外面局部变量num为final
            }
        };
        o3.show();
    }
}

abstract class Boo {
    abstract void show();
}

abstract class Aoo {
}
