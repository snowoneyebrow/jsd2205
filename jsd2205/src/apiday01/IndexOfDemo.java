package apiday01;

public class IndexOfDemo {
    public static void main(String[] args) {
        String str = "thinking in Java";
        int index = str.indexOf("in");
        System.out.println(index);
        index = str.indexOf("in", 3);
        System.out.println(index);
        index = str.indexOf("WKJ");
        System.out.println(index);
        index = str.lastIndexOf("in");
        System.out.println(index);
    }
}
