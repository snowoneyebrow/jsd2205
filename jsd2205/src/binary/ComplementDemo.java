package binary;

public class ComplementDemo {
    public static void main(String[] args) {
        /*
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        System.out.println(Integer.toBinaryString(max));
        System.out.println(Integer.toBinaryString(min));
        System.out.println(Integer.toBinaryString(-0));
         */

        int n=-7;
        System.out.println(Integer.toBinaryString(n));

        int m=-7; //按位取反再加1
        int o=~m+1;
        System.out.println(o);
    }
}
