package ooday07;

//成员内部类的演示
public class InnerClassDemo {
    public static void main(String[] args) {
        Mama m = new Mama();
        //Baby b = new Baby(); //编译错误，内部类对外不具备可见性
        m.create().show();
    }
}

class Mama { //外部类
    private String name;

    Baby create() {
        Baby b = new Baby(); //正确，内部类对象通常在外部类中创建
        return b;
    }

    class Baby { //成员内部类
        void show() {
            System.out.println(name); //简写
            System.out.println(Mama.this.name); //完整写法
            //System.out.println(this.name); //编译错误，当前Baby类没有name属性
        }
    }
}
