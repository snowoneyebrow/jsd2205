public class Test {
    String str = new String("num");
    char[] arr = {'1', '2', '3'};

    public void change(String str, char[] arr) {
        str = "test";
        arr[0] = '0';
    }

    public static void main(String[] args) {
        Test ts = new Test();
        ts.change(ts.str, ts.arr);
        System.out.println(ts.str);
        System.out.println(ts.arr);
    }
}

