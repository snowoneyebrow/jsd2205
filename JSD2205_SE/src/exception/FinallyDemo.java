package exception;

/*
finally块：
finally块是异常处理机制的最后一块，它可以直接跟在try语句块之后或者最后一个catch之后。

finally的特点：
只要程序执行到try语句块中，无论try中语句是否出现异常，finally最后都必然执行。
通常我们会将释放资源这类操作放在finally中，确保最后一定会被执行，例如IO操作后的close()。
 */
public class FinallyDemo {
    public static void main(String[] args) {
        System.out.println("程序开始了");

        /*
        快捷键：ctrl+alt+T
        可以将选中的代码用指定的代码包围（比如for，while，try...catch等）
         */
        try {
            String line = null;
            System.out.println(line.length());
            return; //return也会执行finally中的代码
        } catch (Exception e) {
            System.out.println("出错啦");
        } finally {
            System.out.println("finally中的代码执行啦");
        }

        System.out.println("程序结束了");
    }
}
