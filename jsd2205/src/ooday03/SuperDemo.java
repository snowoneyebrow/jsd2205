package ooday03;

public class SuperDemo {
    public static void main(String[] args) {
        Boo o = new Boo();
    }
}

class Aoo {
    Aoo() {
        System.out.println("超类构造方法");
    }
}

class Boo extends Aoo {
    Boo() {
        super(); //没有调用超类构造方法，默认调用超类的无参构造方法
        System.out.println("派生类构造方法");
    }
}

class Coo {
    Coo(int a) {
    }
}

class Doo extends Coo {
    Doo() {
        super(5); //自己调用了超类构造方法，则不会再调用默认的super()
    }
    /*
    //如下代码为默认的
    Doo() {
        super();
    }
    */
}