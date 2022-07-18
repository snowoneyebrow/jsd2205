package ooday01;

//方法重载的演示
public class OverloadDemo {
    public static void main(String[] args) {
        Aoo o = new Aoo();
        o.show();
        o.show(25);
        o.show("zhangsan");
        o.show("zhangsan", 25);
        o.show(25, "zhangsan");
    }
}