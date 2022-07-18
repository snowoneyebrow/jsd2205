package apiday01;

public class StringBuilderDemo {
    public static void main(String[] args) {
        /*
        StringBuilder builder1 = new StringBuilder();

        StringBuilder builder2 = new StringBuilder("abc");

        String str1 = "def";
        StringBuilder builder3 = new StringBuilder(str1);

        StringBuilder builder4 = new StringBuilder("ghi");
        String str2 = builder4.toString();
         */

        String str="好好学习Java";
        StringBuilder builder=new StringBuilder(str);

        builder.append("，为了找个好工作");
        System.out.println(builder);

        builder.replace(9,16,"为了改变世界");
        System.out.println(builder);

        builder.delete(0,8);
        System.out.println(builder);

        builder.insert(0,"活着");
        System.out.println(builder);
    }
}
