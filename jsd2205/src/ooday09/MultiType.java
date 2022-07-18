package ooday09;

public class MultiType {
    public static void main(String[] args) {
        Aoo o = new Boo();
        Boo o1 = (Boo) o;
        Inter o2 = (Inter) o;

        if (o instanceof Coo) {
            Coo o4 = (Coo) o;
        } else {
            System.out.println("o不是Coo类型");
        }
    }
}
