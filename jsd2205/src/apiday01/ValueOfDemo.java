package apiday01;

public class ValueOfDemo {
    public static void main(String[] args) {
        int a = 123;
        String s1 = String.valueOf(a);
        System.out.println(s1);

        double b=123.456;
        String s2=String.valueOf(b);
        System.out.println(s2);

        //任意类型和字符串拼接都是字符串
        //但是效率低，不建议使用
        String s3=a+""+b;
        System.out.println(s3);
    }
}
