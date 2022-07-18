package day06;

public class extra_1 {
    public static void main(String[] args) {
        int[] a = generate(10, 5);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    public static int[] generate(int len, int range) {
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = (int) (Math.random() * (range + 1));
        }
        return arr;
    }
}
