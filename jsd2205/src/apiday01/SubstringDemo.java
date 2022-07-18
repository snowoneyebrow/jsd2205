package apiday01;

public class SubstringDemo {
    public static void main(String[] args) {
        String str = "www.tedu.cn";
        String name = str.substring(4, 8); //含头不含尾
        System.out.println(name);
        name = str.substring(4); //从这个数开始到结尾
        System.out.println(name);
    }
}
