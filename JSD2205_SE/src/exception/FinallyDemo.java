package exception;

public class FinallyDemo {
    public static void main(String[] args) {
        System.out.println("程序开始了");

        //ctrl+alt+t
        try {
            String line = null;
            System.out.println(line.length());
            return; //也会执行finally中的代码
        } catch (Exception e) {
            System.out.println("出错啦");
        } finally {
            System.out.println("finally中的代码执行啦");
        }

        System.out.println("程序结束了");
    }
}
