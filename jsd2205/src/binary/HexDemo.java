package binary;

public class HexDemo {
    public static void main(String[] args) {
        

        int n = 0x67d78f6d;
        int m = n>>>1;
        int k = n>>>2;
        int g = n>>>8;
        System.out.println(Integer.toBinaryString(n));
        System.out.println(Integer.toBinaryString(n>>1));
        System.out.println(Integer.toBinaryString(m));
        System.out.println(Integer.toBinaryString(k));
        System.out.println(Integer.toBinaryString(g));
        /*
        11111
         */

    }
}
